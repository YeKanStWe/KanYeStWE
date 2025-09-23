package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Honda("Civic"));
        carros.add(new Chevrolet("Onix"));
        carros.add(new Toyota("Corolla"));

        for (Carro c : carros) {
            c.exibirModelo();
        }
    }
}
