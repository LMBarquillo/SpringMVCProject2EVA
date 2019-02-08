package com.ribera.modelos;

public class RegionesData {
	private int codRegion;
	private String nombre;
	private int numOficinas;
	private float totalVentas;
	
	public RegionesData() {
		
	}
		
	public RegionesData(int codRegion, String nombre, int numOficinas, float totalVentas) {
		super();
		this.codRegion = codRegion;
		this.nombre = nombre;
		this.numOficinas = numOficinas;
		this.totalVentas = totalVentas;
	}

	public int getCodRegion() {
		return codRegion;
	}
	
	public void setCodRegion(int codRegion) {
		this.codRegion = codRegion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNumOficinas() {
		return numOficinas;
	}
	
	public void setNumOficinas(int numOficinas) {
		this.numOficinas = numOficinas;
	}
	
	public float getTotalVentas() {
		return totalVentas;
	}
	
	public void setTotalVentas(float totalVentas) {
		this.totalVentas = totalVentas;
	}	
}
