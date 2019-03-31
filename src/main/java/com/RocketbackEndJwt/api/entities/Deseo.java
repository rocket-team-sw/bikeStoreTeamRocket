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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ventas")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Deseo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
<<<<<<< HEAD:src/main/java/com/RocketbackEndJwt/api/entities/Deseos.java

	@Column(name = "clienteid")
	private Cliente clienteid;
	

	@Column(name = "bicicletasid")
	private Bicicleta bicicletasid;
=======
	@Column(name = "cliente_id")
	private Long clienteId;
	
	@Column(name = "bicicleta_id")
	private Long bicicletaId;
>>>>>>> master:src/main/java/com/RocketbackEndJwt/api/entities/Deseo.java
	
	@Column(name = "fecha_creacion")
	@CreationTimestamp 
	private Date fecha_creacion;
	
	@Column(name = "fecha_borrado")
	private Date fecha_borrado;

	public Deseo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deseo(Long id, Long clienteId, Long bicicletaId, Date fecha_creacion, Date fecha_borrado) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.bicicletaId = bicicletaId;
		this.fecha_creacion = fecha_creacion;
		this.fecha_borrado = fecha_borrado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getBicicletaId() {
		return bicicletaId;
	}

	public void setBicicletaId(Long bicicletaId) {
		this.bicicletaId = bicicletaId;
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
