package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.Cidade;

public interface CidadeService {
    List<Cidade> getAll();
    Cidade save(Cidade cidade);
    Cidade findById(long id);
}
