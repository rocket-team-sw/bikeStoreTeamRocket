package com.RocketbackEndJwt.api.reports;

public class ClientesAEliminar {
	
	Long idCliente;
	String nombreCliente;
	float valorPrestamo;
	float saldoPendiente;
	String fechaInicioPrestamo;
	
	public ClientesAEliminar() {
		super();
	}
	public ClientesAEliminar(Long idCliente, String nombreCliente, float valorPrestamo, float saldoPendiente,
			String fechaInicioPrestamo) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.valorPrestamo = valorPrestamo;
		this.saldoPendiente = saldoPendiente;
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public float getValorPrestamo() {
		return valorPrestamo;
	}
	public void setValorPrestamo(float valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
	}
	public float getSaldoPendiente() {
		return saldoPendiente;
	}
	public void setSaldoPendiente(float saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}
	public String getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}
	public void setFechaInicioPrestamo(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}
}
