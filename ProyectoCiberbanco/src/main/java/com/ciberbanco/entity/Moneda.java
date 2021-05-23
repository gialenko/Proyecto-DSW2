package com.ciberbanco.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CIBERBANCO_MONEDAS")
public class Moneda implements Serializable{
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID",nullable = false, unique = true)
private int id;

@Column(name="MONEDA")
private String moneda;

@OneToMany(mappedBy = "moneda_des")
private List<TiposDeCambio> tiposDeCambio;

@OneToMany(mappedBy = "moneda_org")
private List<TiposDeCambio> tiposDeCambios;

@OneToMany(mappedBy = "moneda",fetch = FetchType.LAZY)
@JsonIgnore
private List<TiposDePrestamo> tiposDePrestamo;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMoneda() {
	return moneda;
}

public void setMoneda(String moneda) {
	this.moneda = moneda;
}


	
}
