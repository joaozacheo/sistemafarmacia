package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Cliente;
import br.univille.sistemafarmacia.repository.ClienteRepository;
import br.univille.sistemafarmacia.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        
        return repository.save(cliente);
    }

    @Override
    public Cliente findById(long id) {
        var cliente = repository.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }
        return new Cliente();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);        
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return repository.findByNomeIgnoreCaseContaining(nome);
    }
    
}