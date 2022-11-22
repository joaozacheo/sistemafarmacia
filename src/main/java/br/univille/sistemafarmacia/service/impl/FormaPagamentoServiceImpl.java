package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sistemafarmacia.entity.FormaPagamento;
import br.univille.sistemafarmacia.repository.FormaPagamentoRepository;
import br.univille.sistemafarmacia.service.FormaPagamentoService;

public class FormaPagamentoServiceImpl implements FormaPagamentoService{
    @Autowired
    public FormaPagamentoRepository repository;

    @Override
    public List<FormaPagamento> getAll(){
        return repository.findAll();
    }

    @Override
    public FormaPagamento save(FormaPagamento pagamento){
        return repository.save(pagamento);
    }

    @Override
    public FormaPagamento findById(long id){
        var pagamento = repository.findById(id);
        if(pagamento.isPresent()){
            return pagamento.get();
        }
        return new FormaPagamento();
    }
}
