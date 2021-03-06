package com.platzi.market.persistence.entity;

import ch.qos.logback.core.net.server.Client;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {
    @Id /*Indica a java que esta es la primarykey de la base de datos.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "id_cliente")
    private Integer idCliente;
    private LocalDateTime fecha;
    @Column(name = "medio_pago")
    private String medioPago;
    private String comentario;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name="id_cliente",insertable = false, updatable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "compra",cascade = {CascadeType.ALL})
    private List<ComprasProducto> productos;



    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
}
