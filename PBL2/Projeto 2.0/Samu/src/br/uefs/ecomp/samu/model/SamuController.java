/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Componente Curricular: M�dulo Integrado de Programa��o Autor: <Washington Pagotto Batista>
 * Data: <23/05/2014>
 *
 * Declaro que este c�digo foi elaborado por mim de forma individual e n�o
 * cont�m nenhum trecho de c�digo de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e p�ginas ou documentos eletr�nicos da
 * Internet. Qualquer trecho de c�digo de outra autoria que uma cita��o para o
 * n�o a minha est� destacado com autor e a fonte do c�digo, e estou ciente que
 * estes trechos n�o ser�o considerados para fins de avalia��o. Alguns trechos
 * do c�digo podem coincidir com de outros colegas pois estes foram discutidos
 * em sess�es tutorias.
 */

package br.uefs.ecomp.samu.model;

//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;

//import br.uefs.ecomp.samu.util.No;
import br.uefs.ecomp.samu.model.exception.AmbulanciasInsifucienteException;
import br.uefs.ecomp.samu.model.exception.AtendenteIndisponivelException;
import br.uefs.ecomp.samu.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.samu.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.samu.model.exception.CidadaoNaoEncontradoException;
import br.uefs.ecomp.samu.model.exception.OcorrenciaNaoEncontradaException;
import br.uefs.ecomp.samu.model.exception.QuantidadeDiferenteAmbulanciasException;
import br.uefs.ecomp.samu.util.Fila;
//import br.uefs.ecomp.samu.util.ILista;
import br.uefs.ecomp.samu.util.Iterador;
import br.uefs.ecomp.samu.util.ListaEncadeada;
import br.uefs.ecomp.samu.util.Pilha;

/**
*
* @author Washington Pagotto Batista
*/

public class SamuController
{

	//Atributos da classe
	private ListaEncadeada listaCidadoes;
	private ListaEncadeada listaAmbulancias;
	private ListaEncadeada listaAtendentes;
	private Pilha pilhaAmbulancias;
	private Fila filaAtendentes;
	private int idOcorrencias;
	private ListaEncadeada listaOcorrencias;
	private ListaEncadeada cidadoesOrdenado;
	private ListaEncadeada atendenteOrdenado;
	private ListaEncadeada ambulanciaOrdenado;

	//Construtor da classe.
	public SamuController()
	{

		listaCidadoes=new ListaEncadeada();
		listaAmbulancias= new ListaEncadeada();
		listaAtendentes= new ListaEncadeada();
		pilhaAmbulancias= new Pilha();
		filaAtendentes= new Fila();
		idOcorrencias=1;
		listaOcorrencias= new ListaEncadeada();
		cidadoesOrdenado= new ListaEncadeada();
		atendenteOrdenado= new ListaEncadeada();
		ambulanciaOrdenado= new ListaEncadeada();
	}



	/**
	 * M�todo que cadastrar o Cidadao.
	 * @param cpf-String
	 * @param nome-String
	 * @param endereco-String 
	 * @return o Objeto cadastrado
	 * @throws CadastroRepetidoException
	 */
	public Cidadao cadastrarCidadao(String cpf, String nome, String endereco) throws CadastroRepetidoException 
	{

		/* � criado um novo objeto do tipo cidadao com
		 * os valores passados por parametro e o cidadao � inserido no final da lista,
		 * por fim o objeto � retornado.
		 * 
		 */

		//variaveis da classe
		Object aux;

		Cidadao c= new Cidadao(cpf,nome,endereco);

		//criando um iterador de listaCidadoes.
		Iterador it= listaCidadoes.iterador();

		//condi��o que verifica se existe um proximo na lista.
		while(it.temProximo())
		{

			//assim o objeto do tipo Object, recebe o proximo.
			aux= it.proximo();

			//fazendo a compara��o pra ver se existe cadastro repetido.
			if(cpf.equals(((Cidadao) aux).getCpf()))
			{
				throw new CadastroRepetidoException();

			}

		}

		listaCidadoes.insereFinal(c);
		cidadoesOrdenado.insereOrdenado(nome);
		return c;
	}

	/**
	 * M�todo respons�vel por ordena os cidad�es.
	 * @return iterador
	 */
	public Iterador listarCidadaos() {

		//variaveis do m�todo
		int x=listaCidadoes.tamanho();//recebendo o tamanho da lista.
		int a,b;

		//Criando um objeto do tipo ListaEncadeada
		ListaEncadeada novo = new ListaEncadeada();


		for (a = 0; a< x; a++)
		{
			for (b = 0; b < x; b++) 
			{
				if (((Cidadao) listaCidadoes.recupera(b)).getNome().equals(cidadoesOrdenado.recupera(a))) {
					novo.insereFinal(listaCidadoes.recupera(b)); 
				}
			}
		}

		Iterador at=novo.iterador();
		return at;


	}


	/**
	 * M�todo que consulta a Divida do cidad�o.
	 * @param cpfCidadao- recebe um String
	 * @return a divida do cidadao
	 * @throws CidadaoNaoEncontradoException
	 */
	public double consultarDivida(String cpfCidadao) throws CidadaoNaoEncontradoException
	{

		//criando um objeto do tipo cidadao que recebe  o BuscaCidadao.
		Cidadao aux=buscaCidadao(cpfCidadao);

		if(aux!=null)
		{

			//retorna a divida do cidad�o.
			return aux.getDividaSamu();
		}
		//o cadastro n�o foi encontrado.
		else
		{
			throw new CidadaoNaoEncontradoException("");
		}


	}

	/**
	 * M�todo que pagar a divida do cidad�o
	 * @param cpfCidadao-String, para fazer a busca
	 * @param valor- double, para abater o valor na divida
	 * @throws CidadaoNaoEncontradoException
	 */
	public void pagarDivida(String cpfCidadao, double valor) throws CidadaoNaoEncontradoException 
	{
		//criando um objeto do tipo cidadao que recebe  o BuscaCidadao.
		Cidadao aux=buscaCidadao(cpfCidadao);

		//se aux for igual a null, o cadastro n�o foi encontrado.
		if(aux == null){
			throw new CidadaoNaoEncontradoException("");
		}

		/*
		 * sendo assim ele abate a divida que 
		 * o cidadao tem e assim alterando a mesma.
		 */
		buscaCidadao(cpfCidadao).setDividaSamu(aux.getDividaSamu()-valor);
	}

	/**
	 * M�todo que cadastra o Antendente.
	 * @param cpf-String
	 * @param nome-String
	 * @param endereco-String
	 * @param salario-Double
	 * @return o objeto do tipo atendente
	 * @throws CadastroRepetidoException
	 * @throws CapacidadeMaximaException
	 */
	public Atendente cadastrarAtendente(String cpf, String nome, String endereco, double salario) 
			throws CadastroRepetidoException, CapacidadeMaximaException
			{

		//criando um objeto do tipo object.
		Object aux;

		//criando um objeto do tipo atendente.
		Atendente lt= new Atendente(cpf,nome,endereco,salario);

		//criando um iterador de listaAtendentes.
		Iterador it= listaAtendentes.iterador();

		//Como s� s�o 5 atendentes, essa condi��o � feita que a capacidade maxima j� foi atingida se passar de 5.
		if(listaAtendentes.tamanho() == 5)
		{
			throw new CapacidadeMaximaException();
		}

		//condi��o que verifica se existe um proximo na lista.
		while(it.temProximo())
		{
			//assim o objeto do tipo Object, recebe o proximo.
			aux= it.proximo();

			//caso exista o atendente j� cadastrado.
			if(cpf.equals(((Atendente) aux).getCpf()))
			{
				throw new CadastroRepetidoException();

			}

		}

		//inserindo da lista e na fila
		atendenteOrdenado.insereOrdenado(nome);
		listaAtendentes.insereFinal(lt);
		filaAtendentes.insereFinal(lt);

		return lt;
			}
	/**
	 * M�todo que lista o atendentes em ordenado
	 * @return iterador 
	 */
	public Iterador listarAtendentes() 
	{
		//variaveis do m�todo
		int x=listaAtendentes.tamanho();//recebendo o tamanho da lista.
		int c,b;

		ListaEncadeada a = new ListaEncadeada();

		//ordenando a lista
		for (c = 0; c<x; c++) 
		{
			for (b = 0; b < x; b++) 
			{
				if (((Atendente) listaAtendentes.recupera(b)).getNome().equals(atendenteOrdenado.recupera(c))) 
				{
					a.insereFinal(listaAtendentes.recupera(b));
				}
			}
		}


		return a.iterador();

	}


	/**
	 * M�todo que lista os Atendentes disponiveis para atendimento.
	 * @return o iterador.
	 */

	public Iterador listarAtendentesDisponiveis() 
	{

		//criando um iterador.
		Iterador f=filaAtendentes.iterador();
		
		return f;
	}

	/**
	 * M�todo que cadastra a ambulancia.
	 * @param placa-String
	 * @return um objeto do tipo ambulancia
	 * @throws CadastroRepetidoException
	 * @throws CapacidadeMaximaException
	 */
	public Ambulancia cadastrarAmbulancia(String placa) throws CadastroRepetidoException, CapacidadeMaximaException
	{

		//criando um objeto do tipo object
		Object aux;

		//Criando um objeto do tipo ambulancia que recebe placa.
		Ambulancia a= new Ambulancia(placa);

		//criando um iterador de listaAmbulancias.
		Iterador it= listaAmbulancias.iterador();

		/*
		 * Como a garagem s� tem capacidade para 10 ambulancias, o tamanho da listaAmbulancia
		 * tem que ser 10. Pra que n�o tenha mais ambulancia do que a capacidade maxima.
		 */
		if(listaAmbulancias.tamanho()== 10)
		{
			throw new CapacidadeMaximaException();
		}

		//verifica se tem um proximo na lista.
		while(it.temProximo())
		{
			//assim o objeto do tipo Object, recebe o proximo.
			aux= it.proximo();

			//caso exista o atendente j� cadastrado.
			if(placa.equals(((Ambulancia) aux).getPlaca()))
			{
				throw new CadastroRepetidoException();

			}

		}

		//inserindo tanto na pilha e na lista.
		ambulanciaOrdenado.insereOrdenado(placa);
		listaAmbulancias.insereFinal(a);
		pilhaAmbulancias.insereTopo(a);

		return a;
	}

	/**
	 * M�todo que lista as ambulancias disponiveis.
	 * @return o iterador.
	 */

	public Iterador listarAmbulanciasDisponiveis() 
	{
		//Criando um iterador que recebe a pilhaAmbulancias.
		Iterador it = pilhaAmbulancias.iterador();
		return it;

	}

	/**
	 * M�todo lista ambulancias em ordenado
	 * @return
	 */
	public Iterador listarAmbulancias() 
	{
		//variaveis do m�todo.
		int x=listaAmbulancias.tamanho();
		int i,j;

		ListaEncadeada a = new ListaEncadeada();
		//ordenando a lista.
		for (i = 0; i < x; i++) 
		{
			for (j = 0; j < x; j++) 
			{
				if (((Ambulancia) listaAmbulancias.recupera(j)).getPlaca().equals(ambulanciaOrdenado.recupera(i)))
				{
					a.insereFinal(listaAmbulancias.recupera(j)); 
				}
			}
		}


		return a.iterador();
	}



	/**
	 * M�todo que cadastrar a Ocorrencia.
	 * @param cpf-String
	 * @param qtdAmbulancias-inteiro
	 * @return o id da ocorrencia.
	 * @throws CidadaoNaoEncontradoException
	 * @throws AtendenteIndisponivelException
	 */
	public int cadastrarOcorrencia(String cpf, int qtdAmbulancias) 
			throws CidadaoNaoEncontradoException, AtendenteIndisponivelException
			{

		/*
		 * Criando um objeto do tipo Ocorrencia que recebe IdOcorrencias e QtdAmbulancias.
		 * Criando um objeto do tipo cidadao que recebe cidadao que fez a ocorrencia.
		 */
		Ocorrencia o = new Ocorrencia(idOcorrencias,qtdAmbulancias);
		Cidadao aux=buscaCidadao(cpf);

		//Caso n�o tenha nenhum atendente disponivel para atendimento.
		if(aux!=null)
		{
			if(filaAtendentes.tamanho() == 0){
				throw new AtendenteIndisponivelException();
			}
		}
		else{
			throw new CidadaoNaoEncontradoException();
		}



		o.setCidadao(aux);

		o.setAtendente(filaAtendentes.removeInicio());

		idOcorrencias++;
		listaOcorrencias.insereFinal(o);
		buscaCidadao(cpf).setQtdOcorrencias(aux.getNumOcorrenciasSolicitadas()+1);
		return o.getId();

			}


	/**
	 * M�todo que atende as Ocorrencias.
	 * @param idOcorrencia-inteiro
	 * @throws OcorrenciaNaoEncontradaException
	 * @throws AmbulanciasInsifucienteException
	 * @throws QuantidadeDiferenteAmbulanciasException
	 */
	public void atenderOcorrencia(int idOcorrencia) 
			throws OcorrenciaNaoEncontradaException, AmbulanciasInsifucienteException,
			QuantidadeDiferenteAmbulanciasException 
			{

		//declara��o de variaveis.
		int i;
		Atendente aux;
		Ocorrencia o = consultarOcorrencia(idOcorrencia);

		/*
		 * se o tamanho da pilha for menor que a quantidade de ambulancias, 
		 * ir� apresenta ambulancias insuficientes.
		 */
		if(pilhaAmbulancias.tamanho()<o.getQtdAmbulancias())
		{
			throw new AmbulanciasInsifucienteException();

		}

		/*
		 * ListaOcorrencia recupera e busca a onde est� na lista a ocorrencia,  remove de PilhaAmbulancias pois agora 
		 * a ambulancia est� em atendimento e n�o se encontra mais disponivel. 
		 */
		for(i=0;i<o.getQtdAmbulancias();i++)
		{
			((Ocorrencia)listaOcorrencias.recupera(idOcorrencia-1)).insereAmbulancia((Ambulancia)pilhaAmbulancias.removeTopo());
		}

		//recebe o atendente que est� gerando a ocorrencia.
		aux = o.getAtendente();

		//modifica a quantidades de atendimentos.
		aux.setQtdAtendimentos(aux.getQtdAtendimentos()+1);

		//insere na fila
		filaAtendentes.insereFinal(aux);

		//recupera a posi��o a onde o id da ocorrencia se encontra e modifica o status dela.
		((Ocorrencia)listaOcorrencias.recupera(idOcorrencia-1)).setStatus("Em Atendimento");

			}

	/**
	 * M�todo que finaliza a Ocorrencia.
	 * @param idOcorrencia-inteiro 
	 * @throws OcorrenciaNaoEncontradaException
	 */
	public void finalizarOcorrencia(int idOcorrencia) throws OcorrenciaNaoEncontradaException 
	{

		//Criando um objeto do tipo cidadao.
		Cidadao c;

		//criando um objeto do tipo cidadao que recebe IdOcorrencia.
		Ocorrencia o = consultarOcorrencia(idOcorrencia);

		c = o.getCidadao();

		/*
		 * Buscando o cidadao e acrescentando uma divida de 10 reais.
		 */
		buscaCidadao(c.getCpf()).setDividaSamu(c.getDividaSamu()+10);

		/*
		 * Inserindo topo na Pilha j� que a ocorrencia foi finalizada a ambulancia agora est� disponivel,
		 * e remove a Ambulancia da lista.
		 */
		for(int i=0;i<o.getQtdAmbulancias();i++)
		{
			pilhaAmbulancias.insereTopo(((Ocorrencia)listaOcorrencias.recupera(idOcorrencia-1)).removeAmbulancia());
		}

		//alterando o Status da Ocorrencia.
		((Ocorrencia)listaOcorrencias.recupera(idOcorrencia-1)).setStatus("Finalizada");

	}


	/**
	 * M�todo que listar as Ocorrencias que est�o Ativas.
	 * @return o iterador.
	 */
	public Iterador listarOcorrenciasAtivas() 
	{
		/*
		 * criando um objeto do tipo Ocorrencia.
		 * Criando um objeto do tipo ListaEncadeada.
		 * Criando um iterador de listaOcorrencias.
		 */
		Ocorrencia aux;
		ListaEncadeada ativas= new ListaEncadeada();
		Iterador it= listaOcorrencias.iterador();

		//verifica se tem um proximo na lista.
		while(it.temProximo())
		{

			//assim o objeto do tipo Ocorrencia, recebe o proximo.
			aux=(Ocorrencia) it.proximo();

			//se a Ocorrencia estiver ativa ele insere em Ativas.
			if(aux.estaAtiva())
			{
				ativas.insereFinal(aux);
			}

		}

		//retornando o iterador.
		return ativas.iterador();
	}



	/**
	 * M�todo que consulta Ocorrencia.
	 * @param idOcorrencia-inteiro
	 * @return retorna o objeto do tipo Ocorrencia.
	 * @throws OcorrenciaNaoEncontradaException
	 */
	public Ocorrencia consultarOcorrencia(int idOcorrencia) throws OcorrenciaNaoEncontradaException
	{

		/*
		 * Criando um objeto do tipo Ocorrencia.
		 * Criando um iterador de listaOcorrencias.
		 */
		Ocorrencia aux;
		Iterador it=listaOcorrencias.iterador();

		//verifica se tem um proximo na lista.
		while(it.temProximo())
		{
			//assim o objeto do tipo Ocorrencia, recebe o proximo.
			aux=(Ocorrencia) it.proximo();

			//verificando se o id � igual ao idOcorencia, pra encontrar a ocorrencia.
			if(aux.getId() ==idOcorrencia)
			{
				return aux;
			}
		}

		//caso n�o encontre a ocorrencia.
		throw new OcorrenciaNaoEncontradaException();
	}

	/**
	 * M�todo adiconado no controller para Buscar Cidadao.
	 * @param cpf-String
	 * @return verdade caso ache o cidadao, se n�o achar false.
	 */
	private Cidadao buscaCidadao(String cpf)
	{

		/*
		 * Criando um objeto do tipo cidadao.
		 * Criando um boolean para fazer a verifica��o.
		 * Criando um iterador que recebe listaCidadoes.
		 */

		Cidadao novo=null;
		boolean achou=false;
		Iterador it=listaCidadoes.iterador();

		//verifica se tem um proximo na lista e tamb�m se j� encontrou o cidadao.
		while(it.temProximo() && !achou)
		{
			//assim o objeto do tipo Cidadao recebe o proximo.
			novo=(Cidadao) it.proximo();

			//fazendo a busca do cidad�o
			if(cpf.equals(novo.getCpf())){
				achou=true;
			}

		}

		return novo;
	}


}
