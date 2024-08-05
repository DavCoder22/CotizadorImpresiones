package com.microservice.historial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservice.historial.model.Historial;
import com.microservice.historial.service.HistorialService;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Historial> getAllHistorial() {
        return historialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> getHistorialById(@PathVariable Long id) {
        Historial historial = historialService.findById(id);
        if (historial != null) {
            return ResponseEntity.ok(historial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Historial createHistorial(@RequestBody Historial historial) {
        return historialService.save(historial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historial> updateHistorial(@PathVariable Long id, @RequestBody Historial historialDetails) {
        Historial historial = historialService.findById(id);
        if (historial != null) {
            historial.setDescripcion(historialDetails.getDescripcion());
            return ResponseEntity.ok(historialService.save(historial));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable Long id) {
        Historial historial = historialService.findById(id);
        if (historial != null) {
            historialService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
