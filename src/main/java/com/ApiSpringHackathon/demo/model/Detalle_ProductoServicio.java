package com.ApiSpringHackathon.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Detalle_productoServicio")

public class Detalle_ProductoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToMany
    @JoinTable(
            name = "ProductoServicio",
            joinColumns = @JoinColumn(name = "Detalle_productoServicio_id"),
            inverseJoinColumns = @JoinColumn(name = "ProductoServicio_id")
    )
    private Set<ProductoServicio> productoServicios;

    @ManyToMany
    @JoinTable(
            name = "Pedidos",
            joinColumns = @JoinColumn(name = "Detalle_productoServicio_id"),
            inverseJoinColumns = @JoinColumn(name = "Pedidos_id")
    )
    private Set<Pedidos> pedidos;
}
