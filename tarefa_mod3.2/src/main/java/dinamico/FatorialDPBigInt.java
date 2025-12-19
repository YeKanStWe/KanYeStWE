package dinamico;

import java.math.BigInteger;

public class FatorialDPBigInt {

    public static BigInteger fatorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 100;
        System.out.println("Fatorial (DP) de " + numero + " = " + fatorial(numero));
    }
}


