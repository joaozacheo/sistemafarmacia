package br.univille.sistemafarmacia.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat
    private Date data;
    private float subtotal;
    private float valorFinal;
    //private List<ItensDeVenda> itens;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cliente comprador;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Funcionario vendedor;
    //private FormaPagamento formaPagamento;

    //Adicionar methodo

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public float getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getValorFinal() {
        return valorFinal;
    }
    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Cliente getComprador() {
        return comprador;
    }
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }
    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }
}
