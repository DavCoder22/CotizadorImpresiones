package com.microservice.inventario.service;

import com.microservice.inventario.entities.Material;
import java.util.List;

public interface IMaterialService {
    List<Material> findAll();
    Material findById(Integer id);
    void save(Material material);
    void deleteById(Integer id);
    Material update(Integer id, Material material);
}
