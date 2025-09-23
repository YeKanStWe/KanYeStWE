package app;

public class Chevrolet implements Carro {
    private String modelo;

    public Chevrolet(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void exibirModelo() {
        System.out.println("Chevrolet " + modelo);
    }
}
