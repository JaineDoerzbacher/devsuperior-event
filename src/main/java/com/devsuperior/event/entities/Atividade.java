package com.devsuperior.event.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Atividade(){}

    public Atividade(Integer id, String nome, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(Set<Bloco> blocos) {
        this.blocos = blocos;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}