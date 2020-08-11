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
import com.stids.consciente.models.TipoPoliza;
import com.stids.consciente.services.CompaniaServices;
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
	private Polizas selectPolizas;
	private List<Polizas> listPolizas;

	private List<TipoPoliza> listTipoPoliza;
	private List<Compania> listEmpresas;
	private TipoPoliza tipoPoliza;
	private Compania compania;

	@Inject
	TipoPolizaServices tipoPolizaService;
	
	@Inject
	CompaniaServices companiaService;

	public PolizasBean() {
		super();

	}

	@PostConstruct
	public void init() {
		listPolizas = new ArrayList<>();
		listTipoPoliza = new ArrayList<>();
		listEmpresas = new ArrayList<>();
		iniciar();

	}

	private void iniciar() {
		listTipoPoliza = tipoPolizaService.getTipoPoliza();
		listEmpresas = companiaService.getCompanias();

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

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
