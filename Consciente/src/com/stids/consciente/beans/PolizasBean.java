package com.stids.consciente.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.stids.consciente.models.Compania;
import com.stids.consciente.models.Polizas;
import com.stids.consciente.models.Producto;
import com.stids.consciente.models.TipoPoliza;
import com.stids.consciente.services.CompaniaServices;
import com.stids.consciente.services.ProductoServices;
import com.stids.consciente.services.TipoPolizaServices;

@Named("polizasBean")
@ViewScoped
public class PolizasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1555777803758028648L;

	private Integer numero;
	private Polizas polizas;

	private List<Polizas> listPolizas;
	private Polizas selectPolizas;

	private List<TipoPoliza> listTipoPoliza;
	private TipoPoliza tipoPoliza;
	private List<Compania> listEmpresas;
	private Compania compania;
	private List<Producto> listProductos;
	private Producto producto;

	@Inject
	TipoPolizaServices tipoPolizaService;

	@Inject
	CompaniaServices companiaService;

	@Inject
	ProductoServices productoService;

	public PolizasBean() {
		super();

	}

	@PostConstruct
	public void init() {
		listPolizas = new ArrayList<>();
		listTipoPoliza = new ArrayList<>();
		listEmpresas = new ArrayList<>();
		listProductos = new ArrayList<Producto>();
		iniciar();

	}

	private void iniciar() {
		listTipoPoliza = tipoPolizaService.getTipoPoliza();
		listEmpresas = companiaService.getCompanias();
		listProductos = productoService.getProductos();

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

	public List<TipoPoliza> getListTipoPoliza() {
		return listTipoPoliza;
	}

	public void setListTipoPoliza(List<TipoPoliza> listTipoPoliza) {
		this.listTipoPoliza = listTipoPoliza;
	}

	public TipoPoliza getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(TipoPoliza tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public List<Compania> getListEmpresas() {
		return listEmpresas;
	}

	public void setListEmpresas(List<Compania> listEmpresas) {
		this.listEmpresas = listEmpresas;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
