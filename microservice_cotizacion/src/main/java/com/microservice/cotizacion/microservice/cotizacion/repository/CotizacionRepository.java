package com.microservice.cotizacion.repository;

import com.microservice.cotizacion.model.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {
}
