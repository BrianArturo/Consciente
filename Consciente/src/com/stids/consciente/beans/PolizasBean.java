package com.stids.consciente.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.stids.consciente.models.Polizas;

@Named("polizasBean")
@ViewScoped
public class PolizasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1555777803758028648L;
	private String nombre;
	private String apellido;
	private String ciudad;
	private String color;
	private Integer numero;
	private Polizas polizas;
	private Polizas selectPolizas;
	private List<Polizas> listPolizas;

	public PolizasBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		listPolizas = new ArrayList<>();
		iniciar();

	}

	private void iniciar() {
		Polizas polizas = new Polizas();
		polizas.setFecExpedicion("12334");
		polizas.setFecFinVigencia("4567");
		polizas.setNumPoliza(1L);
		polizas.setNumSoat(222L);
		listPolizas.add(polizas);
		listPolizas.add(polizas);
		listPolizas.add(polizas);
		listPolizas.add(polizas);
		listPolizas.add(polizas);

	}

	public Polizas getSelectPolizas() {
		return selectPolizas;
	}

	public void setSelectPolizas(Polizas selectPolizas) {
		this.selectPolizas = selectPolizas;
	}

	public List<Polizas> getListPolizas() {
		return listPolizas;
	}

	public void setListPolizas(List<Polizas> listPolizas) {
		this.listPolizas = listPolizas;
	}

	public Polizas getPolizas() {
		return polizas;
	}

	public void setPolizas(Polizas polizas) {
		this.polizas = polizas;
	}
	
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
