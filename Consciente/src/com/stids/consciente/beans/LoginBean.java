package com.stids.consciente.beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stids.consciente.services.LoginServices;
import com.stids.consciente.services.TipoClienteServices;


@Named("loginBean")
@SessionScoped
public class LoginBean  implements Serializable{

	
	private static final long serialVersionUID = 1555777803758086998L;
	
	private String user;
	private String password;
	
	
	@Inject
	LoginServices loginService;
	
	
	public void login() {
		System.out.println("user "+ user+ " pass "+password);
		password=getHash(password, "SHA1");
		loginService.getUser(user, password);
		
		
		
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
			System.out.println("Ha ocurrido un error "+ e.getMessage());
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
