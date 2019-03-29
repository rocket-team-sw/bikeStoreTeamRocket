package com.RocketbackEndJwt.api.entities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "promociones")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Promociones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion")
	@Size(min=20)
	@Size(max=250)
	private String descripcion;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name = "desde")
	@CreationTimestamp 
	private Date desde;
	
	@Column(name = "hasta")
	@CreationTimestamp 
	private Date hasta;
	
	@Column(name = "fecha_creacion")
	@CreationTimestamp 
	private Date fecha_creacion;
	
	@Column(name = "fecha_borrado")
	private Date fecha_borrado;

	public Promociones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promociones(Long id, String nombre, @Size(min = 20) @Size(max = 250) String descripcion, float precio,
			Date desde, Date hasta, Date fecha_creacion, Date fecha_borrado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.desde = desde;
		this.hasta = hasta;
		this.fecha_creacion = fecha_creacion;
		this.fecha_borrado = fecha_borrado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_borrado() {
		return fecha_borrado;
	}

	public void setFecha_borrado(Date fecha_borrado) {
		this.fecha_borrado = fecha_borrado;
	}
	
	
}
