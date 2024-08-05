package com.microservice.impresoras.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@Table(name = "impresora")
@AllArgsConstructor
@NoArgsConstructor
public class Impresora {
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

enum TipoImpresora {
    RESINA,
    FILAMENTO
}




