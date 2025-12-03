package tarefa_streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class tarefap2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Solicita ao usuário que insira os nomes e sexos
        System.out.println("Digite os nomes e sexos separados por vírgula, no modelo: nome - sexo(m/f)");
        String entrada = s.nextLine();
        // Remove espaços extras e divide a entrada em partes
        // usando vírgula como delimitador
        HashSet<String> pessoas = new HashSet<>();
        for (String pessoa : entrada.split(",")) {
            pessoas.add(pessoa.trim());
        }
        // Transforma as informacoes em dois HashSets, um para cada sexo inserido
        // o formato hashset e utilizado para evitar duplicatas
        HashSet<String> masculinos = new HashSet<>();
        HashSet<String> femininos = new HashSet<>();
        // define os sexos e formata os nomes
        // exibe a primeira letra como maiuscula e separa por sexo.
        for (String pessoa : pessoas) {
            String[] partes = pessoa.split("-");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String sexo = partes[1].trim();
                if (sexo.equals("m")) {
                    masculinos.add(nome + ", do sexo masculino");
                } else if (sexo.equals("f")) {
                    femininos.add(nome + ", do sexo feminino");
                }
            } else {
                System.out.println("Entrada inválida: " + pessoa + ". Use o formato 'nome - sexo(m/f)'");
            } 
        }

        // Convertendo os HashSets para ArrayLists e ordenando
        // para exibir os nomes em ordem alfabética
        ArrayList<String> masculinosList = new ArrayList<>(masculinos);
        ArrayList<String> femininosList = new ArrayList<>(femininos);
        Collections.sort(masculinosList);
        Collections.sort(femininosList);
        //exibe os resultados
        System.out.println("\nEntradas do sexo masculino:");
        for (String m : masculinosList) {
            System.out.println(m);
        }

        System.out.println("\nEntradas do sexo feminino:");
        for (String f : femininosList) {
            System.out.println(f);
        }

        s.close();
    }
}