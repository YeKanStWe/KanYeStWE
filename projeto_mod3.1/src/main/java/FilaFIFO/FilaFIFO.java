package FilaFIFO;

public class FilaFIFO {
    private int[] elementos;
    private int primeiro;
    private int ultimo;
    private int total;
    private int capacidade;

    public FilaFIFO(int tamanho){
        this.capacidade = tamanho;
        this.elementos = new int[capacidade];
        this.primeiro = 0;
        this.ultimo = -1;
        this.total = 0;
    }

    public void enqueue(int valor){
        if (isFull()){
            throw new RuntimeException("Erro: a fila esta cheia!");
        } ultimo = (ultimo + 1) % capacidade;
        elementos[ultimo] = valor;
        total++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Erro: a fila esta vazia!");
        } int valorRemovido = elementos[primeiro];
        primeiro = (primeiro + 1) % capacidade;
        total--;
        return valorRemovido;
    }

    public int rear(){return elementos[ultimo];}

    public int front(){return elementos[primeiro];}

    public int size(){return capacidade;}

    public boolean isEmpty(){return total == 0;}

    public boolean isFull(){return total == capacidade;}

    public static void main (String[] args){
        FilaFIFO f = new FilaFIFO(3);
        f.enqueue(10);
        f.enqueue(15);
        f.enqueue(20);
        System.out.println("Tamanho: " + f.size());
        System.out.println("Primeiro a ser removido: " + f.front());
        System.out.println("Ultimo na fila: " + f.rear());
        System.out.println("Dequeue: " + f.dequeue());
        System.out.println("Dequeue: " + f.dequeue());
        System.out.println("Dequeue: " + f.dequeue());
    }
}
