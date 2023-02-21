package com.ulsa.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventarios")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_inventario;

	@Nonnull
	private String fecha;

	@Nonnull
	private float cantidad;

	@OneToMany(mappedBy = "inventario")
	private List<Producto> productos;

	public Inventario() {

	}
	

	public Inventario(long id_inventario, String fecha, float cantidad, List<Producto> productos) {
		super();
		this.id_inventario = id_inventario;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.productos = productos;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
