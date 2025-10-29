package com.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
}
