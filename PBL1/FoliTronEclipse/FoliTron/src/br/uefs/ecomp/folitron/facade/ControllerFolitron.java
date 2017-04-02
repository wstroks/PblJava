/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: <Washington Pagotto Batista>
 * Data:  <01/04/2014>
 * 
 * Declaro que este c�digo foi elaborado por mim de forma individual e
 * n�o cont�m nenhum trecho de c�digo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p�ginas ou documentos 
 * eletr�nicos da Internet. Qualquer trecho de c�digo de outra autoria que
 * uma cita��o para o  n�o a minha est� destacado com  autor e a fonte do
 * c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins
 * de avalia��o. Alguns trechos do c�digo podem coincidir com de outros
 * colegas pois estes foram discutidos em sess�es tutorias.
 */



package br.uefs.ecomp.folitron.facade;

import br.uefs.ecomp.folitron.model.Bloco;
import br.uefs.ecomp.folitron.model.Foliao;
import br.uefs.ecomp.folitron.model.Transporte;
import br.uefs.ecomp.folitron.util.Iterador;
import br.uefs.ecomp.folitron.util.ListaEncadeada;


public class ControllerFolitron
{
	
	/**
	 * Essa classe implementa o comportamento do ControllerFolitron. 
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
    public ListaEncadeada blocos;
  	public ListaEncadeada transportes;
    public ListaEncadeada folioes;
	
    /**
	 * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	 */
    public ControllerFolitron()
    {
		
	    blocos=new ListaEncadeada();
	    transportes=new ListaEncadeada();
	    folioes=new ListaEncadeada();
	
	}
	/**
	 * Esse m�todo � utilizado para cadastrar os blocos. Sendo que ele chama o m�todo insereFinal para fazer o cadastro
	 *
	 * 
	 * @param nome- do bloco
	 * @param local- a onde vai sair o bloco.
	 * @param saida- horario de saida do bloco
	 * @return b- retorna o objeto que foi cadastrado
	 */
	public Bloco cadastrarBloco(String nome, String local, int saida)
	{
	
		int x=blocos.tamanho();
		Bloco b=new Bloco(nome,local,saida);
		b.setId(x+1);
		blocos.insereFinal(b);
		
		return b;
	}
	
	/**
	 * O m�todo obter bloco faz um busca por id do bloco usando outro m�todo que � o recupera.
	 * 
	 * @param id- numera��o do bloco
	 * @return b- retorna o bloco que deseja
	 */
	public Bloco obterBloco(int id)
	{
		
		Bloco b=(Bloco)blocos.recupera(id);
		return b;
	
	}
	/**
	 * Esse m�todo lista
	 * @param local- a onde ser� realizado o bloco.
	 * @param dataInicio- horario de incio. 
	 * @param dataFim- horario de termino do pbl.
	 * @return
	 */
	public Iterador listarBlocos(String local, int dataInicio, int dataFim)
	{

		int x=blocos.tamanho();
		ListaEncadeada aux=new ListaEncadeada();
		
		for(int i=0; i<x; i++)
		{
		
			Bloco b=(Bloco)blocos.recupera(i);
			 if(local.equals(b.getLocal())&& dataInicio>=b.getSaida()&&
                dataFim<=b.getSaida())
			 {
				 aux.insereFinal(blocos.recupera(i));
			 }
		}
		
		return aux.iterador();	

	}
	
    /**
     * O m�todo cadastra transporte, chama o metodo inserir transporte para o seu cadastro. E assim a cada cadastro vai 
     * gerando uma identifica��o que � o id
     * @param nome- nome do transporte
     * @param tipo- qual tipo de veiculo
     * @param valor- pre�o do transporte.
     * @param capacidade- quantas vagas existe
     * @param saida- horario de saida.
     * @param localSaida- a onde � localiza��o para a saida do transporte
     * @param retorno- qual horario do retorno
     * @param localRetorno- a onde � a localiza��o para o retorno do transporte.
     * @param chegada- que horas vai chegar.
     * @param localChegada- qual o local da chegada 
     * @param bloco
     * @return o objeto
     */
	public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, 
							int saida, String localSaida, int retorno, String localRetorno, 
							int chegada, String localChegada, Bloco bloco) 
	{
			
		 int x=transportes.tamanho();
		 Transporte t= new Transporte(nome,tipo,valor,capacidade,saida,localSaida,retorno,localRetorno,chegada,localChegada,bloco);
		
		 for(int i=0; i<x;i++)
		 {
			if(t.equals(transportes.recupera(i)))
			{
				return null;
			}
		
		 }
		 
		 t.setId(x+1);
		 bloco.insereTransporte(t);
		 return t;
	}
	/**
	 * Esse m�todo busca pela em transporte atrav�s do id a celula desejada. Sendo assim ele utiliza do m�todo recuperar e 
	 * retorna o objeto.
	 * @param id
	 * @return t- objeto
	 */
	public Transporte obterTransporte(int id) 
	{
	
		 Transporte t=(Transporte)transportes.recupera(id);
		 return t;
	}
	
	/**
	 * 
	 * @param bloco
	 * @return
	 */
	public Iterador listarTransportes(Bloco bloco)
	{
		return bloco.iteradorBloco();
	}
	
	/**
	 * Esse m�todo cadastra foliao. Sendo assim ele chama o m�todo insere final para fazer o seu cadastro.
	 * @param cpf-numero do cpf
	 * @param rg-numero do rg
	 * @param nome- nome do foliao
	 * @param idade- quantos anos tem 
	 * @return f-objeto
	 */
	public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade)
	{
	       
	    Foliao f=new Foliao(cpf,rg,nome,idade);
	    folioes.insereFinal(f);
	    return f;
	
	}
	
	/**
	 * Esse m�todo obtem o foliao atrav�s do cpf, sendo assim ele usa o recuperar pra quando achar o foliao 
	 * retorna o mesmo.
	 * @param cpf-numero do cpf
	 * @return o foliao desejado
	 */
	public Foliao obterFoliao(String cpf) 
	{
     
        int x=folioes.tamanho();
		for(int i=0; i<x;i++)
		{
			if(((Foliao) folioes.recupera(i)).getCpf().equals(cpf))
			{
				return (Foliao)folioes.recupera(i) ;
			}
				
	    }
	
		return null;
	}
	
	/**
	 * Esse m�todo regista os folioes em transporte, sendo que verifica a capacidade se n�o est� lotado e tamb�m se o foliao 
	 * est� cadastrado. Se as condi��es forem aceitas ele registra no transporte.
	 * @param foliao
	 * @param transporte
	 * @return boolean
	 */
	public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte){
		
		if(!transporte.verificaCapacidade() && !transporte.comparacaoFoliao(foliao))
		{
			transporte.insereFoliao(foliao);
			return true;
		}
		
		else
		{
		
			return false;
		}
		
	}
    /**
     * M�todo listar folioes, varre a estrutura de transporte para fazer registra o foliao.
     * @param transporte
     * @return
     */
	public Iterador listarFolioes(Transporte transporte)
	{
		
		return transporte.iteradorTransporte();
	}
	
	
	
}
