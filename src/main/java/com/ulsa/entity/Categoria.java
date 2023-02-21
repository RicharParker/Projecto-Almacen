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
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_categoria;

	@Nonnull
	private String name;

	@Nonnull
	private String descripcion;

	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;

	public Categoria() {

	}
	

	public Categoria(long id_categoria, String name, String descripcion, List<Producto> productos) {
		super();
		this.id_categoria = id_categoria;
		this.name = name;
		this.descripcion = descripcion;
		this.productos = productos;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
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

}
