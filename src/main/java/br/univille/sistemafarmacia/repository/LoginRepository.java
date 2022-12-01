package br.univille.sistemafarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemafarmacia.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long>{
    Login findByNome(String nome);
}
