package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Produto;
import br.univille.sistemafarmacia.repository.ProdutoRepository;
import br.univille.sistemafarmacia.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public List<Produto> getAll() {
        return repositorio.findAll();
    }
    
}
