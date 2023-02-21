package com.ulsa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_venta;
	
	@Nonnull
	private String fecha_venta;
	
	@Nonnull
	private float total;
	
    @ManyToOne
    private Cliente cliente;

	
	public Venta() {
		
	}
	
	

	public Venta(long id_venta, String fecha_venta, float total, Cliente cliente) {
		super();
		this.id_venta = id_venta;
		this.fecha_venta = fecha_venta;
		this.total = total;
		this.cliente = cliente;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public long getId_venta() {
		return id_venta;
	}

	public void setId_venta(long id_venta) {
		this.id_venta = id_venta;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	


}
