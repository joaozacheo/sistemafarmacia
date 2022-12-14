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

import br.univille.sistemafarmacia.entity.Fornecedor;
import br.univille.sistemafarmacia.service.CidadeService;
import br.univille.sistemafarmacia.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;

    @Autowired
    private CidadeService serviceCidade;

    int alertaDel = 0;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaFornecedores = service.getAll(busca);

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaFornecedores", listaFornecedores);
        dados.put("alertaDel", alertaDel);

        return new ModelAndView("fornecedor/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var busca = "";
        var fornecedor = new Fornecedor();
        var listaCidades = serviceCidade.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("fornecedor", fornecedor);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("fornecedor/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Fornecedor fornecedor, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var busca = "";
            var listaCidades = serviceCidade.getAll(busca);
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("fornecedor/form", dados);
        }
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var busca = "";
        var fornecedor = service.getById(id);
        var listaCidades = serviceCidade.getAll(busca);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("fornecedor", fornecedor);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("fornecedor/form", dados);
    }
    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        alertaDel = 0;
        try {
            service.excluir(id);
        } catch(Exception e){
            alertaDel = 1;
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                alertaDel = 0;
            }
        }, 2000);

        return new ModelAndView("fornecedor/index", "alertaDel", alertaDel);
    }
}
