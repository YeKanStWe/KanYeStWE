package br.com.tarefa_mod40;

import domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import repository.IClienteRepository;

public class TarefaMod40Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TarefaMod40Application.class);

    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TarefaMod40Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        Cliente cliente = createCliente();
        repository.save(cliente);
    }

    private Cliente createCliente() {
        return Cliente.builder()
                .cidade("SP")
                .cpf(12312312310L)
                .email("Teste@teste.com")
                .end("End")
                .estado("SP")
                .nome("Teste Spring Boot")
                .numero(102030)
                .tel(10203040L)
                .build();
    }
}