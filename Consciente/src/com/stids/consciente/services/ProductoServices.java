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
import com.stids.consciente.models.Producto;

@Named
@RequestScoped
public class ProductoServices {

	@Inject
	DriverMySQL conection;

	private List<Producto> listProductos;

	@PostConstruct
	public void init() {
		listProductos = new ArrayList<>();
	}

	public List<Producto> getProductos() {

		try {
			ResultSet rs = conection.getConnection().createStatement().executeQuery("select * from productos");

			while (rs.next()) {
				Producto producto = new Producto(rs.getLong(1), rs.getString(2), rs.getString(3));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
				listProductos.add(producto);
			}

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error" + e.getMessage());
		}

		return listProductos;
	}

}
