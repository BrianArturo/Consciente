package com.stids.consciente.beans;

import java.io.IOException;
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

	}

	public void login() {
		System.out.println("user " + user + " pass " + password);
		
		password = getHash(password, "SHA1");
		usuario = loginService.getUser(user, password);
		String dataEncrypt;
		try {
			if (usuario != null && usuario.getEstado().equals("Activo")) {

				dataEncrypt=utilidades.enriptar(usuario);
				FacesContext context = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
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

	public String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Ha ocurrido un error " + e.getMessage());
		}
		return null;
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
