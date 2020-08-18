package com.stids.consciente.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.stids.consciente.models.Compania;
import com.stids.consciente.models.TipoPoliza;

@Named("empresasBean")
@RequestScoped
public class EmpresasBean implements Serializable {
   
	//private static final long;
	private Compania compania;

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	
	
	
	
	
}
