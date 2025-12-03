package tarefa_streams;

import java.util.*;
import java.util.stream.Collectors;

public class tarefap1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite os nomes separados por vírgula:");
        String entrada = s.nextLine();

        List<String> nomesOrdenados = Arrays.stream(entrada.split(","))
                .map(String::trim)
                .collect(Collectors.toSet())   // Remove duplicatas
                .stream()
                .sorted()
                .toList();

        System.out.println("Nomes em ordem alfabética:");
        nomesOrdenados.forEach(System.out::println);

        s.close();
    }
}

