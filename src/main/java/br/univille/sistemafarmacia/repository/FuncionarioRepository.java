package br.univille.sistemafarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByNomeIgnoreCaseContainingOrEnderecoIgnoreCaseContainingOrCpfIgnoreCaseContaining(@Param("nome") String nome, @Param("endereco") String endereco, @Param("cpf") String cpf);
}
