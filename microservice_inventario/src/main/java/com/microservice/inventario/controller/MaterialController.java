package com.microservice.inventario.controller;

import com.microservice.inventario.entities.Material;
import com.microservice.inventario.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/materiales")
public class MaterialController {

    @Autowired
    private IMaterialService materialService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createMaterial(@RequestBody Material material) {
        materialService.save(material);
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Material creado exitosamente");
        response.put("material", material);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getMaterialById(@PathVariable Integer id) {
        Optional<Material> material = Optional.ofNullable(materialService.findById(id));
        Map<String, Object> response = new HashMap<>();
        if (material.isPresent()) {
            response.put("mensaje", "Material encontrado");
            response.put("material", material.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", "Material no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMaterials() {
        List<Material> materials = materialService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Materiales recuperados exitosamente");
        response.put("materiales", materials);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateMaterial(@PathVariable Integer id, @RequestBody Material material) {
        Material updatedMaterial = materialService.update(id, material);
        Map<String, Object> response = new HashMap<>();
        if (updatedMaterial != null) {
            response.put("mensaje", "Material actualizado exitosamente");
            response.put("material", updatedMaterial);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", "Material no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteMaterial(@PathVariable Integer id) {
        materialService.deleteById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Material eliminado exitosamente");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

      @GetMapping("/count/{tipo}")
    public ResponseEntity<Map<String, Object>> countByTipo(@PathVariable Material.TipoMaterial tipo) {
        long count = materialService.countByTipo(tipo);
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Total de materiales del tipo " + tipo + ": " + count);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/totalCost")
    public ResponseEntity<Map<String, Object>> totalCost() {
        BigDecimal total = materialService.totalCost();
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Costo total de todos los materiales: " + total);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/totalFilamentoCost")
    public ResponseEntity<Map<String, Object>> totalFilamentoCost() {
        BigDecimal total = materialService.totalFilamentoCost();
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Costo total de los rollos de filamento: " + total);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/totalResinaCost")
    public ResponseEntity<String> totalResinaCost() {
        BigDecimal totalResinaCost = materialService.totalResinaCost();
        return new ResponseEntity<>("Costo total de los materiales de resina: " + totalResinaCost, HttpStatus.OK);
    }
}
