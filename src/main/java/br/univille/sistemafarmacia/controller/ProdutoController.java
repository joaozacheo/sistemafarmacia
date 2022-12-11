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

    int alertaDel = 0;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false, name = "busca") String busca){
        var listaProdutos = service.getAll(busca);

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaProdutos", listaProdutos);
        dados.put("alertaDel", alertaDel);

        return new ModelAndView("produto/index", dados);
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
    public ModelAndView save(@Valid Produto produto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var busca = "";
            var listaFornecedores = serviceFornecedor.getAll(busca);
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listaFornecedores", listaFornecedores);
            return new ModelAndView("produto/form", dados);
        }
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
        return new ModelAndView("redirect:/produtos", "alertaDel", alertaDel);
    }
}