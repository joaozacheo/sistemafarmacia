package br.univille.sistemafarmacia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemafarmacia.entity.Venda;
import br.univille.sistemafarmacia.repository.VendaRepository;
import br.univille.sistemafarmacia.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService{

    @Autowired
    private VendaRepository repositorio;

    @Override
    public List<Venda> getAll(String busca) {

        if(busca == null || busca == ""){
            return repositorio.findAll();
        }else{
            return repositorio.findByComprador_NomeIgnoreCaseContainingOrVendedor_NomeIgnoreCaseContainingOrderByDataDesc(busca, busca);
        }
    }

    @Override
    public Venda save(Venda venda) {
        return repositorio.save(venda);
    }
    
}
