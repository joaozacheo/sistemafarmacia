package br.univille.sistemafarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Venda;
@Repository
public interface VendaRepository extends JpaRepository<Venda,Long>{
    List<Venda> findByComprador_NomeIgnoreCaseContainingOrVendedor_NomeIgnoreCaseContainingOrderByDataDesc(@Param("comprador") String comprador, @Param("vendedor") String vendedor);
}
