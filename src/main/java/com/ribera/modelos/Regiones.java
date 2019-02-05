package com.ribera.modelos;

public class Regiones {
	private int codRegion;
	private String nombreRegion;
	
	public Regiones() {
		
	}
	
	public Regiones(int codRegion, String nombreRegion) {
		setCodRegion(codRegion);
		setNombreRegion(nombreRegion);
	}	

	public int getCodRegion() {
		return codRegion;
	}

	public void setCodRegion(int codRegion) {
		this.codRegion = codRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}
	
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
	
	
}
