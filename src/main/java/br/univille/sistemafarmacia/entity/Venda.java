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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Selecione a data da venda")
    private Date data;

    //@Min(value = 0, message = "Valor mínimo é R$0.00")
    private float subtotal;

    //@Min(value = 0, message = "Valor mínimo é R$0.00")
    private float valorFinal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    @NotNull(message = "A venda deve ter no mínimo um item")
    private List<ItemDeVenda> itens = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @NotNull(message = "Selecione o comprador")
    private Cliente comprador;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @NotNull(message = "Selecione o vendedor")
    private Funcionario vendedor;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @NotNull(message = "Selecione a forma de pagamento")
    private FormaPagamento formaPagamento;

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
                valorFinal = subtotal - (subtotal*0.5f);
            }else{
                if(subtotal >= 100 && subtotal < 150){
                    valorFinal = subtotal - (subtotal*0.10f);
                }else{
                    if(subtotal >= 150 && subtotal < 200){
                        valorFinal = subtotal - (subtotal*0.15f);
                    }else{
                        if(subtotal >= 200){
                            valorFinal = subtotal - (subtotal*0.20f);
                        }
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
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String calculaDesconto(){
        String desconto = "0%";
        if(subtotal < 50){
            desconto = "0%";
        }else{
            if(subtotal >= 50 && subtotal < 100){
                desconto = "5%";
            }else{
                if(subtotal >= 100 && subtotal < 150){
                    desconto = "10%";
                }else{
                    if(subtotal >= 150 && subtotal < 200){
                        desconto = "15%";
                    }else{
                        if(subtotal >= 200){
                            desconto = "20%";
                        }
                    }
                }
            }
        }
        return desconto;
    }
}
