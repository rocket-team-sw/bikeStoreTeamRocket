package com.RocketbackEndJwt.api.reports;


public class EstadoClientes{

	private String nombre;
	private String gestor;
	private String estado;
	private String cuotas;
	private String diasSinPago;
	private String ultimoAbono;
	private String idPrestamo;
	private String fechaInicioPrestamo;
	private String valorPrestamo;
	
	public EstadoClientes(){
		
	}

	public EstadoClientes(String nombre, String gestor, String estado, String cuotas, String diasSinPago, String ultimoAbono, String idPrestamo, String fechaInicioPrestamo, String valorPrestamo) {
		super();
		this.nombre = nombre;
		this.gestor = gestor;
		this.estado = estado;
		this.cuotas = cuotas;
		this.diasSinPago = diasSinPago;
		this.ultimoAbono = ultimoAbono;
		this.idPrestamo = idPrestamo;
		this.fechaInicioPrestamo = fechaInicioPrestamo;
		this.valorPrestamo = valorPrestamo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public String getDiasSinPago() {
		return diasSinPago;
	}

	public void setDiasSinPago(String diasSinPago) {
		this.diasSinPago = diasSinPago;
	}

	public String getUltimoAbono() {
		return ultimoAbono;
	}

	public void setUltimoAbono(String ultimoAbono) {
		this.ultimoAbono = ultimoAbono;
	}

	public String getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(String idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public String getValorPrestamo() {
		return valorPrestamo;
	}

	public void setValorPrestamo(String valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
	}
}
