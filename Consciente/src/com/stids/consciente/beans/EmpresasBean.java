package com.stids.consciente.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.stids.consciente.models.Asegurado;
import com.stids.consciente.models.Cliente;
import com.stids.consciente.models.Compania;
import com.stids.consciente.models.TipoPoliza;

@Named("empresasBean")
@RequestScoped
public class EmpresasBean implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long;
	private Compania compania;
	private String nit;
	private String nombre;
	private String direccion;
	private Integer telefono;
	private String email;
	private String ciudad;
	
	

	public void guardar() {
		System.out.println("Los datos son");
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	
	
	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
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

	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
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
		this.ciudad=ciudad;
	}
	
	
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
}
