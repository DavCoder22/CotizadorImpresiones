package com.microservice.historial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.historial.repository.HistorialRepository;
import com.microservice.historial.model.Historial;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public List<Historial> findAll() {
        return historialRepository.findAll();
    }

    @Override
    public Historial findById(Long id) {
        Optional<Historial> historial = historialRepository.findById(id);
        return historial.orElse(null);
    }

    @Override
    public Historial save(Historial historial) {
        return historialRepository.save(historial);
    }

    @Override
    public void deleteById(Long id) {
        historialRepository.deleteById(id);
    }
}
