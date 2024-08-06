package com.microservice.impresoras.service;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.persistence.ImpresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public Impresora update(Long id, Impresora impresora) {
        if (impresoraRepository.existsById(id)) {
            impresora.setId(id);
            return impresoraRepository.save(impresora);
        } else {
            return null;
        }
    }
        // Nuevas funcionalidades
    @Override
    public Map<String, Long> conteoPorTipo() {
        List<Impresora> impresoras = findAll();
        return impresoras.stream()
                .collect(Collectors.groupingBy(i -> i.getTipo().name().toLowerCase(), Collectors.counting()));
    }

    @Override
    public BigDecimal promedioCostoPorHora(String tipo) {
        List<Impresora> impresoras = findAll();
        List<BigDecimal> costos = impresoras.stream()
                .filter(i -> i.getTipo().name().toLowerCase().equals(tipo.toLowerCase()))
                .map(Impresora::getCostoPorHora)
                .collect(Collectors.toList());

        BigDecimal suma = costos.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return suma.divide(new BigDecimal(costos.size()), 2, RoundingMode.HALF_UP);
    }
}
