package br.univille.sistemafarmacia.service;

import java.util.List;
import br.univille.sistemafarmacia.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(long id);
    void delete(long id);
    List<Cliente> findByNome(String nome);
}
