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
public class ListaEncadeada implements ILista {

	//atributos da classe
	private int tamanho=0;
	private No atual;
	private No anterior;
	private No ultimo;

	//construtor da classe
	public ListaEncadeada()
	{

		atual=null;
		anterior=null;
		ultimo=null;
	}

	/**
	 * m�todo verifica o elemento atual.
	 * @return verifica e retorna o mesmo
	 */
	public No getAtual(){
		return atual;
	}

	@Override
	/**
	 * Verifica se a lista est� vazia.
	 * @return falso se a lista n�o estiver vazia, e verdadeiro caso contrario.
	 */ 
	public boolean estaVazia()
	{
		// TODO Auto-generated method stub

		//verifica se tamnho for diferente de zero.
		if(tamanho!=0)
		{
			return false;
		}

		return true;
	}


	@Override
	/**
	 * Quantidade de objetos da lista.
	 * @return o tamanho da fila.
	 */
	public int tamanho() 
	{
		// TODO Auto-generated method stub

		return tamanho;
	}


	@Override
	/**
	 * Esse metodo � responsavel por inserir um novo objeto no come�o da lista.
	 * @param recebe o objeto a ser inserido.
	 */
	public void insereInicio(Object o) 
	{
		// TODO Auto-generated method stub

		/*
		 * � criado um novo objeto do tipo No com os atributos do objeto recebido.
		 * Sendo que o novo objeto o proximo vai ser modificado para receber atual.
		 * 
		 */

		No novo=new No(o);
		novo.setNext(atual);
		atual=novo;

		//verificando se caso a lista estiver vazia.
		if(this.tamanho==0)
		{
			this.ultimo=atual;
		}

		//contando quandos objetos a lista tem.
		tamanho++;

	}



	@Override
	/**
	 * Esse metodo � responsavel por inserir um novo objeto no final da lista
	 * @param recebe o objeto a ser inserido.
	 */
	public void insereFinal(Object o) 
	{
		// TODO Auto-generated method stub

		if (tamanho == 0) 
		{
			this.insereInicio(o);
		} 

		else 
		{
			/*
			 * � criado um objeto do tipo No que recebe o objeto do parametro, a nova celular vai
			 * aprontar pra null.
			 * Depois � feita a verifica��o se a lista esta vazia,
			 * caso esteja tanto o atual como o ultimo ir�o receber a nova celula.
			 * caso nao entre o proximo de ultimo ir� receber a nova celula e ultimo ir� receber
			 * nova celula.
			 */
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


	@Override

	/**
	 * Esse metodo � responsavel por remover um objeto do inicio da lista. 
	 * @return o objeto removido que estava no inicio da lista.
	 * @return se a lista tiver vazia retorna null.
	 */
	public Object removeInicio() 
	{
		// TODO Auto-generated method stub

		/*
		 * criada uma variavel do tipo No � ela receber� atual. 
		 * Verificando se a lista est� vazia e retornando null.
		 * Por sua vez atual passa a apontar para a seu proximo e � retornado um objeto de tipo
		 * object, que  � o item a ser removido.
		 * Fazendo tamb�m o tamanho da lista diminuir.
		 */
		No novo=atual;
		if( estaVazia())
		{
			return null;
		}

		atual=atual.getNext();
		tamanho--;
		return novo.getObject(); 

	}


	@Override
	/**
	 * Esse metodo � responsavel por remover um objeto do final da lista. 
	 * @return o objeto removido que estava no final da lista.
	 * @return caso a lista esteje vazia retorna null.
	 */
	public Object removeFinal() 
	{
		// TODO Auto-generated method stub

		/*criada uma variavel do tipo No que recebe atual. Sendo assim � feito um
		 *estrutura de repeti��o para varrer a lista e encontrar o seu final, usando
		 * outro auxiliar que � anterior, sendo que o final da verifica��o
		 * novo ira estara recebendo o ultimo elemento e anterior o penultimo
		 * elemento da lista. � feita a verifica��o de quantos elementos tem na
		 * lista, caso esteja vazia � retornado null.Se s� estiver um  elemento o
		 * novo ira receber atual, e atual ir� receber null, e o conteudo do
		 * atual ir� ser retornado.
		 * Tambem � feito um redu��o do tamanho da lista.
		 * 
		 */
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


	@Override
	/**
	 * Esse metodo � responsavel por fazer uma busca na lista, recuperando o elemento sem remover ele.
	 * @param  recebe a posi��o do elemento a ser encontrado.
	 */
	public Object recupera(int index) 
	{
		// TODO Auto-generated method stub

		/*Cria uma variavel auxiliar que recebe zero.
		 *Cria um variavel novo que recebe atual.
		 * A estrutura de condi��o s� ser� aceita se o auxiliar e index for diferente, se forem iguais � 
		 * porque o elemento procurado j� foi achado e ser� retornado.
		 * 
		 */

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
	 * Esse metodo � responsavel pela cria��o de um iterador da lista.
	 * @return o iterador da lista.
	 */
	public Iterador iterador() 
	{
		// TODO Auto-generated method stub

		/*
		 * criando um novo objeto iterador que recebe atual e o mesmo � retornado.
		 */

		Iterador iterador = new MeuIterador (atual);
		return iterador;
	}
	/**
	 * M�todo que insere ordenado.
	 * @param c
	 */
	public void insereOrdenado(Comparable c) {
		// TODO Auto-generated method stub
		if (atual == null) { 
			insereInicio(c);
			return;
		} 
		else { 
			No aux = atual; 
			No ant = null; 
			for (int i = 0; i < this.tamanho(); i++)
			{ 
				int teste = ((Comparable) c).compareTo(this.recupera(i)); if (teste < 0) {

					if (i == 0) { 
						insereInicio(c); 
						return; 

					} 
					else { 
						while (i > 0) 
						{ 
							ant = aux;
							aux = aux.getNext(); 
							i--; 
						} 
						No novo = new No(c); 
						novo.setNext(ant.getNext()); 
						ant.setNext(novo); 
						return; 
					} 
				} 
			}
			insereFinal(c); } 
	}

}
