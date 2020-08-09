package com.stids.consciente.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("polizasBean")
@ViewScoped
public class PolizasBean implements Serializable {

	private String nombre;
	private String apellido;
	private String ciudad;
	private String color;
	private Integer numero;

	public PolizasBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void enviar() {
		System.out.println("Valor del form=>"+numero);
		
	}

}
