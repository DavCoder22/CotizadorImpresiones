package com.microservice.inventario.service;

import com.microservice.inventario.entities.Material;
import com.microservice.inventario.persistence.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialService implements IMaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return (List<Material>) materialRepository.findAll();
    }

    @Override
    public Material findById(Integer id) {
        return materialRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Material material) {
        material.setFechaCreacion(LocalDateTime.now());
        materialRepository.save(material);
    }

    @Override
    public void deleteById(Integer id) {
        materialRepository.deleteById(id);
    }

    @Override
    public Material update(Integer id, Material material) {
        if (materialRepository.existsById(id)) {
            material.setId(id);
            material.setFechaActualizacion(LocalDateTime.now());
            return materialRepository.save(material);
        }
        return null;
    }
}
