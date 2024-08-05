package com.microservice.pagos.service;

import com.microservice.pagos.entities.Orden;

import java.util.List;

public interface IOrdenService {

    List<Orden> findAll();

    Orden findById(Integer id);

    Orden save(Orden orden);

    void deleteById(Integer id);
}
