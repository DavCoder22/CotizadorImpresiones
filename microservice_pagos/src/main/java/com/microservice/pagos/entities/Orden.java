package com.microservice.pagos.entities;

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
@Table(name = "ordenes")
@AllArgsConstructor
@NoArgsConstructor
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrden;

    @Column(nullable = false, length = 255)
    private String imagenReferencia;

    @Column(nullable = false)
    private Integer materialId;

    @Column(nullable = false)
    private Integer printerId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoVolumen;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tiempoEstimado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costoTotal;

    @Column(name = "fechaPedido", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaPedido;
}
