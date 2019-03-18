package com.RocketbackEndJwt.rest;

public class RestUser {
	private Long Id;
	private String Name;
	private float Caja;
	private String Rol;
	private float interes;
	private int numeroCuotas;
	private int maximoAbonos;
	private int topePrestamos;
	
	public RestUser() {
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public float getCaja() {
		return Caja;
	}

	public void setCaja(float caja) {
		Caja = caja;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public int getMaximoAbonos() {
		return maximoAbonos;
	}

	public void setMaximoAbonos(int maximoAbonos) {
		this.maximoAbonos = maximoAbonos;
	}

	public int getTopePrestamos() {
		return topePrestamos;
	}

	public void setTopePrestamos(int topePrestamos) {
		this.topePrestamos = topePrestamos;
	}
	
}