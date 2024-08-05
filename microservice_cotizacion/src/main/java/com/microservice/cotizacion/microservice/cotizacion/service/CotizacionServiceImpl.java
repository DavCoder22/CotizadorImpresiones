package com.microservice.cotizacion.service;

import com.microservice.cotizacion.model.Cotizacion;
import com.microservice.cotizacion.repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    @Override
    public List<Cotizacion> findAll() {
        return cotizacionRepository.findAll();
    }

    @Override
    public Cotizacion findById(Long id) {
        return cotizacionRepository.findById(id).orElse(null);
    }

    @Override
    public Cotizacion createCotizacion(Cotizacion cotizacion) {
        cotizacion.setCostoTotal(cotizacion.getPrecioMaterial() * cotizacion.getTiempoImpresion());
        return cotizacionRepository.save(cotizacion);
    }

    @Override
    public Cotizacion updateCotizacion(Long id, Cotizacion cotizacionDetails) {
        Optional<Cotizacion> cotizacion = cotizacionRepository.findById(id);
        if (cotizacion.isPresent()) {
            Cotizacion existingCotizacion = cotizacion.get();
            existingCotizacion.setUsuario(cotizacionDetails.getUsuario());
            existingCotizacion.setMaterial(cotizacionDetails.getMaterial());
            existingCotizacion.setPrecioMaterial(cotizacionDetails.getPrecioMaterial());
            existingCotizacion.setTiempoImpresion(cotizacionDetails.getTiempoImpresion());
            existingCotizacion.setCostoTotal(cotizacionDetails.getPrecioMaterial() * cotizacionDetails.getTiempoImpresion());
            return cotizacionRepository.save(existingCotizacion);
        }
        return null;
    }

    @Override
    public void deleteCotizacion(Long id) {
        cotizacionRepository.deleteById(id);
    }
}
