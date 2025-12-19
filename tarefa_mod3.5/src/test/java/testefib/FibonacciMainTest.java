package testefib;

import static org.junit.jupiter.api.Assertions.*;

import fibonacci.FibonacciMain;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes unitários da FibonacciMain.
 * Valida o cálculo da sequência de Fibonacci.
 */
public class FibonacciMainTest {

    /**
     * Testa o caso base da sequência (n = 0).
     */
    @Test
    void testFibonacciZero() {
        assertEquals(0, FibonacciMain.fibonacci(0));
    }

    /**
     * Testa o segundo caso base da sequência (n = 1).
     */
    @Test
    void testFibonacciUm() {
        assertEquals(1, FibonacciMain.fibonacci(1));
    }

    /**
     * Testa um valor intermediário da sequência (n = 10).
     */
    @Test
    void testFibonacciDez() {
        assertEquals(55, FibonacciMain.fibonacci(10));
    }
}
