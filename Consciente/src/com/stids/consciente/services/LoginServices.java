package com.stids.consciente.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stids.consciente.BD.DriverMySQL;
import com.stids.consciente.models.User;

@Named
@RequestScoped
public class LoginServices {

	@Inject
	DriverMySQL conection;

	private User usuario;

	@PostConstruct
	public void init() {
		usuario = new User();
	}

	public User getUser(String user, String password) {

		try {
			PreparedStatement pstBuscarCodigo;
			
			String sqlBusqueda = "SELECT * FROM users WHERE user=? and clave=?";
			pstBuscarCodigo = conection.getConnection().prepareStatement(sqlBusqueda);
			pstBuscarCodigo.setString(1, user);
			pstBuscarCodigo.setString(2, password);
			ResultSet rs = pstBuscarCodigo.executeQuery();
			if (rs.next()) {
				//System.out.println(rs.getLong(1) + "  " + rs.getString(2));
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setIdentificacion(rs.getString(3));
				usuario.setUser(rs.getString(4));
				usuario.setRol(rs.getString(6));
				usuario.setEstado(rs.getString(9));

			} else {
				return null;
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}

		return usuario;
	}

}
