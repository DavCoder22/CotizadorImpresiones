package com.microservice.pagos.service;

import com.microservice.pagos.entities.Orden;
import com.microservice.pagos.persistence.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden findById(Integer id) {
        return ordenRepository.findById(id).orElseThrow();
    }

    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public void deleteById(Integer id) {
        ordenRepository.deleteById(id);
    }
}
