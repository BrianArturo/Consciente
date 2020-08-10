package com.stids.consciente.models;

import java.util.Date;

public class Polizas {

	private TipoPoliza poliza;
	private Compania compania;
	private Producto producto;
	private Long numPoliza;
	private Long numSoat;
	private String numPlaca;
	private String fecExpedicion;
	private String fecIniVigencia;
	private String fecFinVigencia;
	private Date fecPago;
	private Cliente cliente;
	private Asegurado asegurado;
	
	

	public Polizas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoPoliza getPoliza() {
		return poliza;
	}

	public void setPoliza(TipoPoliza poliza) {
		this.poliza = poliza;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(Long numPoliza) {
		this.numPoliza = numPoliza;
	}

	public Long getNumSoat() {
		return numSoat;
	}

	public void setNumSoat(Long numSoat) {
		this.numSoat = numSoat;
	}

	public String getNumPlaca() {
		return numPlaca;
	}

	public void setNumPlaca(String numPlaca) {
		this.numPlaca = numPlaca;
	}

	public String getFecExpedicion() {
		return fecExpedicion;
	}

	public void setFecExpedicion(String fecExpedicion) {
		this.fecExpedicion = fecExpedicion;
	}

	public String getFecIniVigencia() {
		return fecIniVigencia;
	}

	public void setFecIniVigencia(String fecIniVigencia) {
		this.fecIniVigencia = fecIniVigencia;
	}

	public String getFecFinVigencia() {
		return fecFinVigencia;
	}

	public void setFecFinVigencia(String fecFinVigencia) {
		this.fecFinVigencia = fecFinVigencia;
	}

	public Date getFecPago() {
		return fecPago;
	}

	public void setFecPago(Date fecPago) {
		this.fecPago = fecPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Asegurado getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}

}
