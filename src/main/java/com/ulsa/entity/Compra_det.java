package com.ulsa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_detalles")
public class Compra_det {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_compraDetalle;
	
	@Nonnull
	private float precio_unit;
	
	@Nonnull
	private float cantidad;
	
    @OneToOne
    private Producto producto;

    @OneToOne
    private Compra compra;
	
	public Compra_det() {
		
	}

	
	public Compra_det(long id_compraDetalle, float precio_unit, float cantidad, Producto producto, Compra compra) {
		super();
		this.id_compraDetalle = id_compraDetalle;
		this.precio_unit = precio_unit;
		this.cantidad = cantidad;
		this.producto = producto;
		this.compra = compra;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public long getId_compraDetalle() {
		return id_compraDetalle;
	}

	public void setId_compraDetalle(long id_compraDetalle) {
		this.id_compraDetalle = id_compraDetalle;
	}

	public float getPrecio_unit() {
		return precio_unit;
	}

	public void setPrecio_unit(float precio_unit) {
		this.precio_unit = precio_unit;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	
}
