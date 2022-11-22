package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.FormaPagamento;

public interface FormaPagamentoService {
    List<FormaPagamento> getAll();
    FormaPagamento save(FormaPagamento formaPagamento);
    FormaPagamento findById(long id);
}
