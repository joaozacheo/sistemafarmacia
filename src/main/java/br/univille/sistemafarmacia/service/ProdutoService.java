package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();
    Produto save(Produto produto);
    Produto findById(long id);
    void excluir(long id);
}
