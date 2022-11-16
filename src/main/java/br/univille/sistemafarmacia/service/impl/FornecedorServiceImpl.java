package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Fornecedor;
import br.univille.sistemafarmacia.repository.FornecedorRepository;
import br.univille.sistemafarmacia.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService{

    private FornecedorRepository repositorio;

    @Override
    public List<Fornecedor> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return repositorio.save(fornecedor);
    }
    
}
