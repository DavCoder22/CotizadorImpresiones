package com.microservice.cotizacion.service;

import com.microservice.cotizacion.model.Cotizacion;

import java.util.List;

public interface CotizacionService {
    List<Cotizacion> findAll();
    Cotizacion findById(Long id);
    Cotizacion createCotizacion(Cotizacion cotizacion);
    Cotizacion updateCotizacion(Long id, Cotizacion cotizacion);
    void deleteCotizacion(Long id);
}
