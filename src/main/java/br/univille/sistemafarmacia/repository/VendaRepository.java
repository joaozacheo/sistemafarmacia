package br.univille.sistemafarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Venda;
@Repository
public interface VendaRepository extends JpaRepository<Venda,Long>{
    
}
