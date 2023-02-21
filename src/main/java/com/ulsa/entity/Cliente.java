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
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_cliente;

	@Nonnull
	private String name;

	@Nonnull
	private String surname;

	@Nonnull
	private String email;

	@Nonnull
	private String telefono;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	@OneToMany(mappedBy = "cliente")
	private List<Venta> ventas;

	public Cliente() {

	}

	

	public Cliente(long id_cliente, String name, String surname, String email, String telefono, List<Pedido> pedidos,
			List<Venta> ventas) {
		super();
		this.id_cliente = id_cliente;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telefono = telefono;
		this.pedidos = pedidos;
		this.ventas = ventas;
	}



	public List<Venta> getVentas() {
		return ventas;
	}



	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}



	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
