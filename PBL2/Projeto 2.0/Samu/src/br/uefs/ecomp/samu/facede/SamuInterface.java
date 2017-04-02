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

package br.uefs.ecomp.samu.facede;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import br.uefs.ecomp.samu.model.Ambulancia;
import br.uefs.ecomp.samu.model.Atendente;
import br.uefs.ecomp.samu.model.Cidadao;
import br.uefs.ecomp.samu.model.Ocorrencia;
import br.uefs.ecomp.samu.model.Pessoa;
import br.uefs.ecomp.samu.model.exception.AmbulanciasInsifucienteException;
import br.uefs.ecomp.samu.model.exception.AtendenteIndisponivelException;
import br.uefs.ecomp.samu.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.samu.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.samu.model.exception.CidadaoNaoEncontradoException;
import br.uefs.ecomp.samu.model.exception.OcorrenciaNaoEncontradaException;
import br.uefs.ecomp.samu.model.exception.QuantidadeDiferenteAmbulanciasException;
import br.uefs.ecomp.samu.util.Console;
import br.uefs.ecomp.samu.util.Iterador;

/**
*
* @author Washington Pagotto Batista
*/
public class SamuInterface {

	static SamuFacade facade;
	static Console console;  

	public static void main(String[] args) throws IOException{

		//criando um objeto.
		facade=new SamuFacade();
		console= new Console();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//variavel
		int digitado;
		boolean repeticao=false;

		//estrutura de repeti��o, feita atraves de um boolean
		while(!repeticao){

			//op��es que o menu oferece
			System.out.println("1-Cadastrar cidad�o");
			System.out.println("2-Listar cidad�es");
			System.out.println("3-Consultar Divida");
			System.out.println("4-Pagar divida");
			System.out.println("5-Cadastrar Atendente");
			System.out.println("6-Listar Atendentes");
			System.out.println("7-Listar Atendentes dispon�veis");
			System.out.println("8-Cadastrar Ambulancia");
			System.out.println("9-Listar ambulancias dispon�veis");
			System.out.println("10-Listar ambul�ncias");
			System.out.println("11-Cadastrar ocorr�ncia");
			System.out.println("12-Atender Ocorr�ncia");
			System.out.println("13-Finalizar Ocorr�ncia");
			System.out.println("14-Listar ocorr�ncia");
			System.out.println("15-Consultar Ocorr�ncia");
			System.out.println("16-Sair");

			System.out.println("Digita a op�ao que deseja");
			digitado=console.readInt();

			switch(digitado){

			case 1:
				//Cadastrar cidad�o
				try{
					//sendo executado pra pegar cpf, nome e endere�o
					System.out.println("Digite seu cpf:");
					String cpf=console.readString();

					System.out.println("Digite o seu nome:");
					String nome = console.readString();
					//String cpf=console.readString();

					System.out.println("Digite seu endere�o:");
					String endereco=console.readString();

					facade.cadastrarCidadao(cpf,nome,endereco);

				}
				catch(CadastroRepetidoException o)
				{
					System.out.println("Dados j� cadastrados!");
				}

				break;


			case 2:
				/*
				 * Criando um iterador para listar os cidadoes
				 */
				Iterador at = facade.listarCidadaos();
				System.out.println("Lista de Cidad�es!\n");
				
				while (at.temProximo()) //verificando se tem um proximo.
				{
					Cidadao temp =  (Cidadao) at.proximo(); //objeto do tipo cidadao recebendo o proximo
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endere�o:"+temp.getEndereco());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 3:

				/*
				 * Tratando as exce��es para consultar a divida.
				 */
				try
				{

					System.out.println("Digite o cpf:");
					String cpfCidadao=console.readString();

					System.out.println(facade.consultarDivida(cpfCidadao));
				}
				catch( CidadaoNaoEncontradoException o)//exce��o caso n�o encontre o cpf.
				{

					System.out.println("Cidad�o nao encontrado!");
				}
				break;

			case 4:
				/*
				 * Tratando as exce��es para pagar divida
				 */
				try
				{
					System.out.println("Digite seu cpf:");
					String cpfCidadao= console.readString();

					System.out.println("Digite o valor a ser pago:");
					double valor = Console.readDouble();

					facade.pagarDivida(cpfCidadao, valor);
				}
				catch(CidadaoNaoEncontradoException o)//caso n�o encontre o cidadao
				{
					System.out.println("Dados n�o encotrado!");
				}

				break;

			case 5:

				/*
				 * Tratando as exce��es para para cadastrar atendente.
				 */
				try
				{

					System.out.println("Digite seu cpf:");
					String cpf=console.readString();

					System.out.println("Digite o seu nome:");
					String nome = console.readString();
					//String cpf=console.readString();

					System.out.println("Digite seu endere�o:");
					String endereco=console.readString();

					System.out.println("Digite o valor do sal�rio:");
					double salario=console.readDouble();

					facade.cadastrarAtendente(cpf, nome, endereco, salario);

				}
				catch(CadastroRepetidoException e)// caso o cpf j� exista.
				{
					System.out.println("Dados j� cadastrados!");
				}
				catch(CapacidadeMaximaException m)//pois a capacidade maxima � 5 
				{
					System.out.println("j� est� com o maximo possivel de atendentes!");
				}
				break;

			case 6:
				/*
				 * Listando os atendentes, criando um iterador que recebe o metodo do facade.
				 */
				Iterador ut = facade.listarAtendentes();
				System.out.println("Lista de Atendentes!\n");
				while (ut.temProximo())//verificando se existe um proximo
				{
					Atendente temp = (Atendente)ut.proximo();//objeto recebendo um proximo
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endere�o:"+temp.getEndereco());
					System.out.println("Sal�rio:"+((Atendente) temp).getSalario());
					System.out.println("\n");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 7:

				/*
				 * Listando atendentes disponiveis.
				 */
				Iterador it = facade.listarAtendentesDisponiveis();
				System.out.println("Lista de Atendentes Disponiveis!\n");
				while (it.temProximo()) //verificando se tem um proximo.
				{
					Atendente temp = (Atendente) it.proximo();//recebendo um proximo do iterador
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endere�o:"+temp.getEndereco());
					System.out.println("Sal�rio:"+((Atendente) temp).getSalario());
					System.out.println("\n");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;
			case 8:
				/*
				 * Tratando as exce��es para cadastrar ambulancia
				 */
				try
				{
					System.out.println("Digite o numero da placa da ambul�ncia:");
					String placa=console.readString();

					facade.cadastrarAmbulancia(placa);
				}
				catch(CadastroRepetidoException c)//caso a ambulancia j� esteja cadastrada
				{
					System.out.println("Ambul�ncia ja cadastrada!");

				}
				catch( CapacidadeMaximaException c)//caso a ambulancia o numero de ambulancias passe das 10.
				{
					System.out.println("Capacidade de ambul�ncias maxima antingida!");
				}

				break;

			case 9:

				/*
				 * Listando ambulancias disponiveis para atendimento, criando um interador e imprimindo o mesmo
				 */
				Iterador rt = facade.listarAmbulanciasDisponiveis();
				System.out.println("Lista de Ambul�ncias Disponiveis!\n");
				while (rt.temProximo())//verificando se existe um proximo
				{

					Ambulancia temp =  (Ambulancia) rt.proximo();//objeto ambulancia recebe um proximo
					System.out.println("Placa:"+temp.getPlaca());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 10:

				/*
				 * Lista ambulancias existentes.
				 */
				Iterador mt = facade.listarAmbulancias();
				System.out.println("Lista de ambul�ncias!");
				while (mt.temProximo()) //verificando se existi um proximo
				{
					Ambulancia temp =  (Ambulancia) mt.proximo();//objeto do tipo ambulancia recebe o proximo
					System.out.println("Placa:"+temp.getPlaca());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine();

				break;

			case 11:

				/*
				 * Tratando cadastrar ocorrencia.
				 */
				try{
					System.out.println("Digite o cpf:");
					String cpf=console.readString();

					System.out.println("Digite o numero de ambul�ncias:");
					int qtdAmbulancias=console.readInt();
					facade.cadastrarOcorrencia(cpf, qtdAmbulancias);
				}
				catch(CidadaoNaoEncontradoException m)//caso o cidadao n�o esteje cadastrado.
				{
					System.out.println("Cidad�o n�o encontrado no cadastro!");
				}

				catch(AtendenteIndisponivelException m)//todos atendentes est�o ocupados.
				{
					System.out.println("Todos atendentes ocupados!");
				}
				break;

			case 12:

				/*
				 * Tratando atender ocorrencia.
				 */
				try{
					System.out.println("Digite o numero da Ocorr�ncia:");
					int idOcorrencia=console.readInt();
					facade.atenderOcorrencia(idOcorrencia);
				}
				catch(AmbulanciasInsifucienteException o)
				{
					System.out.println("Ambul�ncias insuficientes para atendimento!");
				}
				catch(OcorrenciaNaoEncontradaException a)//ocorrencia n�o encotrada
				{
					System.out.println("Ocorrencia n�o foi encontrada!");
				}
				catch(QuantidadeDiferenteAmbulanciasException q)// quantidade diferente.
				{
					System.out.println("Quantidade diferente!");
				}
				break;
			case 13:

				/*
				 * Tratando finalizar ocorrencia
				 */
				try
				{
					System.out.println("Digite o numero da Ocorr�ncia:");
					int idOcorrencia=console.readInt();
					facade. finalizarOcorrencia(idOcorrencia);
				}

				catch(OcorrenciaNaoEncontradaException a)//ocorrencia n�o encontrada.
				{
					System.out.println("Ocorr�ncia n�o foi encontrada!");
				}
				break;

			case 14:

				/*
				 * listando ocorrencias ativas
				 */
				Iterador ot = facade.listarOcorrenciasAtivas();
				System.out.println("Lista de Ocorrencias Ativas!\n");
				while (ot.temProximo()) //verifica se existe um proximo.
				{
					Ocorrencia temp =  (Ocorrencia) ot.proximo();//objeto do tipo ocorrencia recebe o proximo
					System.out.println("Id:"+temp.getId());
					System.out.println("Status:"+temp.getStatus());
					System.out.println("Quantidadade de ambulancias:"+temp.getQtdAmbulancias());
					System.out.println("\n");
				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 15:

				/*
				 * consultar ocorrencia.
				 */
				try
				{

					
					System.out.println("Digite a id da ocorr�ncia que deseja recuperar:");
					int idOcorrencia = console.readInt();
					Ocorrencia a=facade.consultarOcorrencia(idOcorrencia);//objeto do tipo ocorrencia recebe o que deseja consultar

					System.out.println("Id: " + a.getId());
					System.out.println("Nome do cidad�o que solicitou a ocorr�ncia: " + a.getCidadao().getNome());                        
					System.out.println("Quantidades de ambul�ncias solicitadas: " + a.getQtdAmbulancias());
					System.out.println("Status: " + a.getStatus());
					System.out.println("Nome da atendente que registrou a ocorr�ncia: " + a.getAtendente().getNome()); 

				}

				catch(OcorrenciaNaoEncontradaException a)//caso n�o esteje cadastrado
				{
					System.out.println("Ocorrencia n�o foi encontrada!");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine();
				break;

			case 16:
				//condi��o que sair do while.
				repeticao=true;
				break;
			
			default:

				System.out.println("Op�ao s� � de 1 � 16");
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;
			}
		}
	}

}
