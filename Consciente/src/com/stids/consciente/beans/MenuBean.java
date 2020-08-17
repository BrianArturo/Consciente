package com.stids.consciente.beans;

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

	public void logout() {

		try {
			System.out.println("intentando cerrar sesion");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");

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
