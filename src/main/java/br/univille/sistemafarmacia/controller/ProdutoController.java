package br.univille.sistemafarmacia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Produto;
import br.univille.sistemafarmacia.service.FornecedorService;
import br.univille.sistemafarmacia.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    @Autowired
    private FornecedorService serviceFornecedor;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaProdutos = service.getAll(busca);
        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var busca = "";
        var produto = new Produto();
        var listaFornecedores = serviceFornecedor.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaFornecedores", listaFornecedores);
        return new ModelAndView("produto/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var busca = "";
        var produto = service.findById(id);
        var listaFornecedores = serviceFornecedor.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaFornecedores", listaFornecedores);
        return new ModelAndView("produto/form", dados);
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        service.excluir(id);
        return new ModelAndView("redirect:/produtos");
    }
}