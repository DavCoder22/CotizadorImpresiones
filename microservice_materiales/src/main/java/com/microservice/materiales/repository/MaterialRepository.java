package com.proyectoprog.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoprog.materiales.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
