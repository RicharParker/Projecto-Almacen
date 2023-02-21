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
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_compra;
	
	@Nonnull
	private String fecha_compra;
	
	@Nonnull
	private float Total;
	
    @ManyToOne
    private Proveedor proveedor;
    
    @OneToOne
    private Compra_det compra_det;



	
	public Compra() {
		
	}
	
	

	public Compra(long id_compra, String fecha_compra, float total, Proveedor proveedor, Compra_det compra_det) {
		super();
		this.id_compra = id_compra;
		this.fecha_compra = fecha_compra;
		Total = total;
		this.proveedor = proveedor;
		this.compra_det = compra_det;
	}



	public Compra_det getCompra_det() {
		return compra_det;
	}



	public void setCompra_det(Compra_det compra_det) {
		this.compra_det = compra_det;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public long getId_compra() {
		return id_compra;
	}

	public void setId_compra(long id_compra) {
		this.id_compra = id_compra;
	}

	public String getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}
	
	

}
