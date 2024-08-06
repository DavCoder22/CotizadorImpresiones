package com.microservice.inventario.service;

import com.microservice.inventario.entities.Material;

import java.math.BigDecimal;
import java.util.List;

public interface IMaterialService {
    List<Material> findAll();
    Material findById(Integer id);
    void save(Material material);
    void deleteById(Integer id);
    Material update(Integer id, Material material);
    long countByTipo(Material.TipoMaterial tipo);
    BigDecimal totalCost();
    BigDecimal totalFilamentoCost();
    BigDecimal totalResinaCost();
}
