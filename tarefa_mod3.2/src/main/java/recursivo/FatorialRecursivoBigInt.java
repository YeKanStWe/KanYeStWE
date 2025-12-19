package recursivo;

import java.math.BigInteger;

public class FatorialRecursivoBigInt {

    public static BigInteger fatorial(int n) {
        if (n <= 1) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(fatorial(n - 1));
    }

    public static void main(String[] args) {
        int numero = 100;
        System.out.println("Fatorial (recursivo) de " + numero + " = " + fatorial(numero));
    }
}

