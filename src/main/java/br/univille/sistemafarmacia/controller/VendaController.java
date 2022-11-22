package br.univille.sistemafarmacia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Venda;
import br.univille.sistemafarmacia.service.ClienteService;
import br.univille.sistemafarmacia.service.FuncionarioService;
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

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaCompradores", listaClientes);
        dados.put("listaVendedores", listaFuncionarios);
        return new ModelAndView("venda/form", dados);
    }
}