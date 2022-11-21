package br.univille.sistemafarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Fornecedor;
import br.univille.sistemafarmacia.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;

    @GetMapping
    public ModelAndView index(){
        var listaFornecedores = service.getAll();
        return new ModelAndView("fornecedor/index", "listaFornecedores", listaFornecedores);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var fornecedor = new Fornecedor();
        return new ModelAndView("fornecedor/form", "fornecedor", fornecedor);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var fornecedor = service.getById(id);
        return new ModelAndView("fornecedor/form", "fornecedor", fornecedor);
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        service.excluir(id);
        return new ModelAndView("redirect:/fornecedores");
    }
}
