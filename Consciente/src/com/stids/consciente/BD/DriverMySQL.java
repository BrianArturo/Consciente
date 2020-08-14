package com.stids.consciente.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class DriverMySQL {

	Connection conexion = null;

	public DriverMySQL() {

	}

	@PostConstruct
	public void init() {

		String user = "root";
		String password = "";
		try {

			Properties datos = new Properties();
			datos.put("user", user);
			datos.put("password", password);
			String url2 = "jdbc:mysql://localhost:3306/consciente";
			conexion = DriverManager.getConnection(url2, datos);
			if (conexion != null) {
				System.out.println("Conexion satisfactoria");
			}


		} catch (SQLException e) {
			System.out.println("Error en la conexion"+e.getMessage());
			
		}
	}

	public Connection getConnection() {
		return conexion;
	}
	
	
	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Clase=>"+ this.getClass().getSimpleName() +"Ha ocurrido un error " +e.getMessage());
		}
	}

}