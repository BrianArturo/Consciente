package com.stids.consciente.models;

public class Policies {
	
	private String companySec;
	private Product produc;
	private String policy;
	private String soat;
	
	
	
	
	
	
	public Policies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policies(String companySec, Product produc, String policies, String soat) {
		super();
		this.companySec = companySec;
		this.produc = produc;
		this.policy = policies;
		this.soat = soat;
	}
	public String getCompanySec() {
		return companySec;
	}
	public void setCompanySec(String companySec) {
		this.companySec = companySec;
	}
	public Product getProduc() {
		return produc;
	}
	public void setProduc(Product produc) {
		this.produc = produc;
	}
	public String getPolicies() {
		return policy;
	}
	public void setPolicies(String policies) {
		this.policy = policies;
	}
	public String getSoat() {
		return soat;
	}
	public void setSoat(String soat) {
		this.soat = soat;
	}
	
	

}
