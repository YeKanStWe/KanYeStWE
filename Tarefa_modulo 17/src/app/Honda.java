package app;

public class Honda implements Carro {
    private String modelo;

    public Honda(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void exibirModelo() {
        System.out.println("Honda " + modelo);
    }
}
