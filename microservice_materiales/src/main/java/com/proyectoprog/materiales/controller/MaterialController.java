package com.proyectoprog.materiales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoprog.materiales.model.Material;
import com.proyectoprog.materiales.service.MaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> getAllMateriales() {
        return materialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable int id) {
        Optional<Material> material = materialService.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@Valid @RequestBody Material material) {
        try {
            Material savedMaterial = materialService.save(material);
            return ResponseEntity.ok(savedMaterial);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable int id, @Valid @RequestBody Material materialDetails) {
        Optional<Material> material = materialService.findById(id);
        if (material.isPresent()) {
            Material updatedMaterial = material.get();
            updatedMaterial.setNombre(materialDetails.getNombre());
            updatedMaterial.setTipo(materialDetails.getTipo());
            updatedMaterial.setCosto(materialDetails.getCosto());
            updatedMaterial.setDescripcion(materialDetails.getDescripcion());
            materialService.save(updatedMaterial);
            return ResponseEntity.ok(updatedMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable int id) {
        if(materialService.findById(id).isPresent()) {
            materialService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
