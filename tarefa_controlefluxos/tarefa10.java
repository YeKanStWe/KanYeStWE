package tarefa_controlefluxos;

import java.util.Scanner;

public class tarefa10 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Digite sua nota em matematica");
        int notaMat = s.nextInt();

        System.out.println("Digite sua nota em portugues");
        int notaPort = s.nextInt();

        System.out.println("Digite sua nota em ingles");
        int notaIng = s.nextInt();

        System.out.println("Digite sua nota em ciencias");
        int notaCie = s.nextInt();

        int media = (notaMat + notaPort + notaIng + notaCie) / 4;
        if (media >= 7) {
            System.out.println("Aprovado com media: " + media);
        } else if (media >= 5) {
            System.out.println("Recuperacao com media: " + media);
        } else {
            System.out.println("Reprovado com media: " + media);
        }

        s.close();


        
    }
}