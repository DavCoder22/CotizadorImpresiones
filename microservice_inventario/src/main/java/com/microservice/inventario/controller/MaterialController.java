package com.microservice.inventario.controller;

import com.microservice.inventario.entities.Material;
import com.microservice.inventario.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/materiales")
public class MaterialController {

    @Autowired
    private IMaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        materialService.save(material);
        return new ResponseEntity<>(material, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id) {
        Optional<Material> material = Optional.ofNullable(materialService.findById(id));
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materials = materialService.findAll();
        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Integer id, @RequestBody Material material) {
        Material updatedMaterial = materialService.update(id, material);
        return updatedMaterial != null ? new ResponseEntity<>(updatedMaterial, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Integer id) {
        materialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
