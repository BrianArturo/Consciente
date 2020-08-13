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
import com.stids.consciente.models.TipoCliente;

@Named
@RequestScoped
public class TipoClienteServices {

	@Inject
	DriverMySQL conection;
	
	private List<TipoCliente> listTipoCliente;

	@PostConstruct
	public void init() {
		listTipoCliente = new ArrayList<>();
	}

	public List<TipoCliente> getTipoCliente() {
		
		try {
			ResultSet rs = conection.getConnection().createStatement().executeQuery("select * from tipoclientes");

			while (rs.next()) {
				TipoCliente tipoCliente = new TipoCliente(rs.getLong(1),rs.getString(2));
				System.out.println(rs.getLong(1) + "  " + rs.getString(2));
				listTipoCliente.add(tipoCliente);
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}
	
		return listTipoCliente;
	}
	
	
}
