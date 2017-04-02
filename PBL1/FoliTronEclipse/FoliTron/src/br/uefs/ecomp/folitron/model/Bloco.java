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

public class Bloco 
{
	/**
	 * Essa classe implementa o comportamento do Bloco. Portando ela cont�m atributos de um Bloco
	 * id, nome,local e saida. Al�m disso, ela armazena uma refer�ncia para as sess�es de Transporte.
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */

	   private ListaEncadeada BLOCOtransporte= new ListaEncadeada();
	   private int id;
	   private String nome;
	   private String local;
	   private int saida;
	   
	   /**
	    * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	    * 
	    * @param nome- nome do bloco.
	    * @param local- o lugar a onde vai sair.
	    * @param saida- horario de saida.
	    */
	   public Bloco(String nome, String local,int saida)
	   {
			  
		   this.nome=nome;
		   this.local=local;
		   this.saida=saida;
		  
	   }

       /**
        * M�todo para retorno de um id do bloco.
        * 
        * @return int- numero de id.
        */
	   public int getId()
	   {
		  return id;
	   }
       
	   /**
        * M�todo para retorno do nome.
        * @return String- nome.
        */
	   
	   public String getNome()
	   {
		 return nome;
	   }
       
	   /**
	    * M�todo para um retorno do local de saida do bloco.
	    * 
	    * @return String-local.
	    */
	   
	   public String getLocal()
	   {
		return local;
	   }
       /**
        * M�todo para retorno do horario de saida do bloc.
        * 
        * @return int-saida.
        */
	   public int getSaida()
	  {
		return saida;
	  }
      /**
       * Esse m�todo � utilizado para modifica��o do atributo id. E assim como � um m�todo void ele n�o
       * tem retorno.
       * 
       * @param id- id gerado pra identifica��o.
       */
	  public void setId(int id)
	  {
		this.id=id;
	  }
	  /**
       * Esse m�todo � utilizado para modifica��o do atributo nome. E assim como � um m�todo void ele n�o
       * tem retorno.
       * 
       * @param nome- nome do bloco.
       */
	  public void setNome(String nome)
	  {
		
		this.nome=nome;
	  }
      
	  /**
       * Esse m�todo � utilizado para modifica��o do atributo local. E assim como � um m�todo void ele n�o
       * tem retorno.
       * 
       * @param local- local da saida do bloco.
       */
	  
	  public void setLocal(String local)
	  {
		this.local=local;
	  }
	  /**
       * Esse m�todo � utilizado para modifica��o do atributo saida. E assim como � um m�todo void ele n�o
       * tem retorno.
       * 
       * @param saida- horario da saida.
       * 
       */
	  public void setSaida(int saida)
	  {
		
		this.saida=saida;
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
		
		if(obj instanceof Bloco)
		{
			
			Bloco b=(Bloco) obj;
			
			if(b.getNome().equals(getNome()) && b.getLocal().equals(getLocal()) && b.getSaida() == getSaida())
			{ 
				return true; 
			} 
		}
		
		return false;
	  }
	
	  /** M�todo utilizado para inserir transporte em bloco, sendo assim � chamado dentro do m�todo
	   * o insereFinal para cadastrar.
	   * 
	   * @param Transporte- Transporte.
	   */
	
	  public void insereTransporte(Transporte Transporte)
	  {
		
		BLOCOtransporte.insereFinal(Transporte);
		
	  }

	  /**
	   * M�todo usado para utiliza��o do iterador que varre a estrutura de dados do 
	   * bloco.
	   * 
	   * @return iterador-BlocoTransporte.
	   */
	  public Iterador iteradorBloco()
	  {
		
		return BLOCOtransporte.iterador();
		
	  }

}
