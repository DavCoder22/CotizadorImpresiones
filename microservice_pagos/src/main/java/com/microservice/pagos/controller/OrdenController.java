package com.microservice.pagos.controller;

import com.microservice.pagos.entities.Orden;
import com.microservice.pagos.service.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/ordenes")
public class OrdenController {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping
    public List<Orden> findAll() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> findById(@PathVariable Integer id) {
        Orden orden = ordenService.findById(id);
        return ResponseEntity.ok(orden);
    }

    @PostMapping
    public ResponseEntity<Orden> save(@RequestBody Orden orden) {
        Orden savedOrden = ordenService.save(orden);
        return ResponseEntity.ok(savedOrden);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        ordenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
