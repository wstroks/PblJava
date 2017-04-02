/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: <Washington Pagotto Batista>
 * Data:  <29/03/2014>
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

public class No 
{
	/**
	 * Essa classe implementa o comportamento do No.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
	private Object dados;
	private No next;
	
	/**
	 * O construtor � chamado na cria��o de um objeto. E assim inicializa seus dados de forma organizada.
	 * @param dados- informa�oes do objeto
	 */
	public No(Object dados)
	{
		this.dados=dados;
		next=null;
	}
    /**
     * M�todo para retorno de dados.
     * @return object-dados.
     */
	public Object getDados()
	{
		return dados;
	}
	/**
	 * M�todo para retorno do next do No
	 * @return No- next
	 */
	public No getNext()
	{
		return next;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do object dados. E assim como � um m�todo void ele n�o
	 * retorna nada.
	 * @param dados
	 */
	public void setDados(Object dados)
	{
		this.dados=dados;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo cpf. E assim como � um m�todo void ele n�o
	 * retorna nada.
	 * @param next
	 */
	public void setNext(No next)
	{
		this.next=next;
	}
	/**
	 * Esse m�todo � utilizado para modifica��o do atributo cpf. E assim como � um m�todo void ele n�o
	 * retorna nada.
	 * @return
	 */
	public Object getObject()
	{
		return dados;
	}
}
