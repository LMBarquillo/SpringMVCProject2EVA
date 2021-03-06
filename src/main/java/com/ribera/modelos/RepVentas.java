package com.ribera.modelos;

/**
 * Modelo usado para crear y modificar Representantes. (Oficina y director son integers con las claves externas)
 * @author Luismi
 */
public class RepVentas {
	private int numRep;
	private String nombre;
	private int edad;
	private int oficina;
	private int director;
	private int numVentas;
	private float impVentas;
	
	public RepVentas() {
		super();
	}
	
	public RepVentas(int numRep, String nombre, int edad, int oficina, int director, int numVentas, float impVentas) {
		super();
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
	
	public int getOficina() {
		return oficina;
	}
	
	public void setOficina(int oficina) {
		this.oficina = oficina;
	}
	
	public int getDirector() {
		return director;
	}
	
	public void setDirector(int director) {
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
