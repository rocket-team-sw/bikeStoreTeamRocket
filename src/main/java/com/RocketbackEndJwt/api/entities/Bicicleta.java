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

/**
 * Clase para mapear las bicicletas
 * @author juanfvasquez
 * 03-Feb-2019
 */
@Entity
@Table(name = "bicicletas")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Bicicleta implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int LONGITUD_MINIMA_REFS = 5;
	private static final int LONGITUD_MINIMA_DESCRIPCION = 10;

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
	
	@Column(name = "imagen")
	private String imagen;
	
	
	/**
	 * Constructores de una bicicleta
	 */
	
	public Bicicleta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bicicleta(Long id, String referencia, String nombre, String descripcion, Long precio, boolean usada,
			Date fecha_borrado, Long categoria, Long marca, Long modelo, String imagen) {
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
		this.imagen = imagen;
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
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getImagen() {
		return imagen;
	}
	/**
	 * Fin sección SETTERS y GETTERS
	 */

	/**
	 * Metodo para actualizar bicicleta
	 * @param nuevosDatos objeto de tipo Bicicleta con los nuevos datos
	 */
	public void actualizar(final Bicicleta nuevosDatos) {
		setReferencia(nuevosDatos.getReferencia());
		setNombre(nuevosDatos.getNombre());
		setDescripcion(nuevosDatos.getDescripcion());
		setPrecio(nuevosDatos.getPrecio());
		setUsada(nuevosDatos.isUsada());
		setFecha_borrado(nuevosDatos.getFecha_borrado());
		setCategoria(nuevosDatos.getCategoria());
		setModelo(nuevosDatos.getModelo());
		setMarca(nuevosDatos.getMarca());
		setImagen(nuevosDatos.getImagen());
	}
	
	/**
	 * Método para validar los datos de una bicicleta antes de crear o actualizar
	 * @throws Exception Lanzada si se encuentra que algún dato no es válido
	 */
	public void validar() throws Exception {
		if (getReferencia() == null) {
			throw new Exception("Debe ingresar una referencia");
		}
		
		if (getReferencia().length() < LONGITUD_MINIMA_REFS) {
			throw new Exception("Debe ingresar una referencia mas larga");
		}
		
		if (getNombre() == null) {
			throw new Exception("Debe ingresar un nombre");
		}
		
		if (getNombre().length() < LONGITUD_MINIMA_REFS) {
			throw new Exception("DEbe ingresar un nombre mas largo");
		}
		
		if (getDescripcion() == null) {
			throw new Exception("Debe ingresar una descripcion");
		}
		
		if (getDescripcion().length() < LONGITUD_MINIMA_DESCRIPCION) {
			throw new Exception("Debe ingresar una descripcion mas larga");
		}
		
		if (getPrecio() < 0) {
			throw new Exception("Debe ingresar un precio válido");
		}
	}
}
