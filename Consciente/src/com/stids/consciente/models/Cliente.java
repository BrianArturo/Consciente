package com.stids.consciente.models;

public class Cliente {

	private Tipo tipo;
	private String tomador;
	private Long identificacion;
	private String direccion;
	private String telefono;
	private String email;
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getTomador() {
		return tomador;
	}

	public void setTomador(String tomador) {
		this.tomador = tomador;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}