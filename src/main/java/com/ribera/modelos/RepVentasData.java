package com.ribera.modelos;

/**
 * Modelo usado para la lista de Representantes. (Oficina y director son String)
 * @author Luismi
 */
public class RepVentasData {	
	private int numRep;
	private String nombre;
	private int edad;
	private String oficina;
	private String director;
	private int numVentas;
	private float impVentas;
	
	public RepVentasData() {
	}
	
	public RepVentasData(int numRep, String nombre, int edad, String oficina, String director, int numVentas, float impVentas) {
		this.numRep = numRep;
		this.nombre = nombre;
		this.edad = edad;
		this.oficina = oficina;
		this.director = director;
		this.numVentas = numVentas;
		this.impVentas = impVentas;
	}
	
	public int getNumRep() {
		return numRep;
	}
	
	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getNumVentas() {
		return numVentas;
	}
	
	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}
	
	public float getImpVentas() {
		return impVentas;
	}
	
	public void setImpVentas(float impVentas) {
		this.impVentas = impVentas;
	}
	
}
