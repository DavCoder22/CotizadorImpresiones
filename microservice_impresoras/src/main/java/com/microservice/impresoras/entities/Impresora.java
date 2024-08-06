package com.microservice.impresoras.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "impresora")
@AllArgsConstructor
@NoArgsConstructor
public class Impresora {

    public enum TipoImpresora {
        RESINA,
        FILAMENTO
    } 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoImpresora tipo;

    private BigDecimal costoPorHora;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Timestamp fechaCreacion;

    private Timestamp fechaActualizacion;

    // Getters and Setters lombok

}






