package fibonacci;

/**
 * Classe responsável por calcular a sequência de Fibonacci
 * utilizando recursividade.
 */
public class FibonacciMain {

    /**
     * Calcula o n-ésimo termo da sequência de Fibonacci.
     *
     * @param n posição do termo na sequência (n ≥ 0)
     * @return valor correspondente ao termo n
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Método principal responsável por executar a aplicação.
     * Calcula e exibe o termo da sequência de Fibonacci.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }
}
