package br.univille.sistemafarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Funcionario;

@Repository
public interface FornecedorRepository extends JpaRepository<Funcionario, Long>{
    
}
