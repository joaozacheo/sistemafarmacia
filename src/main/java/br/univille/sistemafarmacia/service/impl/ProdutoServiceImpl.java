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
    public List<Produto> getAll(String busca) {
        if(busca == null || busca == ""){
            return repositorio.findAll();
        }else{
            return repositorio.findByNomeIgnoreCaseContainingOrDescricaoIgnoreCaseContainingOrFornecedor_NomeIgnoreCaseContaining(busca, busca, busca);
        }
    }

    @Override
    public Produto save(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public Produto findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Produto();
    }

    @Override
    public void excluir(long id) {
        repositorio.deleteById(id);
    }    
}
