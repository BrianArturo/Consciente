package com.stids.consciente.models;

public class TipoCliente {

	private Long id;
	private String nombre;

	public TipoCliente() {
		super();
	}

	
	
	public TipoCliente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
