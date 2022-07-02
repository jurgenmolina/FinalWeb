package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "proyecto_id",nullable = false)
	private Proyecto proyecto;
	
	@Column(name = "pregunta",nullable = false, length = 255)
	private String pregunta;
	
	@Column(name = "cadena",nullable = false, length = 255)
	private String cadena;

	@Column(name = "notas",nullable = false, length = 255)
	private String notas;

	public Pregunta(int id, Proyecto proyecto, String pregunta, String cadena, String notas) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.pregunta = pregunta;
		this.cadena = cadena;
		this.notas = notas;
	}

	public Pregunta(Proyecto proyecto, String pregunta, String cadena, String notas) {
		super();
		this.proyecto = proyecto;
		this.pregunta = pregunta;
		this.cadena = cadena;
		this.notas = notas;
	}

	public Pregunta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	
	
}
