package com.ApiSpringHackathon.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "facturas")

public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private Long serie;
    private String folio;
    private String UUID;
    private Date fechaEmision;
    private Date fechaTimbrado;

    @ManyToOne
    @JoinColumn(name = "Cliente_id")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "Pedido_id")
    private Pedidos pedido;

    private Double total;
    private Double subtotal;
    private Double iva;
    private String formaPago;
    private String descripcion;
    private Double precioUnitario;
    //seria lo mismo que el id?
    private String codigoProducto;


    private String usoCfdi;


    @Lob // Para manejar datos binarios grandes (como XML)
    private String xmlCfdi;

    @Lob // Para manejar datos binarios grandes (como PDF)
    private byte[] pdfCfdi; // PDF del CFDI


    public String getXmlCfdi() {
        return xmlCfdi;
    }
}
