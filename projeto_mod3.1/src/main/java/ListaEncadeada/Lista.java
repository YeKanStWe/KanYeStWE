package ListaEncadeada;

public class Lista {
    private Node cabeca;

    public void push (int dado){
        Node n = new Node(dado);
        if (cabeca == null){
            cabeca = n;
        } else {
            Node atual = cabeca;
            while (atual.proximo !=null) {
                atual = atual.proximo;
            }
            atual.proximo = n;
        }

    }

    public Node pop(){
        if (cabeca == null){return null;}
        else if (cabeca.proximo == null) {
            Node aux = cabeca;
            cabeca = null;
            return aux;
        } Node atual = cabeca;
        while (atual.proximo.proximo != null){
            atual = atual.proximo;
        }
        Node removido = atual.proximo;
        atual.proximo = null;
        return removido;
    }

    public Node elementAt(int index){
        if (index < 0) return null;
        Node atual = cabeca;
        int contador = 0;

        while (atual != null){
            if (contador == index) {
                return atual;
            }
            atual = atual.proximo;
            contador++;
        }
        return null;
    }

    public void insert(int index, Node n){
        if (index < 0 || n == null) return;
        if (index == 0) {
            n.proximo = cabeca;
            cabeca = n;
            return;
        }
        Node anterior = elementAt(index - 1);
        if (anterior != null){
            n.proximo = anterior.proximo;
            anterior.proximo = n;
        } else {System.out.println("indice fora de alcance");}
    }

    public void printlist() {
        Node atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        l.push(10);
        l.push(30);
        Node segundoNo = l.elementAt(1);
        System.out.println("Segundo elemento (indice 1): " + segundoNo.dado);
        l.printlist();
        Node n1 = new Node (20);
        l.insert(1, n1);
        Node segundoNod = l.elementAt(1);
        System.out.println("Segundo elemento (indice 1): " + segundoNod.dado);
        l.printlist();
        l.pop();
        l.printlist();
    }
}
