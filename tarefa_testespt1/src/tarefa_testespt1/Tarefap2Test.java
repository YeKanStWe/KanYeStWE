package tarefa_testespt1;

import org.junit.*;
import java.io.*;

public class Tarefap2Test {

    @Test
    public void test() {

        String entrada = "Maria - f, Ana - f, Joao - m\n";

        ByteArrayInputStream input = new ByteArrayInputStream(entrada.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        Tarefap2.main(null);

        String saida = output.toString().toLowerCase();

        boolean femininosCorretos =
                saida.contains("as clientes do sexo feminino presentes na lista sao: maria, do sexo feminino") &&
                saida.contains("as clientes do sexo feminino presentes na lista sao: ana, do sexo feminino");

        boolean masculinosExcluidos =
                saida.contains("os nomes joao, do sexo masculino foram excluídos por incompatibilidade de gnero");

        Assert.assertEquals(true, femininosCorretos && masculinosExcluidos);
    }
}
