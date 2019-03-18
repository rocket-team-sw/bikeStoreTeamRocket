package com.RocketbackEndJwt.api.reports;

public class ReporteGeneral{
	
	private String id;
	private String nombre;
	private float prestado;
	private float saldo;
	
	public ReporteGeneral(){
		
	}
	
	public ReporteGeneral(String id){
		this.id = id;
	}

	public ReporteGeneral(ReporteGeneral reporte){
		this.id = reporte.id;
		this.nombre = reporte.nombre;
		this.prestado = reporte.prestado;
		this.saldo = reporte.saldo;
	}

	public ReporteGeneral(String id, String nombre, float prestado, float saldo) {
		this.id = id;
		this.nombre = nombre;
		this.prestado = prestado;
		this.saldo = saldo;
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

	public float getPrestado() {
		return prestado;
	}

	public void setPrestado(float prestado) {
		this.prestado = prestado;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
