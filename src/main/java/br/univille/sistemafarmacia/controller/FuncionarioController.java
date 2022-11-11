package br.univille.sistemafarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Funcionario;
import br.univille.sistemafarmacia.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ModelAndView index(){
        var listaFuncionarios = service.getAll();
        return new ModelAndView("funcionario/index", "listaFuncionarios", listaFuncionarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var funcionario = new Funcionario();
        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Funcionario funcionario){
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var funcionario = service.findById(id);
        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/funcionarios");
    }
}
