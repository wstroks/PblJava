/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Componente Curricular: M�dulo Integrado de Programa��o Autor: <Washington Pagotto Batista>
 * Data: <24/05/2014>
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

public class MeuIterador implements Iterador
{

	//atributos da classe
	private No novo;

	//construtor da classe
	public MeuIterador(No novo)
	{
		this.novo=novo;

	}

	@Override
	/**
	 * Esse metodo � respons�vel por verificar se h� um proximo elemento na
	 * lista.
	 * @return verdadeiro, se a lista n�o for vazia. Falso, caso contr�rio.
	 * 
	 */
	public boolean temProximo() 
	{
		// TODO Auto-generated method stub

		//verificando se novo � nulo
		if(novo!=null)
		{
			return true;
		}

		return false;
	}


	@Override
	/**
	 * Esse metodo � responsavel por fazer o retorno do conteudo de uma celula
	 * da lista, nele � criado um novo objeto do tipo objeto.
	 * @return faz o retorno do conteudo de uma celula da lista
	 */
	public Object proximo() 
	{
		// TODO Auto-generated method stub
		//criando um objeto
		Object auxiliar;

		//verificando se existe o proximo elemento.
		if(!temProximo())
		{
			return null;
		}

		else
		{  


			/*
			 *esse objeto criado recebe o conteudo do lista novo e novo recebe
			 * o seu proximo elemento, ao final o objeto criado � retornado com o
			 * conteudo da celula.
			 */
			auxiliar=novo;
			novo=novo.getNext();
			return ((No) auxiliar).getDados();
		}



	}


}
