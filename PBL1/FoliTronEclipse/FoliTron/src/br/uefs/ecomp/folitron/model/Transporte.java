/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: <Washington Pagotto Batista>
 * Data:  <28/03/2014>
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

package br.uefs.ecomp.folitron.model;

import br.uefs.ecomp.folitron.util.Iterador;
import br.uefs.ecomp.folitron.util.ListaEncadeada;

public class Transporte 
{
	/**
	 * Essa classe implementa o comportamento do Transporte. Portando ela cont�m atributos de um Transporte
	 * id, nome,tipo, valor, capacidade,saida, localSaida, retorno, chegada,localChegada. 
	 * Al�m disso, ela armazena uma refer�ncia para as sess�es de Folioes.
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	private ListaEncadeada TRANSPORTEfolioes=new ListaEncadeada();
	private int id;
	private String nome;
	private String tipo;
	private double valor;
	private int capacidade;
	private int saida;
	private String localSaida;
	private int retorno;
	private String localRetorno;
	private int chegada;
	private String localChegada;
	private Bloco b1;
	
	
	/**
	 * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	 * 
	 * @param nome
	 * @param tipo
	 * @param valor
	 * @param capacidade
	 * @param saida
	 * @param localSaida
	 * @param retorno
	 * @param localRetorno
	 * @param chegada
	 * @param localChegada
	 * @param b1
	 */
	
	public Transporte(String nome, String tipo, double valor, int capacidade,int saida, 
			String localSaida,int retorno,String localRetorno, int chegada, String localChegada,Bloco b1)
	{
		
		
		this.nome=nome;
		this.tipo=tipo;
		this.valor=valor;
		this.capacidade=capacidade;
		this.saida=saida;
		this.localSaida=localSaida;
		this.retorno=retorno;
		this.localRetorno=localRetorno;
		this.chegada=chegada;
		this.localChegada=localChegada;
		this.b1=b1;
	}
	
	 /**
     * M�todo para retorno de um id do transporte.
     * 
     * @return int- numero de id.
     */
	public int getId()
	{
		return id;
	}
	 /**
     * M�todo para retorno de um nome do transporte.
     * 
     * @return String- nome 
     * 
     */
	public String getNome()
	{
		return nome;
	}
	 /**
     * M�todo para retorno de um tipo do transporte.
     * 
     * @return String- tipo do transporte utilizado.
     */
	public String getTipo()
	{
		return tipo;
	}
	 /**
     * M�todo para retorno de um valor do transporte.
     * 
     * @return double- valor do transporte utilizado.
     */
	public double getValor()
	{
		return valor;
	}
	 /**
     * M�todo para retorno de uma capacidade do transporte.
     * 
     * @return int- capacidade de vagas no transporte.
     */
	public int getCapacidade()
	{
		return capacidade;
	}
	 /**
     * M�todo para retorno de uma saida do transporte.
     * 
     * @return int- horario da saida do transporte.
     */
	public int getSaida()
	{
		return saida;
	}
	 /**
     * M�todo para retorno de um localSaida do transporte.
     * 
     * @return String- lugar a onde vai sair o transporte.
     */
	public String getLocalSaida()
	{
		return localSaida;
	}
	 /**
     * M�todo para retorno de um transporte.
     * 
     * @return int- horario de retorno do transporte
     */
	public int getRetorno()
	{
		return retorno;
	}
	 /**
     * M�todo para retorno de um localRetorno do transporte.
     * 
     * @return String- localiza�ao de onde vai retorna o transporte.
     */
	public String getLocalRetorno()
	{
		return localRetorno;
	}
	 /**
     * M�todo para retorno de uma chegada do transporte.
     * 
     * @return int- horario da chegada do transporte.
     */
	public int getChegada()
	{
		return chegada;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo localChegada. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param localChegada- local a onde vai chegar o transporte
	 */
	public String getLocalChegada()
	{
		return localChegada;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo bloco. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param bloco- b1
	 */
	public Object getBloco()
	{
		return b1;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo cpf. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param id- numero de identifica��o do transporte.
	 */
	public void setId(int id)
	{
		this.id=id;
		
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo nome. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param nome- pra onde o transporte vai
	 */
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo tipo. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param tipo- qual o tipo de transporte utilizado
	 */
	public void setTipo(String tipo)
	{
		this.tipo=tipo;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo valor. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param valor- pre�o da utiliza��o do transporte
	 */
	public void setValor(double valor)
	{
		this.valor=valor;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo capacidade. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param capacidade- quantas vagas tem no transporte.
	 */
	public void setCapacidade(int capacidade)
	{
		this.capacidade=capacidade;
		
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo saida. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param saida- horario da saida do transporte
	 */
	public void setSaida(int saida)
	{
		this.saida=saida;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo localSaida. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param localSaida- de onde vai sair o transporte.
	 */
	public void setLocalSaida(String localSaida)
	{
		this.localSaida=localSaida;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo retorno. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param retorno- qual o horario de retorno do transporte.
	 */
	public void setRetorno(int retorno)
	{
		this.retorno=retorno;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo LocalRetorno. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param localRetorno- qual o local de retorno.
	 */
	public void setLocalRetorno(String localRetorno)
	{
		this.localRetorno=localRetorno;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo chegada. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param chegada- horario da chegada do transporte.
	 */
	public void setChegada(int chegada)
	{
		this.chegada=chegada;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo localChegada. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param localChegada- a onde o transporte vai chegar.
	 */
	public void setLocalChegada(String localChegada)
	{
		this.localChegada=localChegada;
	}
	
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo bloco. E assim como � um m�todo void ele n�o
	 * tem retorno
	 * @param bloco-b1
	 */
    public void setBloco(Bloco b1)
    {
    	this.b1=b1;
    }
    /**
	   * Esse m�todo � utilizado na compara��o de atributos, e assim ele recebe como parametro um object
	   * do tipo obj. Sendo assim faz a verifica��o das compara��es pra ver se s�o iguais e retorna um boolean.
	   * 
	   * @param obj- Object.
	   * @return boolean
	   */
    public boolean equals(Object obj) 
    {
        //instanceof = verifica se o obj � da mesma classe usada
        if(obj instanceof Transporte)
        {
            Transporte t = (Transporte) obj;
            if(t.getNome().equals(getNome()) && t.getTipo().equals(getTipo()) && t.getValor() == getValor()
                    && t.getCapacidade() == getCapacidade() && t.getSaida() == getSaida() 
                    && t.getLocalSaida().equals(getLocalSaida()) && t.getRetorno() == getRetorno()
                    && t.getLocalRetorno().equals(getLocalRetorno()) && t.getChegada() == getChegada()
                    && t.getLocalChegada().equals(getLocalChegada()) && t.getBloco().equals(getBloco()))
            {
                
            	return true;
            }
        }
        
        return false;
        
     }
    
    /**
     * Esse m�todo compara os folioes e seus demais atributos caso exista dados duplicados ele retorna true ou se n�o
     * existir retorna false.
     * 
     * @param foliao
     * @return boolean.
     */
     public boolean comparacaoFoliao(Foliao foliao)
     {
		
		int x=TRANSPORTEfolioes.tamanho();
		
		for(int i=0; i<x;i++)
		{
			if(TRANSPORTEfolioes.recupera(i).equals(foliao))
			{
				return true;
			}
				
	    }
		return false;
	
     }

    /**
     * Esse m�todo serve para ver se a capacidade do transporte j� est� lotada, e se caso j� esteje ele
     * retorna true.
     * 
     * @return boolean
     */
     public boolean verificaCapacidade()
     {
	
	    int total=TRANSPORTEfolioes.tamanho();
	
	    if(capacidade==total)
	    {
		   return true;
	    }
	
	    return false;
     
     }
     /**
      * Esse m�todo insere foliao em Transportes.
      * 
      * @param foliao
      */
     public void insereFoliao(Foliao foliao)
     {
	
	    TRANSPORTEfolioes.insereFinal(foliao);
	
     }
     /**
      * Esse m�todo serve para varrer os dados
      * @return iterador
      */
     public Iterador iteradorTransporte()
    {
	    
	   return TRANSPORTEfolioes.iterador();
	
    }

}
