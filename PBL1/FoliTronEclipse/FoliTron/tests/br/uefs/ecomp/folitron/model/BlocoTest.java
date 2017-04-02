package br.uefs.ecomp.folitron.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Bloco}
 */
public class BlocoTest {

	private Bloco b;	
	
	/**
     * Este m�todo � executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que s�o utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	b = new Bloco("Spanta Beb�", "Salvador - Farol da Barra", 10);
    }

    /**
     * Teste de unidade que verifica se os atributos de um bloco s�o atribuidos e 
     * modificados corretamente. Al�m disso, ele checa se o m�todo equals que 
     * compara dois blocos foi implementado corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Spanta Beb�", b.getNome());
        assertEquals("Salvador - Farol da Barra", b.getLocal());
        assertEquals(10, b.getSaida());
        
        b.setNome("Dormir � o Melhor Rem�dio");
        b.setLocal("Feira de Santana");        
        b.setSaida(15);
        assertEquals("Dormir � o Melhor Rem�dio", b.getNome());
        assertEquals("Feira de Santana", b.getLocal());
        assertEquals(15, b.getSaida());
        
        Bloco temp = new Bloco("Dormir � o Melhor Rem�dio", "Feira de Santana", 15);
        assertTrue(temp.equals(b));
        
        b.setNome("XYZ");        
        assertFalse(temp.equals(b));
        
        b.setLocal("Recife - Marco Zero");
        b.setNome("Dormir � o Melhor Rem�dio");        
        assertFalse(temp.equals(b));
        
        b.setSaida(20);  
        b.setLocal("Feira de Santana");              
        assertFalse(temp.equals(b));
    }
    
}
