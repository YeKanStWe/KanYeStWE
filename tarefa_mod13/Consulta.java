package tarefa_mod13;

import tarefa_mod13.*;

public class consulta {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("jonas");
        pf.setEndereco("Avenida rua alameda, 3,1416");
        pf.setCpf("111.222.333-44");

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Vendas Compras Emprestimos LTDA");
        pj.setEndereco("Rua Alameda Avenida, 3,141592653");
        pj.setCnpj("12.345.678/0001-90");

        System.out.println("Pessoa Física: " + pf.getNome() + ", CPF: " + pf.getCpf());
        System.out.println("Pessoa Jurídica: " + pj.getNome() + ", CNPJ: " + pj.getCnpj());
    }
    
}
