package com.stids.consciente.models;

public class Compania {

	private Integer id;
	private Long nit;
	private String nombre;
	private String direccion;
	private String telefono;
	private String telefonoContacto;

	public Compania() {
		super();
	}

	public Compania(Integer id,Long nit, String nombre, String direccion, String telefono, String telefonoContacto) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.telefonoContacto = telefonoContacto;
	}

	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	@Override
	public String toString() {
		return String.format("Compania [nit=%s, nombre=%s]", nit, nombre);
	}



	
	
}
