package tarefa_controlefluxos;

import java.util.Scanner;

public class tarefa10 {

    public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);

        System.out.println("Digite seu nome");
        String nome = s.nextLine();
        System.out.println("Bem vindo " + nome + "! Vamos calcular sua media?");
        String resposta = s.nextLine();

        // Repete até receber "sim" ou "nao"
        while (!resposta.equalsIgnoreCase("sim") && !resposta.equalsIgnoreCase("nao")) {
            System.out.println("Resposta invalida, por favor digite 'sim' ou 'nao'.");
            resposta = s.nextLine();
        }

        if (resposta.equalsIgnoreCase("nao")) {
            System.out.println("Ok, ate mais " + nome + "!");
            s.close();
            return;
        } else {
            System.out.println("Perfeito, vamos la!");
        }
        
        int notaMat;
        do {
            System.out.println("Digite sua nota em matematica");
            notaMat = s.nextInt();
            if (notaMat < 0 || notaMat > 10) {
                System.out.println("Nota invalida, por favor digite uma nota entre 0 e 10.");
            }
        } while (notaMat < 0 || notaMat > 10);

        int notaPort;
        do {
            System.out.println("Digite sua nota em portugues");
            notaPort = s.nextInt();
            if (notaPort < 0 || notaPort > 10) {
                System.out.println("Nota invalida, por favor digite uma nota entre 0 e 10.");
            }
        } while (notaPort < 0 || notaPort > 10);

        int notaIng;
        do {
            System.out.println("Digite sua nota em ingles");
            notaIng = s.nextInt();
            if (notaIng < 0 || notaIng > 10) {
                System.out.println("Nota invalida, por favor digite uma nota entre 0 e 10.");
            }
        } while (notaIng < 0 || notaIng > 10);

        int notaCie;
        do {
            System.out.println("Digite sua nota em ciencias");
            notaCie = s.nextInt();
            if (notaCie < 0 || notaCie > 10) {
                System.out.println("Nota invalida, por favor digite uma nota entre 0 e 10.");
            }
        } while (notaCie < 0 || notaCie > 10);

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