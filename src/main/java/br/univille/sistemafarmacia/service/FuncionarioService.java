package br.univille.sistemafarmacia.service;

import java.util.List;

import br.univille.sistemafarmacia.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();
    Funcionario save(Funcionario funcionario);
    Funcionario findById(long id);
    void delete(long id);
}
