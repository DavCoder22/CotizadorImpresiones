package com.microservice.inventario.entities;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "materiales")
@AllArgsConstructor
@NoArgsConstructor


public class Material {
    
    public enum TipoMaterial {
            resina, filamento
        }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    
}
