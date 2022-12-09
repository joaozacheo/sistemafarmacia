package br.univille.sistemafarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeIgnoreCaseContainingOrDescricaoIgnoreCaseContainingOrFornecedor_NomeIgnoreCaseContaining(@Param("nome") String nome, @Param("descricao") String descricao, @Param("fornecedor") String fornecedor);
}
