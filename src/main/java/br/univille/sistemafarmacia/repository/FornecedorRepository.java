package br.univille.sistemafarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    List<Fornecedor> findByNomeIgnoreCaseContainingOrEnderecoIgnoreCaseContainingOrContatoIgnoreCaseContaining(@Param("nome") String nome, @Param("endereco") String endereco, @Param("contato") String contato);
}
