/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: <Washington Pagotto Batista>
 * Data:  <30/03/2014>
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

package br.uefs.ecomp.folitron.util;

public class ListaEncadeada implements ILista 
{
	
	/**
	 * Essa classe implementa o comportamento do ListaEncadeada.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	private int tamanho=0;
	private No atual;
	private No anterior;
	private No ultimo;
	
	/**
	 * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	 */
	public ListaEncadeada()
	{
		
		atual=null;
		anterior=null;
		ultimo=null;
	}
	
	/**
	 * Esse metodo verifica se a lista encadeada est� vazia caso o tamanho seje zero ele retorna false, se for diferente
	 * retorna true.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean estaVazia()
	{
		// TODO Auto-generated method stub
		if(tamanho!=0)
		{
			return false;
		}
		
		return true;
	}
    
	/**
     * Esse m�todo verifica o tamanho da lista encadeada.
     * 
     * @return int- tamanho da lista encadeada.
     */
	@Override
	public int tamanho() 
	{
		// TODO Auto-generated method stub
		
		return tamanho;
	}
    
	/**
	 * Esse m�todo � do tipo void, portando n�o retorna nada. Serve para inserir no incio da lista
	 * o objeto.
	 * 
	 * @param object
	 */
	@Override
	public void insereInicio(Object o) 
	{
		// TODO Auto-generated method stub
		No novo=new No(o);
		novo.setNext(atual);
		atual=novo;
		
		if(this.tamanho==0)
		{
			this.ultimo=atual;
		}
		
		tamanho++;
		
	}
    
	/**
     * Esse m�todo insere o objeto no final da lista, sendo assim como ela � void n�o apresenta retorno. Com isso a primeira
     * condi��o � se o a lista j� foi criada caso n�o ela chamar� o m�todo insereInicio.
     * 
     * @param object
     */
	
	@Override
	public void insereFinal(Object o) 
	{
		// TODO Auto-generated method stub
		
		if (tamanho == 0) 
		{
	         this.insereInicio(o);
	    } 
		
		else 
		{
	         No nova = new No(o);
	         nova.setNext(null);
	         while(atual==null)
	         {
	        	 this.ultimo = nova;
		         this.atual=nova;
	         }
	        
	         ultimo.setNext(nova);
	         this.ultimo=nova;
	         tamanho++;
	     }
	    
	   
	}
    
	/**
     * Este m�todo remove incio da lista, sendo assim a primeira verifica��o � caso a lista esteje vazia.Com isso
     * a lista ser� apontada pro proximo sempre decrementando.
     * 
     * @return apontando pro primeiro da lista
     */
	@Override
	public Object removeInicio() 
	{
		// TODO Auto-generated method stub
		No novo=atual;
		if( estaVazia())
		{
			return null;
		}
		
		atual=atual.getNext();
		tamanho--;
		return novo.getObject(); 
		
	}
    
	/**
     * Esse m�todo remove o ultimo elemento da lista encadeada. A primeira verifica��o � se a lista est� vazia e caso verdade
     * ele retorna um null. A segunda verifica��o � caso s� exista uma celula na lista.
     * @return que est� vazia
     * @return retorna a inst�ncia do objeto 
     */
	@Override
	public Object removeUltimo() 
	{
		// TODO Auto-generated method stub
		
		No novo=atual;
		if(estaVazia())
		{
			return null;
		}
		
		if(tamanho==1)
		{
			novo=atual;
			atual=null;
			
		}
		
		while(novo.getNext()!=null)
		{
			anterior=novo;
			novo=novo.getNext();
		}
		anterior.setNext(null);
		tamanho--;
		return novo.getObject();
		
	}
    
	/**
     * M�todo recupera serve pra buscar uma celula que ele deseja. Sendo que essa celula � buscada na lista atrav�s do index
     * que passa a posi��o que deseja.
     * @param int-index 
     * 
     */
	@Override
	public Object recupera(int index) 
	{
		// TODO Auto-generated method stub
		int auxiliar=0;
		No novo=atual;
		
		while((auxiliar!=index))
		{
			if(novo!=null)
			{ 
			novo=novo.getNext();
		    auxiliar++;
			}
		}
		
		return novo.getObject();
	}
    
	/**
     * Esse m�todo serve para varrer uma estrutura de dados.
     * @return iterador recebe atual e retorna o mesmo
     */
	@Override
	public Iterador iterador() 
	{
		// TODO Auto-generated method stub
		
		Iterador iterador = new MenuIterador (atual);
		return iterador;
	}

}
