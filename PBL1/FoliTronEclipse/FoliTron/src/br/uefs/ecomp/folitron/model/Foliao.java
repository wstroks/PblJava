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


public class Foliao 
{
	/**
	 * Essa classe implementa o comportamento do Foliao. Portando ela cont�m atributos de um Foliao
	 * cpf, rg,nome e idade. 
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
	 
	   private String cpf;
	   private String rg;
	   private String nome;
	   private int idade;
	   
	   /**
	    * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	    * 
	    * @param cpf- numero do cpf
	    * @param rg- numero do rg
	    * @param nome- nome do foliao
	    * @param idade- quantos anos ele tem
	    */
	   public Foliao(String cpf, String rg,String nome, int idade)
	   {
		   
		   this.cpf=cpf;
		   this.rg=rg;
		   this.nome=nome;
		   this.idade=idade;
		   
	   }
		/**
		 * M�todo que retorna o numero do cpf
		 * 
		 * @return String-cpf
		 */
		public String getCpf()
		{
			return cpf;
		}
		/**
		 * M�todo que retorna o numero do rg
		 * 
		 * @return String- Rg
		 */
		public String getRg()
		{
			return rg;
		}
		
		/**
		 * M�todo que retorna o nome do foliao
		 * @return String-Nome
		 */
		public String getNome()
		{
			return nome;
		}
        /**
         * M�todo que retorna a idade do foliao
         * @return int- idade
         */
		public int getIdade()
		{
			return idade;
		}

		/**
		 * Esse m�todo � utilizado para modifica��o do atributo cpf. E assim como � um m�todo void ele n�o
		 * tem retorno
		 * @param cpf- numero do cpf
		 */
		public void setCpf(String cpf)
		{
			this.cpf=cpf;
		}

        /**
         * Esse m�todo � utilizado para modifica��o do atributo rg. E assim como � um m�todo void ele n�o
         * tem retorno  
         * @param rg- numero do rg
         */
		public void setRg(String rg)
		{
			
			this.rg=rg;
		}
        /**
         * Esse m�todo � utilizado para modifica��o do atributo nome. E assim como � um m�todo void ele n�o
         * tem retorno
         * @param nome
         */
		public void setNome(String nome)
		{
			this.nome=nome;
		}

	    /**
	     * Esse m�todo � utilizado para modifica��o do atributo idade. E assim como � um m�todo void ele n�o
	     * tem retorno
	     * @param idade- quantos anos o foliao tem.
	     */
		public void setIdade(int idade)
		{
			this.idade=idade;
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
			
			if(obj instanceof Foliao)
			{ 
				
				Foliao f = (Foliao) obj; 
				
				if(f.getCpf().equals(getCpf()) && f.getRg().equals(getRg()) && f.getNome().equals(getNome()) 
						&& f.getIdade() == getIdade())
				{ 
					
					return true; 
				} 
			} 
			
			return false;
		}
		
}
