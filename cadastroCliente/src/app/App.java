package app;

import dao.*;
import domain.Cliente;
import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida! Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Excluir cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void atualizar(String dados) {
        String[] d = dados.split(",");
        Cliente cliente = new Cliente(d[0].trim(), Long.parseLong(d[1].trim()), d[2].trim(), d[3].trim(), d[4].trim(), d[5].trim(), d[6].trim());
        iClienteDAO.alterar(cliente);
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados.trim()));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados.trim()));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {
        String[] d = dados.split(",");
        Cliente cliente = new Cliente(d[0].trim(), Long.parseLong(d[1].trim()), d[2].trim(), d[3].trim(), d[4].trim(), d[5].trim(), d[6].trim());
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isExclusao(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isConsulta(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static void sair() {
        StringBuilder clientesCadastrados = new StringBuilder();
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados.append(cliente).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Clientes cadastrados:\n" + clientesCadastrados, "Até logo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
}