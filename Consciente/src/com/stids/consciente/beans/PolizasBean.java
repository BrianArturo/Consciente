package com.stids.consciente.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.stids.consciente.models.Asegurado;
import com.stids.consciente.models.Cliente;
import com.stids.consciente.models.Compania;
import com.stids.consciente.models.Polizas;
import com.stids.consciente.models.Producto;
import com.stids.consciente.models.TipoCliente;
import com.stids.consciente.models.TipoPoliza;
import com.stids.consciente.services.CompaniaServices;
import com.stids.consciente.services.ProductoServices;
import com.stids.consciente.services.TipoClienteServices;
import com.stids.consciente.services.TipoPolizaServices;

@Named("polizasBean")
@RequestScoped
public class PolizasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1555777803758028648L;

	private String numeroPoliza;
	private Integer numeroSoat;
	private String numeroPlaca;

	private Date fechaExpPoliza;
	private Date fechaIniVigencia;
	private Date fechaFinVigencia;
	private Date fechaPago;

	private Polizas polizas;
	private List<Polizas> listPolizas;
	private Polizas selectPolizas;

	private List<TipoPoliza> listTipoPoliza;
	private TipoPoliza tipoPoliza;
	private List<Compania> listEmpresas;
	private Compania compania;
	private List<Producto> listProductos;
	private Producto producto;

	private List<TipoCliente> listTipoCliente;
	private TipoCliente tipoCliente;

	private Long valorPoliza;
	private Long valorPrima;
	private Integer comision;
	private String porcentaje;
	private Long valorComision;

	private Cliente cliente;
	private Asegurado asegurado;



	@Inject
	TipoPolizaServices tipoPolizaService;

	@Inject
	CompaniaServices companiaService;

	@Inject
	ProductoServices productoService;

	@Inject
	TipoClienteServices tipoClienteService;

	public PolizasBean() {
		fechaExpPoliza = new Date();
		fechaIniVigencia = new Date();
		fechaFinVigencia = new Date();
		fechaPago =new Date();
		cliente= new Cliente();
		asegurado= new Asegurado();
		listPolizas = new ArrayList<>();
		listTipoPoliza = new ArrayList<>();
		listEmpresas = new ArrayList<>();
		listProductos = new ArrayList<>();
		listTipoCliente = new ArrayList<>();

	}

	@PostConstruct
	public void init() {
		iniciar();
		
	}

	private void iniciar() {
		listTipoPoliza = tipoPolizaService.getTipoPoliza();
		listEmpresas = companiaService.getCompanias();
		listProductos = productoService.getProductos();
		listTipoCliente = tipoClienteService.getTipoCliente();

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

	public void guardar() {
		
		System.out.println("Los datos son");
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

	public String getNumero() {
		return numeroPoliza;
	}

	public void setNumero(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
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

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Integer getNumeroSoat() {
		return numeroSoat;
	}

	public void setNumeroSoat(Integer numeroSoat) {
		this.numeroSoat = numeroSoat;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public Date getFechaExpPoliza() {
		return fechaExpPoliza;
	}

	public void setFechaExpPoliza(Date fechaExpPoliza) {
		this.fechaExpPoliza = fechaExpPoliza;
	}

	public Date getFechaIniVigencia() {
		return fechaIniVigencia;
	}

	public void setFechaIniVigencia(Date fechaIniVigencia) {
		this.fechaIniVigencia = fechaIniVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public List<TipoCliente> getListTipoCliente() {
		return listTipoCliente;
	}

	public void setListTipoCliente(List<TipoCliente> listTipoCliente) {
		this.listTipoCliente = listTipoCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
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

	public Long getValorPoliza() {
		return valorPoliza;
	}

	public void setValorPoliza(Long valorPoliza) {
		this.valorPoliza = valorPoliza;
	}

	public Long getValorPrima() {
		return valorPrima;
	}

	public void setValorPrima(Long valorPrima) {
		this.valorPrima = valorPrima;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Long getValorComision() {
		return valorComision;
	}

	public void setValorComision(Long valorComision) {
		this.valorComision = valorComision;
	}

	public Integer getComision() {
		return comision;
	}

	public void setComision(Integer comision) {
		this.comision = comision;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
