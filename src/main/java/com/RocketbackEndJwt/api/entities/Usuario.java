package com.RocketbackEndJwt.api.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
@TableGenerator(name = "tab", initialValue = 211, allocationSize = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long userId;

	@Column(name = "email")
	@NotBlank(message = "Email Required")
	@Email(message = "Email invalid")
	private String email;

	@Column(name = "nombre")
	private String userName;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "password")
	@NotBlank(message = "Password required")
	@Size(min = 6)
	private String password;

	@Column(name = "user_role")
	private String role;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "fecha_creacion")
	@CreationTimestamp
	private Date fecha_creacion;

	@Column(name = "fecha_borrado")
	private Date fecha_borrado;


	public Usuario() {

	}


	public Usuario(Long userId, @NotBlank(message = "Email Required") @Email(message = "Email invalid") String email,
			String userName, String apellidos, String direccion, String telefono, String usuario,
			@NotBlank(message = "Password required") @Size(min = 6) String password, String role, boolean enabled,
			Date fecha_creacion, Date fecha_borrado) {
		super();
		this.userId = userId;
		this.email = email;
		this.userName = userName;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.fecha_creacion = fecha_creacion;
		this.fecha_borrado = fecha_borrado;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
