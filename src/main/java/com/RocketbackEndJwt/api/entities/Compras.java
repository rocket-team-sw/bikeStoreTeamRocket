package com.RocketbackEndJwt.api.entities;

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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "compras")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	

	@Column(name = "clienteid")
	private Cliente clienteid;
	
	@Column(name = "fecha_creacion")
	@CreationTimestamp 
	private Date fecha_creacion;
	
	@Column(name = "fecha_borrado")
	private Date fecha_borrado;

	public Compras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compras(Long id, Cliente clienteid, Date fecha_creacion, Date fecha_borrado) {
		super();
		this.id = id;
		this.clienteid = clienteid;
		this.fecha_creacion = fecha_creacion;
		this.fecha_borrado = fecha_borrado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClienteid() {
		return clienteid;
	}

	public void setClienteid(Cliente clienteid) {
		this.clienteid = clienteid;
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
