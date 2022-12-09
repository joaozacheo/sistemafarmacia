package br.univille.sistemafarmacia.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.ItemDeVenda;
import br.univille.sistemafarmacia.entity.Venda;
import br.univille.sistemafarmacia.service.ClienteService;
import br.univille.sistemafarmacia.service.FormaPagamentoService;
import br.univille.sistemafarmacia.service.FuncionarioService;
import br.univille.sistemafarmacia.service.ProdutoService;
import br.univille.sistemafarmacia.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    private VendaService service;
    @Autowired
    private ClienteService serviceCliente;
    @Autowired
    private FuncionarioService serviceFuncionario;
    @Autowired
    private ProdutoService serviceProdutos;
    @Autowired
    private FormaPagamentoService servicePagamento;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaVendas = service.getAll(busca);
        return new ModelAndView("venda/index", "listaVendas", listaVendas);
    }

    @GetMapping("/nova")
    public ModelAndView novo(){
        var busca = "";
        var venda = new Venda();
        var listaClientes = serviceCliente.getAll(busca);
        var listaFuncionarios = serviceFuncionario.getAll(busca);
        var listaProdutos = serviceProdutos.getAll(busca);
        var listaPagamentos = servicePagamento.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaPagamentos", listaPagamentos);
        dados.put("novoItem", new ItemDeVenda());
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid Venda venda, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var busca = "";
            var listaClientes = serviceCliente.getAll(busca);
            var listaFuncionarios = serviceFuncionario.getAll(busca);
            var listaProdutos = serviceProdutos.getAll(busca);
            var listaPagamentos = servicePagamento.getAll();

            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCompradores", listaClientes);
            dados.put("listaVendedores", listaFuncionarios);
            dados.put("listaProdutos", listaProdutos);
            dados.put("listaPagamentos", listaPagamentos);
            dados.put("novoItem", new ItemDeVenda());
            dados.put("venda", venda);
            return new ModelAndView("venda/form", dados);
        }
        var busca = "";
        service.save(venda);
        
        for(int i = 1; i <= serviceProdutos.getAll(busca).size(); i++){
            int qtdProduto = 0;
            int qtdAtual = 0;
            var umProduto = serviceProdutos.findById(i);
            for(int j = 0; j < venda.getItens().size(); j++){
                if(umProduto.getId() == venda.getItens().get(j).getProduto().getId()){
                    qtdProduto = venda.getItens().get(j).getQtdVenda();
                }
            }
            qtdAtual = umProduto.getQtdEstoque() - qtdProduto;
            umProduto.setQtdEstoque(qtdAtual);
            serviceProdutos.save(umProduto);
        }

        return new ModelAndView("redirect:/vendas");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda, ItemDeVenda novoItem, BindingResult bindingResult){
        /*if(bindingResult.hasErrors()){
            var listaClientes = serviceCliente.getAll();
            var listaFuncionarios = serviceFuncionario.getAll();
            var listaProdutos = serviceProdutos.getAll();
            var listaPagamentos = servicePagamento.getAll();

            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCompradores", listaClientes);
            dados.put("listaVendedores", listaFuncionarios);
            dados.put("listaProdutos", listaProdutos);
            dados.put("listaPagamentos", listaPagamentos);
            dados.put("novoItem", novoItem);
            dados.put("venda", venda);
            return new ModelAndView("venda/form", dados);
        }*/
        var alerta = 0;
        if(novoItem.getQtdVenda() > novoItem.getProduto().getQtdEstoque() || novoItem.getProduto() == null){
            alerta = 1;
            var busca = "";
            var listaClientes = serviceCliente.getAll(busca);
            var listaFuncionarios = serviceFuncionario.getAll(busca);
            var listaProdutos = serviceProdutos.getAll(busca);
            var listaPagamentos = servicePagamento.getAll();

            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCompradores", listaClientes);
            dados.put("listaVendedores", listaFuncionarios);
            dados.put("listaProdutos", listaProdutos);
            dados.put("listaPagamentos", listaPagamentos);
            dados.put("novoItem", new ItemDeVenda());
            dados.put("venda", venda);
            dados.put("alerta", alerta);
            return new ModelAndView("venda/form", dados);
        }
        venda.getItens().add(novoItem);
        var busca = "";
        var listaClientes = serviceCliente.getAll(busca);
        var listaFuncionarios = serviceFuncionario.getAll(busca);
        var listaProdutos = serviceProdutos.getAll(busca);
        var listaPagamentos = servicePagamento.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaPagamentos", listaPagamentos);
        dados.put("novoItem", new ItemDeVenda());
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, Venda venda){
        venda.getItens().remove(index);
        var busca = "";
        var listaClientes = serviceCliente.getAll(busca);
        var listaFuncionarios = serviceFuncionario.getAll(busca);
        var listaProdutos = serviceProdutos.getAll(busca);
        var listaPagamentos = servicePagamento.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaPagamentos", listaPagamentos);
        dados.put("novoItem", new ItemDeVenda());
        return new ModelAndView("venda/form", dados);
    }
}
