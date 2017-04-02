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

package br.uefs.ecomp.samu.model;

/**
*
* @author Washington Pagotto Batista
*/

public class Pessoa 
{

	//atributos da classe.
	private String cpf;
	private String nome;
	private String endereco;

	//construtor da classe.
	public Pessoa(String cpf,String nome,String endereco)
	{
		this.cpf=cpf;
		this.nome=nome;
		this.endereco=endereco;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo Cpf da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getCpf()
	{
		return cpf;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo Nome da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo endereco da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getEndereco()
	{
		return endereco;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo cpf da classe Pessoa
	 * @param altera o atributo recebido.
	 */
	public void setCpf(String cpf)
	{
		this.cpf=cpf;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo nome da classe Pessoa.
	 * @param altera o atributo recebido
	 */
	public void setNome(String nome)
	{
		this.nome=nome;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo endereco da classe Pessoa.
	 * @param altera o atributo recebido
	 */
	public void setEndereco(String endereco)
	{
		this.endereco=endereco;
	}

	/**
	 * Esse metodo � utilizado para fazer a compara��o de uma string ou outro
	 * tipo de atributo.
	 * @param recebe o objeto
	 */
	public boolean equals(Object obj) 
	{ 
		/**
		 * Recebendo como parametro um objeto de tipo
		 * object, � verificado se o objeto que foi recebido � do tipo ambulancia. Caso
		 * entre na condi��o � feita a compara��o para verificar se os objetos sao
		 * iguais. Esse metodo apresenta um retorno boolean, ou seja, retorna um
		 * valor verdadeiro ou um falso.
		 */

		if(obj instanceof Pessoa)
		{

			Pessoa p=(Pessoa) obj;

			if(p.getNome().equals(getNome()) && p.getCpf().equals(getCpf()) && 
					p.getEndereco().equals(getEndereco()))
			{ 
				return true; 
			} 
		}

		return false;
	}

/**
 * M�todo que compara os nomes.
 * @param object
 * @return a nome.
 */
	public int compareTo(Object obj)
	{  
		return this.getNome().compareTo(((Pessoa) obj).getNome());  
	}  

}
