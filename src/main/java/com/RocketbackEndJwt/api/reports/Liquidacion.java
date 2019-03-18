package com.RocketbackEndJwt.api.reports;

public class Liquidacion {

	private int id;
	private String nombre;
	private Float cargado;
	private Float recaudo;
	private Float prestamos;
	private Float gastos;
	private String fecha;
	private String base;

	public Liquidacion() {

	}

	public Liquidacion(Liquidacion liquidacion) {
		this.id = liquidacion.id;
		this.nombre = liquidacion.nombre;
		this.cargado = liquidacion.cargado;
		this.recaudo = liquidacion.recaudo;
		this.prestamos = liquidacion.prestamos;
		this.gastos = liquidacion.gastos;
		this.fecha = liquidacion.fecha;
		this.base = liquidacion.base;
	}

	public Liquidacion(int id, String nombre, Float cargado, Float recaudo, Float prestamos, Float gastos,
			String fecha, String base) {
		this.id = id;
		this.nombre = nombre;
		this.cargado = cargado;
		this.recaudo = recaudo;
		this.prestamos = prestamos;
		this.gastos = gastos;
		this.fecha = fecha;
		this.base = base;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getCargado() {
		return cargado;
	}

	public void setCargado(Float cargado) {
		this.cargado = cargado;
	}

	public Float getRecaudo() {
		return recaudo;
	}

	public void setRecaudo(Float recaudo) {
		this.recaudo = recaudo;
	}

	public Float getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Float prestamos) {
		this.prestamos = prestamos;
	}

	public Float getGastos() {
		return gastos;
	}

	public void setGastos(Float gastos) {
		this.gastos = gastos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
}
