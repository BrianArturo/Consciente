package com.stids.consciente.beans;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stids.consciente.models.Cliente;
import com.stids.consciente.models.Compania;
import com.stids.consciente.models.Polizas;
import com.stids.consciente.models.Producto;
import com.stids.consciente.models.TipoCliente;
import com.stids.consciente.models.TipoPoliza;
import com.stids.consciente.models.User;
import com.stids.consciente.services.CompaniaServices;
import com.stids.consciente.services.ProductoServices;
import com.stids.consciente.services.TipoClienteServices;
import com.stids.consciente.services.TipoPolizaServices;
import com.stids.consciente.utils.Utilidades;

@Named("polizasBean")
@ViewScoped
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
	private Cliente cliente;
	

	private transient Gson gson;

	@Inject
	TipoPolizaServices tipoPolizaService;

	@Inject
	CompaniaServices companiaService;

	@Inject
	ProductoServices productoService;

	@Inject
	TipoClienteServices tipoClienteService;

	@Inject
	Utilidades utilidades;

	public PolizasBean() {
	
		listPolizas = new ArrayList<>();
		listTipoPoliza = new ArrayList<>();
		listEmpresas = new ArrayList<>();
		listProductos = new ArrayList<>();
		listTipoCliente = new ArrayList<>();

	}

	@PostConstruct
	public void init() {

		gson = new GsonBuilder().create();
		HttpSession session;
		FacesContext context;
		String dataEncrypt;
		String data;
		User usuario;

		try {
			context = FacesContext.getCurrentInstance();
			session = (HttpSession) context.getExternalContext().getSession(true);
			dataEncrypt = (String) session.getAttribute("usuario");
			data = utilidades.decrypt(dataEncrypt);
			usuario = gson.fromJson(data, User.class);

			if (usuario != null && usuario.getEstado().equals("Activo")) {
				System.out.println("Inicio exitoso continuar");
				iniciar();
			} else {
				salir();
			}

		} catch (Exception e) {
			System.out.println("Clase "+this.getClass().getSimpleName()+" Ha ocurrido un error " + e.getMessage());
			salir();
		}

		
		

	}

	public void salir() {
		HttpSession session;
		try {
			session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.invalidate();
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			System.out.println("Cerrando sesion " + e.getMessage());

		}
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



	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
