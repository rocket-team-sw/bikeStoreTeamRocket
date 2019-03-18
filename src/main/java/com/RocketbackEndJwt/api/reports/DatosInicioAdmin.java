package com.RocketbackEndJwt.api.reports;

public class DatosInicioAdmin {
	
	public int dineroEnCaja;
	
	public int debidoCobrar;
	
	public int totalRecogido;
	
	public int totalPrestado;
	
	public int clientesVisitados;
	
	public int clientesPendientesVisita;
	
	public String ultimoClienteVisitado;
	
	public int totalGastos;

	public DatosInicioAdmin(int dineroEnCaja, int debidoCobrar, int totalRecogido, int totalPrestado,
			int clientesVisitados, int clientesPendientesVisita, String ultimoClienteVisitado, int totalGastos) {
		super();
		this.dineroEnCaja = dineroEnCaja;
		this.debidoCobrar = debidoCobrar;
		this.totalRecogido = totalRecogido;
		this.totalPrestado = totalPrestado;
		this.clientesVisitados = clientesVisitados;
		this.clientesPendientesVisita = clientesPendientesVisita;
		this.ultimoClienteVisitado = ultimoClienteVisitado;
		this.totalGastos = totalGastos;
	}

	public DatosInicioAdmin() {
		super();
	}

	public int getDineroEnCaja() {
		return dineroEnCaja;
	}

	public void setDineroEnCaja(int dineroEnCaja) {
		this.dineroEnCaja = dineroEnCaja;
	}

	public int getDebidoCobrar() {
		return debidoCobrar;
	}

	public void setDebidoCobrar(int debidoCobrar) {
		this.debidoCobrar = debidoCobrar;
	}

	public int getTotalRecogido() {
		return totalRecogido;
	}

	public void setTotalRecogido(int totalRecogido) {
		this.totalRecogido = totalRecogido;
	}

	public int getTotalPrestado() {
		return totalPrestado;
	}

	public void setTotalPrestado(int totalPrestado) {
		this.totalPrestado = totalPrestado;
	}

	public int getClientesVisitados() {
		return clientesVisitados;
	}

	public void setClientesVisitados(int clientesVisitados) {
		this.clientesVisitados = clientesVisitados;
	}

	public int getClientesPendientesVisita() {
		return clientesPendientesVisita;
	}

	public void setClientesPendientesVisita(int clientesPendientesVisita) {
		this.clientesPendientesVisita = clientesPendientesVisita;
	}

	public String getUltimoClienteVisitado() {
		return ultimoClienteVisitado;
	}

	public void setUltimoClienteVisitado(String ultimoClienteVisitado) {
		this.ultimoClienteVisitado = ultimoClienteVisitado;
	}

	public int getTotalGastos() {
		return totalGastos;
	}

	public void setTotalGastos(int totalGastos) {
		this.totalGastos = totalGastos;
	}
}
