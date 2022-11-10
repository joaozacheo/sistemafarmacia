package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Funcionario;
import br.univille.sistemafarmacia.repository.FuncionarioRepository;
import br.univille.sistemafarmacia.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    private FuncionarioRepository repositorio;

    @Override
    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }
    
}
