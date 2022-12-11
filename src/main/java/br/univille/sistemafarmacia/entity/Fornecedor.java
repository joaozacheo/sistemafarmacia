package br.univille.sistemafarmacia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, nullable = false)
    @NotBlank(message = "Campo não pode ser em branco")
    private String nome;

    @Column(length = 1500, nullable = false)
    @NotBlank(message = "Campo não pode ser em branco")
    private String endereco;

    private String contato;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cidade cidadeOrigem;

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
    
    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }
    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }
}
