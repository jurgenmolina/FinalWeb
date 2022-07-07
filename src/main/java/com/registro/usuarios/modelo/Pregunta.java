package com.registro.usuarios.modelo;

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

@Entity
@Table(name = "preguntas")
public class Pregunta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "proyecto_id",nullable = false)
	private Proyecto proyecto;
	
	@Column(name = "cuestion",nullable = false, length = 255)
	private String cuestion;
	
	@Column(name = "cadena",nullable = false, length = 255)
	private String cadena;

	@Column(name = "notas",nullable = false, length = 255)
	private String notas;
	
	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
	private Set<Revision> revisions = new HashSet<>();

	public Pregunta(int id, Proyecto proyecto, String cuestion, String cadena, String notas) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.cuestion = cuestion;
		this.cadena = cadena;
		this.notas = notas;
	}

	public Pregunta(Proyecto proyecto, String cuestion, String cadena, String notas) {
		super();
		this.proyecto = proyecto;
		this.cuestion = cuestion;
		this.cadena = cadena;
		this.notas = notas;
	}
	
	

	public Set<Revision> getRevisions() {
		return revisions;
	}

	public void setRevisions(Set<Revision> revisions) {
		this.revisions = revisions;
		for (Revision revision : revisions) {
			revision.setPregunta(this);
		}
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

	public String getCuestion() {
		return cuestion;
	}

	public void setCuestion(String pregunta) {
		this.cuestion = pregunta;
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

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", proyecto=" + proyecto + ", cuestion=" + cuestion + ", cadena=" + cadena
				+ ", notas=" + notas + "]";
	}
	
	
	
}
