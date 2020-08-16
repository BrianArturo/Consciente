package com.stids.consciente.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stids.consciente.models.User;
import com.stids.consciente.utils.Utilidades;

@Named("menuBean")
@SessionScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 678909876L;

	@Inject
	Utilidades utilidades;

	private User usuario;

	public MenuBean() {
		
	}

	@PostConstruct
	public void init() {

		usuario = utilidades.getUsuario();

	}

	public void salir() {

		try {
			System.out.println("intentando cerrar sesion");
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			System.out.println("Cerrando sesion " + e.getMessage());

		}

	}
	
public void logout() {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
			
		} catch (Exception e) {
			System.out.println("Cerrando sesion " + e.getMessage());

		}
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
