package br.univille.sistemafarmacia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String endereco;
    private String contato;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cidade cidadeResidencia;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    public Cidade getCidadeResidencia() {
        return cidadeResidencia;
    }
    public void setCidade(Cidade cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }
}
