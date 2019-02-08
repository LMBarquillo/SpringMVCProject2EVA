package com.ribera.modelos;

public class OficinasData {
	private int oficina;
	private String ciudad;
	private String region;
	private int numRepresentantes;
	private String director;
	
	public OficinasData() {
		
	}
	
	public OficinasData(int oficina, String ciudad, String region, int numRepresentantes, String director) {
		this.oficina = oficina;
		this.ciudad = ciudad;
		this.region = region;
		this.numRepresentantes = numRepresentantes;
		this.director = director;
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
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public int getNumRepresentantes() {
		return numRepresentantes;
	}
	
	public void setNumRepresentantes(int numRepresentantes) {
		this.numRepresentantes = numRepresentantes;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
}
