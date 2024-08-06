package com.microservice.materiales.service;

import java.util.List;
import java.util.Optional;

import com.microservice.materiales.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.materiales.repository.MaterialRepository;

@Service
public class MaterialServiceImpl extends MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> findById(int id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteById(int id) {
        materialRepository.deleteById(id);
    }
}
