package com.microservice.impresoras.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.microservice.impresoras.entities.Impresora;

public interface IImpresoraService {

    List<Impresora> findAll();

    Impresora findById(Long id);

    void save(Impresora printer);

    void deleteById(Long id);

    Impresora update(Long id, Impresora impresora);

    Map<String, Long> conteoPorTipo();
    BigDecimal promedioCostoPorHora(String tipo);
}
