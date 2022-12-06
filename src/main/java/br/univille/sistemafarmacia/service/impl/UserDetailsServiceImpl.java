package br.univille.sistemafarmacia.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.repository.LoginRepository;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private LoginRepository repository;

    // @Override
    // protected void configure(final HttpSecurity http) throws Exception {
    //     http
    //         .formLogin()
    //         .loginPage("/login.html")
    //         .failureUrl("/login-error.html")
    //       .and()
    //         .logout()
    //         .logoutSuccessUrl("/index.html");
    // }

    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        var umLogin = repository.findByNome(username);

        return new User(umLogin.getNome(), umLogin.getSenha(), new ArrayList<>());
    }
}
