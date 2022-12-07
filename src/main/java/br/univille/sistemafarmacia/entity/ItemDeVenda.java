package br.univille.sistemafarmacia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ItemDeVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 1, message = "Quantidade vendida deve ser no mínimo 1")
    private int qtdVenda;

    @NotNull(message = "Campo não pode ser em branco")
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
