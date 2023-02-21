package com.ulsa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_producto;
	
	@Nonnull
	private String name;
	
	@Nonnull
	private String descripcion;
	
	@Nonnull
	private float precio;
	
    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Inventario inventario;
    
    @OneToOne
    private Compra_det compra_det;

    
	public Producto() {
		
	}
	
	



	public Producto(long id_producto, String name, String descripcion, float precio, Categoria categoria,
			Inventario inventario, Compra_det compra_det) {
		super();
		this.id_producto = id_producto;
		this.name = name;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.inventario = inventario;
		this.compra_det = compra_det;
	}





	public Compra_det getCompra_det() {
		return compra_det;
	}





	public void setCompra_det(Compra_det compra_det) {
		this.compra_det = compra_det;
	}





	public Inventario getInventario() {
		return inventario;
	}




	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}




	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
