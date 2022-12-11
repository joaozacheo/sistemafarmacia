package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Fornecedor;
import br.univille.sistemafarmacia.repository.FornecedorRepository;
import br.univille.sistemafarmacia.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService{

    @Autowired
    private FornecedorRepository repositorio;

    @Override
    public List<Fornecedor> getAll(String busca) {

        if(busca == null || busca == ""){
            return repositorio.findAll();
        }else{
            return repositorio.findByNomeIgnoreCaseContainingOrEnderecoIgnoreCaseContainingOrContatoIgnoreCaseContaining(busca, busca, busca);
        }
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return repositorio.save(fornecedor);
    }

    @Override
    public Fornecedor getById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Fornecedor();
    }

    @Override
    public void excluir(long id) {
        repositorio.deleteById(id);        
    }
    
}
