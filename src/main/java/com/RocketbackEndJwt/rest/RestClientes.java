package com.RocketbackEndJwt.rest;

public class RestClientes {
	
    private Long clientId;

    private String nombre;
	
    private String tipo_documento;   

    private String numeroDocumento;   
    
	private String punto_referencia;
	
	private String direccion;
	
	private String telefono;
	
	private String tipo_vivienda;
	
	private String tipo_comercio;
	
	private String ubicacion_geografica;
	
	private String datos_adicionales;

	private Long idGestor;

	public RestClientes(){
		
	}
	
	public RestClientes(Long clientId, String nombre, String tipo_documento, String numeroDocumento,
			String punto_referencia, String direccion, String telefono, String tipo_vivienda, String tipo_comercio,
			String ubicacion_geografica, String datos_adicionales, Long idGestor) {
		super();
		this.clientId = clientId;
		this.nombre = nombre;
		this.tipo_documento = tipo_documento;
		this.numeroDocumento = numeroDocumento;
		this.punto_referencia = punto_referencia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo_vivienda = tipo_vivienda;
		this.tipo_comercio = tipo_comercio;
		this.ubicacion_geografica = ubicacion_geografica;
		this.datos_adicionales = datos_adicionales;
		this.idGestor = idGestor;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPunto_referencia() {
		return punto_referencia;
	}

	public void setPunto_referencia(String punto_referencia) {
		this.punto_referencia = punto_referencia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo_vivienda() {
		return tipo_vivienda;
	}

	public void setTipo_vivienda(String tipo_vivienda) {
		this.tipo_vivienda = tipo_vivienda;
	}

	public String getTipo_comercio() {
		return tipo_comercio;
	}

	public void setTipo_comercio(String tipo_comercio) {
		this.tipo_comercio = tipo_comercio;
	}

	public String getUbicacion_geografica() {
		return ubicacion_geografica;
	}

	public void setUbicacion_geografica(String ubicacion_geografica) {
		this.ubicacion_geografica = ubicacion_geografica;
	}

	public String getDatos_adicionales() {
		return datos_adicionales;
	}

	public void setDatos_adicionales(String datos_adicionales) {
		this.datos_adicionales = datos_adicionales;
	}

	public Long getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Long idGestor) {
		this.idGestor = idGestor;
	}
}
