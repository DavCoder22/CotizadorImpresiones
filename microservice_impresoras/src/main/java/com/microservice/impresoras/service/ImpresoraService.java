package com.microservice.impresoras.service;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.persistence.ImpresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpresoraService implements IImpresoraService {

    @Autowired
    private ImpresoraRepository impresoraRepository;

    @Override
    public List<Impresora> findAll() {
        return (List<Impresora>) impresoraRepository.findAll();
    }

    @Override
    public Impresora findById(Long id) {
        return impresoraRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Impresora impresora) {
        impresoraRepository.save(impresora);
    }

    @Override
    public void deleteById(Long id) {
        impresoraRepository.deleteById(id);
    }
}
