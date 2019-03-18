package com.RocketbackEndJwt.api.reports;

public class DineroCargado{

	private String id;	
	private String nombre;
	private float dinero;
	private String fecha;
	
	public DineroCargado(){
		
	}
	
	public DineroCargado(String id){
		this.id = id;
	}
	
	public DineroCargado(DineroCargado dinero){
		this.id = dinero.id;
		this.nombre = dinero.nombre;
		this.dinero = dinero.dinero;
		this.fecha = dinero.fecha;
	}

	public DineroCargado(String id, String nombre, float dinero, String fecha) {
		this.id = id;
		this.nombre = nombre;
		this.dinero = dinero;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}