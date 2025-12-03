package tarefa_reflection;

@NomeTabela(nome = "Tabela1")
public class Tabela {
    public static void main(String args[]) {
        Class<Tabela> clazz = Tabela.class;
        if(clazz.isAnnotationPresent(NomeTabela.class)) {
            NomeTabela anotacao = clazz.getAnnotation(NomeTabela.class);
            System.out.println("O nome da tabela definido pela annotation é: " + anotacao.nome());
        }
    }
}