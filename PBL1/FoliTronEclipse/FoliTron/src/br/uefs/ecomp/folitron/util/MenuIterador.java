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

public class MenuIterador implements Iterador 

{
	/**
	 * Essa classe implementa o comportamento do MenuIterador. E ajuda a varrer a estrutura de dados.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	 private No novo;
	
	 /**
	  * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	  * @param novo-No
	  */
	 public MenuIterador(No novo)
	 {
		this.novo=novo;
		 
	 }
	 /**
	  * M�todo temProximo � usado para saber se existi um proximo ou ele � null, caso ele 
	  * for diferente de null ele retorna um true e se for igual a null retorna um false.
	  * 
	  * @return boolean
	  */
	@Override
	public boolean temProximo() 
	 {
		// TODO Auto-generated method stub
		if(novo!=null)
		{
			return true;
		}
		
		return false;
	 }

	/**
	 * O m�todo proximo � utilizado para pegar o proximo objeto da lista.
	 * @return null- caso for diferente de temProximo
	 * @return retorna o proximo objeto da lista.
	 */
	@Override
	public Object proximo() 
	{
		// TODO Auto-generated method stub
		Object auxiliar;
				
		if(!temProximo())
		{
			return null;
		}
		
		else
		{
			auxiliar=novo;
			novo=novo.getNext();
			return ((No) auxiliar).getDados();
		}
			
	
		
	 }

}
