package br.univille.sistemafarmacia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private int qtdEstoque;
    private float valorUnitario;
    @ManyToOne
    private Fornecedor fornecedor;

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

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}