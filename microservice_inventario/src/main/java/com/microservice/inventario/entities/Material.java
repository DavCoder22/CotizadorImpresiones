package com.microservice.inventario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "materiales")
@AllArgsConstructor
@NoArgsConstructor


public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMaterial tipo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 65535, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    public enum TipoMaterial {
        RESINA, FILAMENTO
    }
}
