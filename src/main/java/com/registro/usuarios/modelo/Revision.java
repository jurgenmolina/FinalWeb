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
@Table(name = "revision")
public class Revision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "pregunta_id")
	private Pregunta pregunta;
	
	@ManyToOne
	@JoinColumn(name = "articulo_id")
	private Articulo articulo;
	
	@Column(name = "aporte",length = 500)
	private String aporte;
	
	@Column(name = "fechacreacion",length = 50)
	private String fechacreacion;
	
	@Column(name = "notas",length = 500)
	private String notas;
	
	@Column(name = "estado",length = 1)
	private String estado;
	
	@Column(name = "razonexclusion",length = 500)
	private String razonexclusion;
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public String getAporte() {
		return aporte;
	}

	public void setAporte(String aporte) {
		this.aporte = aporte;
	}

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getRazonexclusion() {
		return razonexclusion;
	}

	public void setRazonexclusion(String razonexclusion) {
		this.razonexclusion = razonexclusion;
	}

	public Revision(int id, Pregunta pregunta, Articulo articulo, String aporte, String fechacreacion, String notas,
			String estado, String razonexclusion) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.articulo = articulo;
		this.aporte = aporte;
		this.fechacreacion = fechacreacion;
		this.notas = notas;
		this.estado = estado;
		this.razonexclusion = razonexclusion;
	}

	public Revision(Pregunta pregunta, Articulo articulo, String aporte, String fechacreacion, String notas,
			String estado, String razonexclusion) {
		super();
		this.pregunta = pregunta;
		this.articulo = articulo;
		this.aporte = aporte;
		this.fechacreacion = fechacreacion;
		this.notas = notas;
		this.estado = estado;
		this.razonexclusion = razonexclusion;
	}

	public Revision() {
		super();
	}

	@Override
	public String toString() {
		return "Revision [id=" + id + ", pregunta=" + pregunta + ", articulo=" + articulo + ", aporte=" + aporte
				+ ", fechacreacion=" + fechacreacion + ", notas=" + notas + ", razonexclusion=" + razonexclusion + "]";
	}

	
	
}
