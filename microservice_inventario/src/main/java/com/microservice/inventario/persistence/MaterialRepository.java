package com.microservice.inventario.persistence;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.inventario.entities.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
 @Query("SELECT COUNT(m) FROM Material m WHERE m.tipo = ?1")
    long countByTipo(Material.TipoMaterial tipo);

    @Query("SELECT SUM(m.costo) FROM Material m")
    BigDecimal totalCost();

    @Query("SELECT SUM(m.costo) FROM Material m WHERE m.tipo = 'FILAMENTO'")
    BigDecimal totalFilamentoCost();
}
