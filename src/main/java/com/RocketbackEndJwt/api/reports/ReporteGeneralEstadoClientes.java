package com.RocketbackEndJwt.api.reports;

public class ReporteGeneralEstadoClientes {
	
	private String gestor;
	private String cliente;
	private String fechaInicio;
	private String fechaFin;
	private String valorPrestamo;
	private String valorTotal;
	private String interes;
	private String pagado;
	private String saldo;
	private String cuotas;
	private String cuotasPagas;
	private String cuotasPendientes;
	private String diasInicioPrestamo;
	private String diasEstimadosPrestamo;
	private float porcentajeTiempo;
	private float porcentajePago;
	private String estadoCliente;

	public ReporteGeneralEstadoClientes() {
		super();
	}

	public ReporteGeneralEstadoClientes(String gestor, String cliente, String fechaInicio, String fechaFin,
			String valorPrestamo, String valorTotal, String interes, String pagado, String saldo, String cuotas,
			String cuotasPagas, String cuotasPendientes, String diasInicioPrestamo, String diasEstimadosPrestamo,
			float porcentajeTiempo, float porcentajePago, String estadoCliente) {
		super();
		this.gestor = gestor;
		this.cliente = cliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorPrestamo = valorPrestamo;
		this.valorTotal = valorTotal;
		this.interes = interes;
		this.pagado = pagado;
		this.saldo = saldo;
		this.cuotas = cuotas;
		this.cuotasPagas = cuotasPagas;
		this.cuotasPendientes = cuotasPendientes;
		this.diasInicioPrestamo = diasInicioPrestamo;
		this.diasEstimadosPrestamo = diasEstimadosPrestamo;
		this.porcentajeTiempo = porcentajeTiempo;
		this.porcentajePago = porcentajePago;
		this.estadoCliente = estadoCliente;
	}



	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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

	public String getValorPrestamo() {
		return valorPrestamo;
	}

	public void setValorPrestamo(String valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String pagado) {
		this.pagado = pagado;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public String getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(String cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	public String getCuotasPendientes() {
		return cuotasPendientes;
	}

	public void setCuotasPendientes(String cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}

	public String getDiasInicioPrestamo() {
		return diasInicioPrestamo;
	}

	public void setDiasInicioPrestamo(String diasInicioPrestamo) {
		this.diasInicioPrestamo = diasInicioPrestamo;
	}

	public String getDiasEstimadosPrestamo() {
		return diasEstimadosPrestamo;
	}

	public void setDiasEstimadosPrestamo(String diasEstimadosPrestamo) {
		this.diasEstimadosPrestamo = diasEstimadosPrestamo;
	}

	public float getPorcentajeTiempo() {
		return porcentajeTiempo;
	}

	public void setPorcentajeTiempo(float porcentajeTiempo) {
		this.porcentajeTiempo = porcentajeTiempo;
	}

	public float getPorcentajePago() {
		return porcentajePago;
	}

	public void setPorcentajePago(float porcentajePago) {
		this.porcentajePago = porcentajePago;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	
	
}
