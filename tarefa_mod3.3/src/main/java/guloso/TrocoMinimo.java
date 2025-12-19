package guloso;

import java.util.*;

public class TrocoMinimo {

    public static void main(String[] args) {
        int quantia = 6433;
        int[] moedas = {42, 4, 1};

        Arrays.sort(moedas);
        for (int i = moedas.length - 1; i >= 0; i--) {
            int qtd = quantia / moedas[i];
            if (qtd > 0) {
                System.out.println(moedas[i] + " -> " + qtd + " moeda(s)");
                quantia %= moedas[i];
            }
        }
    }
}

