package com.registro.usuarios.modelo;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.websocket.Decoder.Text;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@Column(name = "titulo",nullable = false,length = 100)
	private String titulo;
	
	@Column(name = "objetivo",nullable = false, length = 100)
	private String objetivo;
	
	@Column(name = "notas",nullable = false, length = 100)
	private String notas;
	
	@Column(name = "fechaInicio",nullable = false)
	private Date fechaInicio;
	
	@Column(name = "fechaFin",nullable = false)
	private Date fechaFin;
	
	@Column(name = "fechacreacion")
	private String fechacreacion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;
	
	@OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
	private Set<Pregunta> preguntas = new HashSet<>();

	

	public Proyecto(Usuario usuario, String titulo, String objetivo, String notas, Date fechaInicio, 
			Date fechaFin, String fechacreacion, Estado estado) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.notas = notas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}



	public Proyecto(Long id, Usuario usuario, String titulo, String objetivo, String notas,
			Date fechaInicio, Date fechaFin, String fechacreacion, Estado estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.notas = notas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	
	

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}



	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
		for (Pregunta pregunta : preguntas) {
			pregunta.setProyecto(this);
		}
	}



	public String getFechacreacion() {
		return fechacreacion;
	}



	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getObjetivo() {
		return objetivo;
	}



	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}



	public String getNotas() {
		return notas;
	}



	public void setNotas(String notas) {
		this.notas = notas;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public Proyecto() {
		super();
	}



	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + ", objetivo=" + objetivo
				+ ", notas=" + notas + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado
				+ "]";
	}
	
	
	
	
	
}
