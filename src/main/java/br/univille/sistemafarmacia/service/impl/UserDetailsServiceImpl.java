package br.univille.sistemafarmacia.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.repository.LoginRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        var umLogin = repository.findByNome(username);

        return new User(umLogin.getNome(), umLogin.getSenha(), new ArrayList<>());
    }
}
