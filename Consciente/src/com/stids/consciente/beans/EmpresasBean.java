package com.stids.consciente.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.stids.consciente.models.Asegurado;
import com.stids.consciente.models.Cliente;
import com.stids.consciente.models.Compania;
import com.stids.consciente.models.TipoPoliza;

@Named("empresasBean")
@RequestScoped
public class EmpresasBean implements Serializable {
   
	//private static final long;
	private Compania compania;
	private String Nit;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String ciudad;
	
	
	public EmpresasBean() {


	}
	

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	
	
	public void getNit() {
		return Nit;
	}
	
	public void setNit(Long Nit) {
		this.Nit = Nit;
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

	public Float getTelefono() {
		return telefono;
	}

	public void setTelefono(Float telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		return ciudad;
	}
	
	
	
}
