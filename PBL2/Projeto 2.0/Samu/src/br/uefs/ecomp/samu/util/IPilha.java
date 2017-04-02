package br.uefs.ecomp.samu.util;

public interface IPilha {
    
    /**
     * Tamanho da pilha.
     * @return o tamanho da pilha.
     */
    public int tamanho();

    /**
     * Verifica se a pilha est� vazia.
     * @return verdadeiro, se a pilha estiver vazia. Falso, case contr�rio.
     */
    public boolean estaVazia();
    
    /**
     * Remove o objeto do topo da pilha.
     * @return o objeto removido que estava no topo da pilha.
     */
    public Object removeTopo();
    
    /**
     * Insere no topo da pilha.
     * @param obj o objeto a ser inserido no topo da pilha
     */
    public void insereTopo(Object obj);
    
    /**
     * Recupera o objeto que est� no topo da pilha, sem remov�-lo.
     * @return o objeto no topo da pilha.
     */
    public Object recuperaTopo();
}
