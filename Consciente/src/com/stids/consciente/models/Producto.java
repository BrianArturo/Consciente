package com.stids.consciente.models;

public class Producto {

	private Long id;
	private String codigo;
	private String nombre;

	public Producto() {
		super();

	}
	
	

	public Producto(Long id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return nombre;
	}
	
	

}
