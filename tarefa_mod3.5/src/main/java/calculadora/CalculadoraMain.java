package calculadora;

/**
 * Classe responsável por realizar operações aritméticas básicas
 * entre dois números inteiros.
 */
public class CalculadoraMain {

    /**
     * Realiza a soma de dois valores inteiros.
     *
     * @param a primeiro valor
     * @param b segundo valor
     * @return soma de a e b
     */
    public static int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza a subtração de dois valores inteiros.
     *
     * @param a valor base
     * @param b valor a ser subtraído
     * @return resultado de a - b
     */
    public static int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Realiza a multiplicação de dois valores inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return produto de a e b
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza a divisão de dois valores inteiros.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado da divisão inteira de a por b
     * @throws ArithmeticException quando b for zero
     */
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Impossível dividir por zero");
        }
        return a / b;
    }

    /**
     * Método principal responsável por executar a aplicação.
     * Utiliza valores fixos para demonstrar as operações.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        int a = 6, b = 3;
        System.out.println("a+b = " + adicionar(a, b));
        System.out.println("a-b = " + subtrair(a, b));
        System.out.println("a*b = " + multiplicar(a, b));
        System.out.println("a/b = " + dividir(a, b));
    }
}
