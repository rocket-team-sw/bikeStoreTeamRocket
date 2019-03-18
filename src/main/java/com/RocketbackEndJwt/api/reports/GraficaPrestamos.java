package com.RocketbackEndJwt.api.reports;

public class GraficaPrestamos {
	private String nombre;
	private float total;
	
	public GraficaPrestamos(){
		
	}
	
	public GraficaPrestamos(GraficaPrestamos p){
		this.nombre = p.nombre;
		this.total = p.total;
	}

	public GraficaPrestamos(String nombre, float total) {
		this.nombre = nombre;
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}	
}
