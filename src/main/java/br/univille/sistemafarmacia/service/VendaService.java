package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.Venda;

public interface VendaService {
    List<Venda> getAll();
    Venda save(Venda venda);
}
