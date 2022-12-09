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

import br.univille.sistemafarmacia.entity.Cliente;
import br.univille.sistemafarmacia.service.CidadeService;
import br.univille.sistemafarmacia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private ClienteService service;

    int alertaDel = 0;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaClientes = service.getAll(busca);
        
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("alertaDel", alertaDel);

        return new ModelAndView("cliente/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var busca = "";
        var cliente = new Cliente();
        var listaCidades = cidadeService.getAll(busca);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",cliente);
        dados.put("listaCidades",listaCidades);
        return new ModelAndView("cliente/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var busca = "";
        var umCliente = service.findById(id);
        var listaCidades = cidadeService.getAll(busca);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",umCliente);
        dados.put("listaCidades",listaCidades);
        return new ModelAndView("cliente/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var busca = "";
            var listaCidades = cidadeService.getAll(busca);
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("cliente",cliente);
            dados.put("listaCidades",listaCidades);
            return new ModelAndView("cliente/form",dados);
        }
        service.save(cliente);

        return new ModelAndView("redirect:/clientes");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
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

        return new ModelAndView("cliente/index", "alertaDel", alertaDel);
    }
}
