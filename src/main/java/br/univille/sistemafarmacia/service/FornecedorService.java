package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.Fornecedor;

public interface FornecedorService {
    List<Fornecedor> getAll();
    Fornecedor save(Fornecedor fornecedor);
    Fornecedor getById(long id);
    void excluir(long id);
}
