package com.microservice.cotizacion.controller;

import com.microservice.cotizacion.model.Cotizacion;
import com.microservice.cotizacion.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @GetMapping
    public List<Cotizacion> getAllCotizaciones() {
        return cotizacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotizacion> getCotizacionById(@PathVariable Long id) {
        Cotizacion cotizacion = cotizacionService.findById(id);
        return cotizacion != null ? ResponseEntity.ok(cotizacion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cotizacion createCotizacion(@RequestBody Cotizacion cotizacion) {
        return cotizacionService.createCotizacion(cotizacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cotizacion> updateCotizacion(@PathVariable Long id, @RequestBody Cotizacion cotizacionDetails) {
        Cotizacion updatedCotizacion = cotizacionService.updateCotizacion(id, cotizacionDetails);
        return updatedCotizacion != null ? ResponseEntity.ok(updatedCotizacion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCotizacion(@PathVariable Long id) {
        cotizacionService.deleteCotizacion(id);
        return ResponseEntity.noContent().build();
    }
}
