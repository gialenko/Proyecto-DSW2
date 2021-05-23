package com.ciberbanco.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="CIBERBANCO_TIPOS_DE_PRESTAMO")
public class TiposDePrestamo implements Serializable{
	
	@Id
	@Column(name="ID",nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DESCRIPCION",nullable = false)
	private String descripcion;
	
	@Column(name="PLAZO_MESES",nullable = false)
	private int plazos;
	
	@Column(name="MONTO",nullable = false)
	private int monto;
	
	@Column(name="MONEDA_ID",nullable = false)
	private int moneda_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="moneda_id",insertable = false,updatable = false)
	private Moneda moneda;
	
	@JsonProperty
	public Moneda getMoneda() {
		return moneda;
	}
	
	@JsonIgnore
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPlazos() {
		return plazos;
	}

	public void setPlazos(int plazos) {
		this.plazos = plazos;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getMoneda_id() {
		return moneda_id;
	}

	public void setMoneda_id(int moneda_id) {
		this.moneda_id = moneda_id;
	}
	
	

}
