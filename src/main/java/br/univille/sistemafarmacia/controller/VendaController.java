package br.univille.sistemafarmacia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.ItemDeVenda;
import br.univille.sistemafarmacia.entity.Venda;
import br.univille.sistemafarmacia.service.ClienteService;
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

    @GetMapping
    public ModelAndView index(){
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index", "listaVendas", listaVendas);
    }

    @GetMapping("/nova")
    public ModelAndView novo(){
        var venda = new Venda();
        var listaClientes = serviceCliente.getAll();
        var listaFuncionarios = serviceFuncionario.getAll();
        var listaProdutos = serviceProdutos.getAll();
        //var desconto = venda.calculaDesconto();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemDeVenda());
        //dados.put("desconto", desconto);
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Venda venda){
        service.save(venda);
        
        return new ModelAndView("redirect:/vendas");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda, ItemDeVenda novoItem){
        venda.getItens().add(novoItem);
        var listaClientes = serviceCliente.getAll();
        var listaFuncionarios = serviceFuncionario.getAll();
        var listaProdutos = serviceProdutos.getAll();
        //var desconto = venda.calculaDesconto();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemDeVenda());
        //dados.put("desconto", desconto);
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, Venda venda){
        venda.getItens().remove(index);
        var listaClientes = serviceCliente.getAll();
        var listaFuncionarios = serviceFuncionario.getAll();
        var listaProdutos = serviceProdutos.getAll();
        //var desconto = venda.calculaDesconto();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemDeVenda());
        //dados.put("desconto", desconto);
        return new ModelAndView("venda/form", dados);
    }
}
