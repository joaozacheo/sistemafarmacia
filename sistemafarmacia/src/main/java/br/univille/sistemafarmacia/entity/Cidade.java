package br.univille.sistemafarmacia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cidade {
    @Column(length = 1500,unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
