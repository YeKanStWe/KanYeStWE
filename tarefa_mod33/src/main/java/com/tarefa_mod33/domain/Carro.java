package com.tarefa_mod33.domain;

import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

import java.util.List;


@Entity
public class Carro {
    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String modelo;

    @ManyToOne
    private Marca marca;

    @ManyToMany
    private List<Acessorio> acessorios;

    public @Nullable Object getId() {
        return id;
    }
}
