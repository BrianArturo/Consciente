package com.stids.consciente.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stids.consciente.BD.DriverMySQL;
import com.stids.consciente.models.Compania;

@Named
@RequestScoped
public class CompaniaServices {

	
	
	@Inject
	DriverMySQL conection;
	
	private List<Compania> listEmpresas;
	
	@PostConstruct
	public void init() {
		listEmpresas = new ArrayList<>();
	}
	
	public List<Compania> getCompanias() {
		
		try {
			ResultSet rs = conection.getConnection().createStatement().executeQuery("select * from empresas");

			while (rs.next()) {
				Compania compania = new Compania(rs.getInt(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2));
				listEmpresas.add(compania);
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}
		
		return listEmpresas;
	}
}
