package br.univille.sistemafarmacia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private float subtotal;
    private float valorFinal;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemDeVenda> itens = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cliente comprador;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Funcionario vendedor;
    //private FormaPagamento formaPagamento;

    public float calculoSubtotal(){
        this.subtotal = 0;
        /*for(int i = 0; i < venda.itens.size(); i++){
            valor += venda.itens.get(i).getProduto().getValorUnitario() * venda.itens.get(i).getQtdVenda();
        }*/

        return this.subtotal;
    }

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
        subtotal = 0;
        for(int i = 0; i < itens.size(); i++){
            subtotal += itens.get(i).getProduto().getValorUnitario() * itens.get(i).getQtdVenda();
        }
        return subtotal;
    }
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getValorFinal() {
        if(this.subtotal < 50){
            valorFinal = subtotal;
        }else{
            if(subtotal >= 50 && subtotal < 100){
                valorFinal = subtotal - (subtotal*0.15f);
            }else{
                if(subtotal >= 100 && subtotal < 200){
                    valorFinal = subtotal - (subtotal*0.25f);
                }else{
                    if(subtotal >= 200){
                        valorFinal = subtotal - (subtotal*0.35f);
                    }
                }
            }
        }
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

    public List<ItemDeVenda> getItens() {
        return itens;
    }
    public void setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
    }
}
