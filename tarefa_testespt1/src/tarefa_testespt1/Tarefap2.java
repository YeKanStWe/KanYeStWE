package tarefa_testespt1;

import java.util.*;
import java.util.stream.Collectors;

public class Tarefap2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite os nomes e sexos separados por vírgula, no modelo: nome - sexo(m/f)");
        String entrada = s.nextLine();

        Set<String> pessoas = Arrays.stream(entrada.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());

        List<String> masculinos = pessoas.stream()
                .map(p -> p.split("-"))
                .filter(p -> p.length == 2)
                .filter(p -> p[1].trim().equalsIgnoreCase("m"))
                .map(p -> formatarNome(p[0]) + ", do sexo masculino")
                .sorted()
                .toList();

        List<String> femininos = pessoas.stream()
                .map(p -> p.split("-"))
                .filter(p -> p.length == 2)
                .filter(p -> p[1].trim().equalsIgnoreCase("f"))
                .map(p -> formatarNome(p[0]) + ", do sexo feminino")
                .sorted()
                .toList();

        System.out.println("Alerta!");
        masculinos.forEach(m ->
                System.out.println("Os nomes " + m + " foram excluídos por incompatibilidade de gênero")
        );

        System.out.println("\nEntradas do sexo feminino:");
        femininos.forEach(f ->
                System.out.println("As clientes do sexo feminino presentes na lista são: " + f)
        );

        s.close();
    }

    private static String formatarNome(String nome) {
        nome = nome.trim().toLowerCase();
        return nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }
}
