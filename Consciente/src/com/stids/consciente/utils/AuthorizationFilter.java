package com.stids.consciente.utils;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omnifaces.filter.HttpFilter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stids.consciente.models.User;

@WebFilter(filterName = "AuthFilter")
public class AuthorizationFilter extends HttpFilter {

	@Inject
	Utilidades utilidades;

	private transient Gson gson = new GsonBuilder().create();

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			FilterChain chain) throws ServletException, IOException {

		String dataEncrypt;
		String startPage = "/index.xhtml";
		String data;
		User usuario;

		try {
			if (session != null && session.getAttribute("usuario") != null) {

				dataEncrypt = (String) session.getAttribute("usuario");
				data = utilidades.decrypt(dataEncrypt);
				usuario = gson.fromJson(data, User.class);

				if (usuario == null || usuario.getEstado().equals("Inactivo")) {
					session.invalidate();
				}
				utilidades.setUsuario(usuario);

			} else {
				// Servlets.facesRedirect(request, response, startPage);
				response.sendRedirect(request.getContextPath() + startPage);
			}

		} catch (Exception e) {
			// Servlets.facesRedirect(request, response, startPage);
			response.sendRedirect(request.getContextPath() + startPage);
			// session.invalidate();

		}
		if (session != null && session.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
