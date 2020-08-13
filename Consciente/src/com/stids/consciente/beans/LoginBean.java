package com.stids.consciente.beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("loginBean")
@SessionScoped
public class LoginBean  implements Serializable{

	
	private static final long serialVersionUID = 1555777803758086998L;
	
	private String user;
	private String password;
	
	
	
	public void login() {
		System.out.println("user "+ user+ " pass "+password);
		
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
