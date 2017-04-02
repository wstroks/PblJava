package br.uefs.ecomp.samu.util;

public interface IFila {
    /**
     * Verifica se a fila est� vazia.
     * @return verdadeiro, se a fila estiver vazia e falso caso contr�rio.
     */ 
    public boolean estaVazia();

    /**
     * Quantidade de objetos armazenados na fila
     * @return o tamanho da fila.
     */
    public int tamanho();

    /**
     * Insere um objeto no final da fila.
     * @param o objeto a ser inserido no final da fila.
     */
    public void insereFinal(Object o);

    /**
     * Remove um objeto do in�cio da fila.
     * @return o objeto removido do in�cio da fila.
     */
    public Object removeInicio();

    /**
     * Recupera um objeto do in�cio da fila sem remov�-lo.
     * @return o objeto armazenado no in�cio da fila.
     */
    public Object recuperaInicio();        
}
