package com.marceloscorporation.desafioOrmUtimate.Entities;

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

    @Lob
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

   @OneToOne(mappedBy = "atividades")
    private Bloco blocos;

    @OneToMany (mappedBy = "atividades")
    private Set<Participante> participantes = new HashSet<>();


    public Atividade(){

    }

    public Atividade(Integer id, String nome, String descricao, Double preco, Categoria categoria, Bloco blocos, Set<Participante> participantes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.blocos = blocos;
        this.participantes = participantes;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Bloco getBlocos() {
        return blocos;
    }

    public void setBlocos(Bloco blocos) {
        this.blocos = blocos;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }
}
