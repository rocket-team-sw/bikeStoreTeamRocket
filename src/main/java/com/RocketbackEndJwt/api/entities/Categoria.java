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

import org.hibernate.annotations.CreationTimestamp;

/**
 * Clase para mapear las categorías
 * @author juanfvasquez
 * 03.Feb.2019
 */
@Entity
@Table(name = "categorias")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Categoria {
	private static final long serialVersionUID = 1L;
	private static final int LONGITUD_MINIMA_NOMBRE = 5;
	private static final int LONGITUD_MINIMA_DESCRIPCION = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_creacion")
	@CreationTimestamp
	private Date fecha_creacion;
	
	@Column(name = "fecha_borrado")
	private Date fecha_borrado;

	/**
	 * Constructores para categorías
	 */
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long id, String nombre, String descripcion, Date fecha_creacion, Date fecha_borrado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_borrado = fecha_borrado;
	}

	/**
	 * Sección de SETTERS y GETTERS
	 */
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
	/**
	 * Fin Sección de SETTERS y GETTERS
	 */
	
	/**
	 * Método para validar los datos de una categoría antes de crear o actualizar
	 * @throws Exception lanzada si se encuentra un dato no válido
	 */
	public void validate() throws Exception {
		
		if (getNombre() == null) {
			throw new Exception("Debe ingresar un nombre");
		}
		
		if (getNombre().length() < LONGITUD_MINIMA_NOMBRE) {
			throw new Exception("DEbe ingresar un nombre mas largo");
		}
		
		if (getDescripcion() == null) {
			throw new Exception("Debe ingresar una descripcion");
		}
		
		if (getDescripcion().length() < LONGITUD_MINIMA_DESCRIPCION) {
			throw new Exception("Debe ingresar una descripcion mas larga");
		}
	}
	
	/**
	 * Método para actualizar los datos de la categoría
	 * @param nuevosDatos objeto tipo Categoria con los nuevos datos
	 */
	public void actualizar(final Categoria nuevosDatos) {
		setDescripcion(nuevosDatos.getDescripcion());
		setFecha_borrado(nuevosDatos.getFecha_borrado());
		setNombre(nuevosDatos.getNombre());
	}
}
