package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Funcionario;
import br.univille.sistemafarmacia.repository.FornecedorRepository;
import br.univille.sistemafarmacia.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService{

    @Autowired
    private FornecedorRepository repositorio;

    @Override
    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }
    
}
