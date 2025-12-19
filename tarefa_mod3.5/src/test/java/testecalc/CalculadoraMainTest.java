package testecalc;

import org.junit.Test;
import static org.junit.Assert.*;
import static calculadora.CalculadoraMain.*;

/**
 * Classe de testes unitários da CalculadoraMain.
 * Valida as quatro operações básicas e o tratamento de erro.
 */
public class CalculadoraMainTest {

    /**
     * Testa a operação de adição.
     */
    @Test
    public void testeAdicionar() {
        assertEquals(5, adicionar(5, 0));
    }

    /**
     * Testa a operação de subtração.
     */
    @Test
    public void testeSubtrair() {
        assertEquals(5, subtrair(5, 0));
    }

    /**
     * Testa a operação de multiplicação.
     */
    @Test
    public void testeMultiplicar() {
        assertEquals(0, multiplicar(5, 0));
    }

    /**
     * Testa a operação de divisão com valores válidos.
     */
    @Test
    public void testeDividir() {
        assertEquals(2, dividir(6, 3));
    }

    /**
     * Verifica se a divisão por zero lança exceção.
     */
    @Test(expected = ArithmeticException.class)
    public void testeDividirPorZero() {
        dividir(5, 0);
    }
}
