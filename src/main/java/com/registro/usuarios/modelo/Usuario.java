package com.registro.usuarios.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre",nullable = false,length = 50)
	private String nombre;

	@Column(name = "email",nullable = false,length = 100)
	private String email;
	
	@Column(name = "clave",nullable = false,length = 300)
	private String clave;
	
	@Column(name = "pais",nullable = false,length = 50)
	private String pais;
	
	@Column(name = "entidad",nullable = false,length = 200)
	private String entidad;
	
	@Column(name = "titulo",nullable = false,length = 1)
	private String estado;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public Usuario(Long id, String nombre, String email, String clave, String pais, String entidad, String estado,
			Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.pais = pais;
		this.entidad = entidad;
		this.estado = estado;
		this.roles = roles;
	}

	public Usuario(String nombre, String email, String clave, String pais, String entidad, String estado,
			Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.pais = pais;
		this.entidad = entidad;
		this.estado = estado;
		this.roles = roles;
	}

	public Usuario() {
		
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	
	
	

}
