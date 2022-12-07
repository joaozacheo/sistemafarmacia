package br.univille.sistemafarmacia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Cidade;
import br.univille.sistemafarmacia.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeService service;

    @GetMapping
    public ModelAndView index(){
        var listaCidades = service.getAll();
        return new ModelAndView("cidade/index","listaCidades", listaCidades);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaCidade = new Cidade();
        return new ModelAndView("cidade/form","cidade",novaCidade);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cidade cidade, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("cidade/form");
        }
        service.save(cidade);
        
        return new ModelAndView("redirect:/cidades");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaCidade = service.findById(id);
        return new ModelAndView("cidade/form", "cidade", umaCidade);
    }

}
