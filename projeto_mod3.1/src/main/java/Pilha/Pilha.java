package Pilha;

public class Pilha {
    private int[] itens;
    private int topo;

    public Pilha(int capacidade){
        itens = new int[capacidade];
        topo = -1;
    }

    public void push(int item){
        if (topo < itens.length - 1){
            topo++;
            itens[topo] = item;
        } else {
            System.out.println("Pilha.Pilha cheia!");
        }
    }

    public int pop(){
        if (!isEmpty()) {
            int item = itens[topo];
            topo--;
            return item;
        }   else{
            System.out.println("Pilha.Pilha vazia!");
            return -1;
        }
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int top() {
        if(!isEmpty()){
            return itens[topo];
        } return -1;
    }

    public int size() {
        return (itens.length);
    }

    public static void main (String[] args){
        Pilha p = new Pilha(3);
        p.push(10);
        p.push(20);
        System.out.println("Tamanho " + p.size());
        System.out.println("Topo: " + p.top());
        System.out.println("Pop: " + p.pop());
        System.out.println("Pop " + p.pop());
        System.out.println("Vazia? " + p.isEmpty());
    }
}
