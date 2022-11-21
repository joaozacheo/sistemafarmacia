package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Cidade;
import br.univille.sistemafarmacia.repository.CidadeRepository;
import br.univille.sistemafarmacia.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
    @Autowired
    public CidadeRepository repository;

    @Override
    public List<Cidade> getAll(){
        return repository.findAll();
    }

    @Override
    public Cidade save(Cidade cidade){
        return repository.save(cidade);
    }

    @Override
    public Cidade findById(long id){
        var cidade = repository.findById(id);
        if(cidade.isPresent()){
            return cidade.get();
        }
        return new Cidade();
    }
    
}
