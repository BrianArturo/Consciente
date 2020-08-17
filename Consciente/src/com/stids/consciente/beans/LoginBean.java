package com.stids.consciente.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import com.stids.consciente.models.User;
import com.stids.consciente.services.LoginServices;
import com.stids.consciente.utils.Utilidades;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1555777803758086998L;

	private String user;
	private String password;
	private User usuario;

	@Inject
	Utilidades utilidades;

	@Inject
	LoginServices loginService;

	@PostConstruct
	public void init() {
		//clean();
	}

	public void login() {
		password = utilidades.getHash(password, "SHA1");
		usuario = loginService.getUser(user, password);
		String dataEncrypt;
		HttpSession session;
		FacesContext context;
		try {
			if (usuario != null && usuario.getEstado().equals("Activo")) {

				dataEncrypt=utilidades.enriptar(usuario);
				context = FacesContext.getCurrentInstance();
				//Si el parametro es true, crea una nueva sesion
				session = (HttpSession) context.getExternalContext().getSession(true);
				session.setAttribute("usuario", dataEncrypt);
				context.getExternalContext().redirect("pages/poliza.xhtml");
				System.out.println("Redireccionando");

			} else {
				PrimeFaces.current().executeScript("document.getElementById('form1:user').value = ''");
				PrimeFaces.current().executeScript("document.getElementById('form1:password').value = ''");
				PrimeFaces.current().executeScript("PF('dlg3').show()");
				System.out.println("Usuario o contraseña incorrecta");
			}

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en login " + e.getMessage());

		}

	}

	
	public void clean() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
