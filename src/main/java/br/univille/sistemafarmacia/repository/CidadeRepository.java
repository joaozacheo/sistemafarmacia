package br.univille.sistemafarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long>{
   
}
