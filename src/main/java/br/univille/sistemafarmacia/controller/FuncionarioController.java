package br.univille.sistemafarmacia.controller;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    int alertaDel = 0;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaFuncionarios = service.getAll(busca);

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaFuncionarios", listaFuncionarios);
        dados.put("alertaDel", alertaDel);

        return new ModelAndView("funcionario/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var busca = "";
        var funcionario = new Funcionario();
        var listaCidades = serviceCidade.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("funcionario/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Funcionario funcionario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var busca = "";
            var listaCidades = serviceCidade.getAll(busca);
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("funcionario/form", dados);
        }
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var busca = "";
        var funcionario = service.findById(id);
        var listaCidades = serviceCidade.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("funcionario/form", dados);
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        alertaDel = 0;
        try {
            service.delete(id);
        } catch(Exception e){
            alertaDel = 1;
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                alertaDel = 0;
            }
        }, 2000);
        
        return new ModelAndView("redirect:/funcionarios", "alertaDel", alertaDel);
    }
}
