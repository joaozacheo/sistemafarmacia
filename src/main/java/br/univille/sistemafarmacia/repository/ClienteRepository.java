package br.univille.sistemafarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    List<Cliente> findByNomeIgnoreCaseContainingOrEnderecoIgnoreCaseContainingOrCpfIgnoreCaseContaining(@Param("nome") String nome, @Param("endereco") String endereco, @Param("cpf") String cpf);
}
