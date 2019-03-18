package com.RocketbackEndJwt.api.reports;

public class RecaudoDiario {
	
	private String id;
	private String nombre;
	private String fecha;
	private float valor;
	
	public RecaudoDiario(){
		
	}
	
	public RecaudoDiario(String id){
		this.id = id;
	}
	
	public RecaudoDiario(RecaudoDiario recaudo){
		this.id = recaudo.id;
		this.nombre = recaudo.nombre;
		this.fecha = recaudo.fecha;
		this.valor = recaudo.valor;
	}

	public RecaudoDiario(String id, String nombre, String fecha, float valor) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.valor = valor;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}