package com.microservice.impresoras.persistence;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.entities.Impresora.TipoImpresora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ImpresoraRepository extends JpaRepository<Impresora, Long> {

    long countByTipo(TipoImpresora tipo);

    @Query("SELECT AVG(i.costoPorHora) FROM Impresora i WHERE i.tipo = :tipo")
    BigDecimal findAverageCostoPorHoraByTipo(TipoImpresora tipo);
}
