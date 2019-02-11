package com.ribera.modelos;

public class RepVentas {	
	private int numRep;
	private String nombre;
	private int edad;
	private Oficinas oficina;
	private RepVentas director;
	private int numVentas;
	private float impVentas;
	
	public RepVentas() {
	}
	
	public RepVentas(int numRep, String nombre, int edad, Oficinas oficina, RepVentas director, int numVentas, float impVentas) {
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
	
	public Oficinas getOficina() {
		return oficina;
	}

	public void setOficina(Oficinas oficina) {
		this.oficina = oficina;
	}

	public RepVentas getDirector() {
		return director;
	}

	public void setDirector(RepVentas director) {
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
