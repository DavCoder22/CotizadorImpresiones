package com.microservice.historial.service;

import java.util.List;
import com.microservice.historial.model.Historial;

public interface HistorialService {
    List<Historial> findAll();
    Historial findById(Long id);
    Historial save(Historial historial);
    void deleteById(Long id);
}
