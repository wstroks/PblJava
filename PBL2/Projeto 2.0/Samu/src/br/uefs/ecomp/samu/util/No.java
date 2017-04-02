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
package br.uefs.ecomp.samu.util;

/**
*
* @author Washington Pagotto Batista
*/

public class No 
{

	//atributos da classe
	private Object dados;
	private No next;

	//construtor da classe
	public No(Object dados)
	{
		this.dados=dados;
		next=null;
	}

	/**
	 * Esse metodo � usado para fazer verifica��o do atributo dados da classe No.
	 *@return verifica o valor do objeto e retorna.
	 * 
	 */
	public Object getDados()
	{
		return dados;
	}

	/**
	 * Esse metodo � usado para verificar o campo next da classe No.
	 * @return verifica o valor do objeto e retorna
	 * 
	 */
	public No getNext()
	{
		return next;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo dados da classe No.
	 * @param recebe  novo valor.
	 */
	public void setDados(Object dados)
	{
		this.dados=dados;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo next da classe No.
	 * @param recebe um novo valor.
	 */
	public void setNext(No next)
	{
		this.next=next;
	}

	/**
	 * Esse metodo � usado para verificar o campo dados da classe No, como ele
	 * @return verifica um valor do objeto.
	 */
	public Object getObject()
	{
		return dados;
	}
}


