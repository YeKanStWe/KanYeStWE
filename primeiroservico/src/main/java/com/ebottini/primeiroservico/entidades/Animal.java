package com.ebottini.primeiroservico.entidades;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date dataChegada;

    @Column(nullable = false)
    private String nomeProvisorio;

    @Column(nullable = false)
    private String porte;

    @Column(nullable = false)
    private String condicoesChegada;

    @Column(nullable = false)
    private String nomeRecebedor;

    @Column(nullable = false)
    private Integer idadeEstimada;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String raca;

    private Date dataAdocao;
    private Date dataObito;

    public Integer getId() { return id; }
    public Date getDataChegada() { return dataChegada; }
    public void setDataChegada(Date dataChegada) { this.dataChegada = dataChegada; }
    public String getNomeProvisorio() { return nomeProvisorio; }
    public void setNomeProvisorio(String nomeProvisorio) { this.nomeProvisorio = nomeProvisorio; }
    public String getPorte() { return porte; }
    public void setPorte(String porte) { this.porte = porte; }
    public String getCondicoesChegada() { return condicoesChegada; }
    public void setCondicoesChegada(String condicoesChegada) { this.condicoesChegada = condicoesChegada; }
    public String getNomeRecebedor() { return nomeRecebedor; }
    public void setNomeRecebedor(String nomeRecebedor) { this.nomeRecebedor = nomeRecebedor; }
    public Integer getIdadeEstimada() { return idadeEstimada; }
    public void setIdadeEstimada(Integer idadeEstimada) { this.idadeEstimada = idadeEstimada; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public Date getDataAdocao() { return dataAdocao; }
    public void setDataAdocao(Date dataAdocao) { this.dataAdocao = dataAdocao; }
    public Date getDataObito() { return dataObito; }
    public void setDataObito(Date dataObito) { this.dataObito = dataObito; }
}
