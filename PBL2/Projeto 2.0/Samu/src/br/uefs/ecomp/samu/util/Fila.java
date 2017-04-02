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
public class Fila implements IFila {
    
	//Atributo da classe	
	private ListaEncadeada fila;
	
	//construtor da classe
	public Fila(){
		fila= new ListaEncadeada();
	}
	
	@Override
	/**
     * Verifica se a fila est� vazia, usando o m�todo da lista Encadeada.
     * @return verdadeiro, se a fila estiver vazia e falso caso contr�rio.
     */ 
	public boolean estaVazia() {
		//retornando a fila, atraves do metodo da Lista Encadeada.
		return fila.estaVazia();
	}

	@Override
	/**
     * Quantidade de objetos na fila, usando o m�todo da lista Encadeada.
     * @return o tamanho da fila.
     */
	public int tamanho() {
		// TODO Auto-generated method stub
		return fila.tamanho();
	}

	@Override
	 /**
     * Insere um objeto no final da fila, usando o m�todo da lista Encadeada.
     * @param o objeto a ser inserido no final da fila.
     */
	public void insereFinal(Object o) {
		fila.insereFinal(o);
	}

	@Override
	/**
     * Remove um objeto do in�cio da fila, usando o m�todo da lista Encadeada.
     * @return o objeto removido do in�cio da fila.
     */
	public Object removeInicio() {
		return fila.removeInicio();
	}

	@Override
	/**
     * Faz uma busca recuperando um objeto do in�cio da fila sem remover ele, 
     * utilizando o m�todo da lista Encadeada.
     * @return o objeto armazenado no in�cio da fila.
     */
	public Object recuperaInicio() {
		return fila.recupera(0);
	}
	
	/**
     * Esse metodo � responsavel pela cria��o de um iterador da fila. 
     * @return Nele � criado um novo objeto iterador e o mesmo � retornado.
     */
	public Iterador iterador() 
	{
		// TODO Auto-generated method stub
		
		Iterador iterador = new MeuIterador (fila.getAtual());
		return iterador;
	}

}
