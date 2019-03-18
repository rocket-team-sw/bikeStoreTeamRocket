package com.RocketbackEndJwt.api.reports;

public class NuevosClientes {
	private String id;
	private String nombreAsesor;
	private String nombreCliente;
	private int telefono;
	private float prestado;
	private String fecha;
	
	public NuevosClientes(){
		
	}
	
	public NuevosClientes(String id){
		this.id = id;
	}
	
	public NuevosClientes(NuevosClientes nuevos){
		this.id = nuevos.id;
		this.nombreAsesor = nuevos.nombreAsesor;
		this.nombreCliente = nuevos.nombreCliente;
		this.telefono = nuevos.telefono;
		this.prestado = nuevos.prestado;
		this.fecha = nuevos.fecha;
	}

	public NuevosClientes(String id, String nombreAsesor, String nombreCliente, int telefono, float prestado,
			String fecha) {
		this.id = id;
		this.nombreAsesor = nombreAsesor;
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
		this.prestado = prestado;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreAsesor() {
		return nombreAsesor;
	}

	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public float getPrestado() {
		return prestado;
	}

	public void setPrestado(float prestado) {
		this.prestado = prestado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}