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
import com.stids.consciente.models.TipoPoliza;


@Named
@RequestScoped
public class TipoPolizaServices {

	@Inject
	DriverMySQL conection;
	
	private List<TipoPoliza> listTipoPoliza;

	@PostConstruct
	public void init() {
		listTipoPoliza = new ArrayList<>();
	}

	public List<TipoPoliza> getTipoPoliza() {
		// Connection conectar=conection.getConnection();
		try {
			ResultSet rs = conection.getConnection().createStatement().executeQuery("select * from tipo_poliza");

			while (rs.next()) {
				TipoPoliza tipoPoliza = new TipoPoliza( rs.getInt(1),rs.getString(2));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
				listTipoPoliza.add(tipoPoliza);
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}
		conection.desconectar();
		return listTipoPoliza;
	}

}
