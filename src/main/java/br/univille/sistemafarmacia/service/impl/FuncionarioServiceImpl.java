package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Funcionario;
import br.univille.sistemafarmacia.repository.FuncionarioRepository;
import br.univille.sistemafarmacia.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository repositorio;

    @Override
    public List<Funcionario> getAll(String busca) {

        if(busca == null || busca == ""){
            return repositorio.findAll();
        }else{
            return repositorio.findByNomeIgnoreCaseContainingOrEnderecoIgnoreCaseContainingOrCpfIgnoreCaseContaining(busca, busca, busca);
        }
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    @Override
    public Funcionario findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Funcionario();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);        
    }
    
}
