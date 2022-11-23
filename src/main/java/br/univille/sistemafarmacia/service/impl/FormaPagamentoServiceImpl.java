package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.FormaPagamento;
import br.univille.sistemafarmacia.repository.FormaPagamentoRepository;
import br.univille.sistemafarmacia.service.FormaPagamentoService;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService{
    @Autowired
    public FormaPagamentoRepository repository;

    @Override
    public List<FormaPagamento> getAll(){
        return repository.findAll();
    }

    @Override
    public FormaPagamento save(FormaPagamento formaPagamento){
        return repository.save(formaPagamento);
    }

    @Override
    public FormaPagamento findById(long id){
        var formaPagamento = repository.findById(id);
        if(formaPagamento.isPresent()){
            return formaPagamento.get();
        }
        return new FormaPagamento();
    }
}
