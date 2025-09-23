package app;

public class Toyota implements Carro {
    private String modelo;

    public Toyota(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void exibirModelo() {
        System.out.println("Toyota " + modelo);
    }
}
