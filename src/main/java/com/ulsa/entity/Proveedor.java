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
@Table(name = "proveedores")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_proveedor;

	@Nonnull
	private String name;

	@Nonnull
	private String direccion;

	@Nonnull
	private String telefono;

	@OneToMany(mappedBy = "proveedor")
	private List<Compra> compra;

	public Proveedor() {

	}
	
	

	public Proveedor(long id_proveedor, String name, String direccion, String telefono, List<Compra> compra) {
		super();
		this.id_proveedor = id_proveedor;
		this.name = name;
		this.direccion = direccion;
		this.telefono = telefono;
		this.compra = compra;
	}



	public List<Compra> getCompra() {
		return compra;
	}



	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}



	public long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
