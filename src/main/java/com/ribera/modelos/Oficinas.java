package com.ribera.modelos;

public class Oficinas {
	private int oficina;
	private String ciudad;
	private Regiones region;
	private RepVentas director;
	private float ventas;
	
	public Oficinas() {		
	}
	
	public Oficinas(int oficina, String ciudad, Regiones region, RepVentas director, float ventas) {
		this.oficina = oficina;
		this.ciudad = ciudad;
		this.region = region;
		this.director = director;
		this.ventas = ventas;
	}

	public int getOficina() {
		return oficina;
	}
	
	public void setOficina(int oficina) {
		this.oficina = oficina;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Regiones getRegion() {
		return region;
	}
	
	public void setRegion(Regiones region) {
		this.region = region;
	}
	
	public RepVentas getDirector() {
		return director;
	}
	
	public void setDirector(RepVentas director) {
		this.director = director;
	}
	
	public float getVentas() {
		return ventas;
	}
	
	public void setVentas(float ventas) {
		this.ventas = ventas;
	}
	
}
