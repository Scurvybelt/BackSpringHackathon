package com.ApiSpringHackathon.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Detalle_MedioPago")


public class Detalle_MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int consecutivo;
    private Long idMedioPago;
    private Long idPedido;


    @ManyToMany
    @JoinTable(
            name = "MedioPago",
            joinColumns = @JoinColumn(name = "Detalle_MedioPago_id"),
            inverseJoinColumns = @JoinColumn(name = "MedioPago_id")
    )
    private Set<ProductoServicio> productoServicios;

    @ManyToMany
    @JoinTable(
            name = "Pedidos",
            joinColumns = @JoinColumn(name = "Detalle_MedioPago_id"),
            inverseJoinColumns = @JoinColumn(name = "Pedidos_id")
    )
    private Set<Pedidos> pedidos;
}
