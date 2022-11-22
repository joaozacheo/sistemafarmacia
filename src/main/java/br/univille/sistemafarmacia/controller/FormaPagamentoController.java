package br.univille.sistemafarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.FormaPagamento;
import br.univille.sistemafarmacia.service.FormaPagamentoService;

@Controller
@RequestMapping("/formapagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @GetMapping
    public ModelAndView index(){
        var listaFormaPagamento = service.getAll();
        return new ModelAndView("formaPagamento/index","listaFormaPagamento",listaFormaPagamento);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaFormaPagamento = new FormaPagamento();
        return new ModelAndView("formaPagamento/form", "formaPagamento",novaFormaPagamento);
    }

    @PostMapping(params = "form")
    public ModelAndView save(FormaPagamento formaPagamento){

        service.save(formaPagamento);
        
        return new ModelAndView("redirect:/formaPagamento");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        
        var umaFormaPagamento = service.findById(id);
        return new ModelAndView("formaPagamento/form", "formaPagamento", umaFormaPagamento);
    }
}
