package com.stids.consciente.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DriverMySQL {

	public static void main(String[] args) {

		// conexiones
		Connection conexion1 = null;
		Connection conexion2 = null;
		Connection conexion3 = null;

		// usuario y clave
		String user = "root";
		String password = "";
		try {

			// una sola cadena de conexi贸n, en un s贸lo par谩metro se concatena el
			// usuario y el password
			String url1 = "jdbc:mysql://localhost:3306/test?user=" + user + "&pasword=" + password;
			conexion1 = DriverManager.getConnection(url1);
			if (conexion1 != null) {
				System.out.println("Conexi騨 1: Conexi贸n a mibase satisfacoria");
			}

			// se env铆a la cadena y los datos de usuario y password por separado
			Properties datos = new Properties();
			datos.put("user", user);
			datos.put("password", password);
			String url2 = "jdbc:mysql://localhost:3306/test";
			conexion2 = DriverManager.getConnection(url2, datos);
			if (conexion2 != null) {
				System.out.println("Conexi贸n 2: Conexi贸n a mibase satisfacoria");
			}

			// se env铆a la cadena, el usuario y el password por separado
			String url3 = "jdbc:mysql://localhost:3306/test";
			conexion3 = DriverManager.getConnection(url3, user, password);
			if (conexion3 != null) {
				System.out.println("Conexi贸n 3: Conexi贸n a mibase satisfacoria");
			}
			
			ResultSet rs=conexion3.createStatement().executeQuery("select * from prueba");  
			//ResultSet rs=stmt.executeQuery("select * from prueba");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			conexion3.close(); 
			
			
		} catch (SQLException e) {
			System.out.println(
					"Error en la conexi贸n, verifique, su usuario y password o el nombre de la base a la que intenta conectarse");
			e.printStackTrace();
		}
	}
}