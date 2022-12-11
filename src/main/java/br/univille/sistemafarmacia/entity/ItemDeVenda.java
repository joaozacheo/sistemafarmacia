package br.univille.sistemafarmacia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemDeVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int qtdVenda;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Produto produto;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }
    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }
    
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
