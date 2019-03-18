package com.RocketbackEndJwt.rest;

public class RestPrestamo {
	private Long idPrestamo;
	private String fechaInicio;
	private String fechaFin;
	private float valorPrestamo;
	private int numeroCuotas;
	private float interes;
	private String plazo;
	private String diaPago;
	private float valorTotal;
	private float valorCuota;
	private String infoAdicional;
	private float saldo;
	private int cuotasPagas;
	private Long idCliente;
	private String nombreCliente;
	private int orden;
	private String puntoReferencia;
	
	public RestPrestamo() {
		
	}
	
	public RestPrestamo(Long idPrestamo, String fechaInicio, String fechaFin, float valorPrestamo, int numeroCuotas,
			float interes, String plazo, String diaPago, float valorTotal, float valorCuota, String infoAdicional,
			float saldo, int cuotasPagas, Long idCliente, String nombreCliente, int orden, String puntoReferencia) {
		this.idPrestamo = idPrestamo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorPrestamo = valorPrestamo;
		this.numeroCuotas = numeroCuotas;
		this.interes = interes;
		this.plazo = plazo;
		this.diaPago = diaPago;
		this.valorTotal = valorTotal;
		this.valorCuota = valorCuota;
		this.infoAdicional = infoAdicional;
		this.saldo = saldo;
		this.cuotasPagas = cuotasPagas;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.orden = orden;
		this.puntoReferencia = puntoReferencia;
	}

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long long1) {
		this.idPrestamo = long1;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getValorPrestamo() {
		return valorPrestamo;
	}

	public void setValorPrestamo(float valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getDiaPago() {
		return diaPago;
	}

	public void setDiaPago(String diaPago) {
		this.diaPago = diaPago;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public float getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(float valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
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

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getPuntoReferencia() {
		return puntoReferencia;
	}

	public void setPuntoReferencia(String puntoReferencia) {
		this.puntoReferencia = puntoReferencia;
	}
	
}