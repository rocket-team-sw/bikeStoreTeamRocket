package com.RocketbackEndJwt.api.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "bicicletas")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Bicicleta implements Serializable {

	
	public Bicicleta(Long id, String referencia, String nombre, String descripcion, Long precio, boolean usada,
			Date fecha_borrado, Long categoria, Long marca, Long modelo) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.usada = usada;
		this.fecha_borrado = fecha_borrado;
		this.categoria = categoria;
		this.marca = marca;
		this.modelo = modelo;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "referencia")
	private String referencia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long marca) {
		this.marca = marca;
	}

	public Long getModelo() {
		return modelo;
	}

	public void setModelo(Long modelo) {
		this.modelo = modelo;
	}

	public Date getFecha_borrado() {
		return fecha_borrado;
	}

	public void setFecha_borrado(Date fecha_borrado) {
		this.fecha_borrado = fecha_borrado;
	}

	@Column(name = "precio")
	private Long precio;
	
	@Column(name = "usada")
	private boolean usada;
	
	@Column(name = "fecha_borrado")
	private Date fecha_borrado;
	
	@Column(name = "categoria_id")
	private Long categoria;
	
	@Column(name = "marca_id")
	private Long marca;
	
	@Column(name = "modelo_id")
	private Long modelo;
	

	public Bicicleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bicicleta(Long id, String referencia, String nombre, String descripcion, Long precio, boolean usada) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.usada = usada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public boolean isUsada() {
		return usada;
	}

	public void setUsada(boolean usada) {
		this.usada = usada;
	}	
	
}
