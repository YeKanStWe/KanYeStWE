package tarefa_posicoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class tarefap1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite os nomes separados por vírgula:");
        String entrada = s.nextLine();

        HashSet<String> nomes = new HashSet<>();
        for (String nome : entrada.split(",")) {
            nomes.add(nome.trim());
        }

        ArrayList<String> nomesList = new ArrayList<>(nomes);
        Collections.sort(nomesList);
        System.out.println("Nomes em ordem alfabética:");
        for (String nome : nomesList) {
            System.out.println(nome);
        }

        s.close();
    }
}