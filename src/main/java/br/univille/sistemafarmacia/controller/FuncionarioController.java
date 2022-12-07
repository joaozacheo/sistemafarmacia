package br.univille.sistemafarmacia.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemafarmacia.entity.Funcionario;
import br.univille.sistemafarmacia.service.CidadeService;
import br.univille.sistemafarmacia.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private CidadeService serviceCidade;

    @GetMapping
    public ModelAndView index(){
        var listaFuncionarios = service.getAll();
        return new ModelAndView("funcionario/index", "listaFuncionarios", listaFuncionarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var funcionario = new Funcionario();
        var listaCidades = serviceCidade.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("funcionario/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Funcionario funcionario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var listaCidades = serviceCidade.getAll();
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("funcionario/form", dados);
        }
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var funcionario = service.findById(id);
        var listaCidades = serviceCidade.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("funcionario/form", dados);
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/funcionarios");
    }
}
