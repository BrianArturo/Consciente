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

	private User user;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public User getUser(String login, String password) {

		try {
			PreparedStatement pstBuscarCodigo;
			
			String sqlBusqueda = "SELECT * FROM users WHERE user=? and clave=?";
			pstBuscarCodigo = conection.getConnection().prepareStatement(sqlBusqueda);
			pstBuscarCodigo.setString(1, login);
			pstBuscarCodigo.setString(2, password);
			ResultSet rs = pstBuscarCodigo.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getLong(1) + "  " + rs.getString(2));

			} else {
				return null;
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}

		return user;
	}

}
