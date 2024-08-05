package com.microservice.impresoras.service;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.entities.Impresora;

import java.util.List;

public interface IImpresoraService {

    List<Impresora> findAll();

    Impresora findById(Long id);

    void save(Impresora printer);

    void deleteById(Long id);
}
