package com.registro.usuarios.controlador.dto;

public class UsuarioRegistroDTO {

	private Long id;
	private String nombre;
	private String email;
	private String clave;
	private String pais;
	private String entidad;
	private String estado;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UsuarioRegistroDTO(Long id, String nombre, String email, String clave, String pais, String entidad,
			String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.pais = pais;
		this.entidad = entidad;
		this.estado = estado;
	}

	public UsuarioRegistroDTO(String nombre, String email, String clave, String pais, String entidad, String estado) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.pais = pais;
		this.entidad = entidad;
		this.estado = estado;
	}

	public UsuarioRegistroDTO() {

	}

}
