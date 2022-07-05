package com.registro.usuarios.modelo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "articulo")
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "titulo",length = 500)
	private String titulo;
	
	@Column(name = "anio", length = 4)
	private String anio;
	
	@Column(name = "autores", length = 500)
	private String autores;
	
	@Column(name = "citacion",length = 500)
	private String citacion;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@Column(name = "resumen",length = 500)
	private String resumen;
	
	@Column(name = "conclusiones",length = 500)
	private String conclusiones;
	
	@Column(name = "vacio",length = 500)
	private String vacio;
	
	@Column(name = "url",length = 500)
	private String url;
	
	@Column(name = "notas",length = 500)
	private String notas;
	
	@Column(name = "fecha_creacion")
	private String fecha_creacion;
	
	@Column(name = "revista",length = 200)
	private String revista;
	
	@Column(name = "categoria",length = 200)
	private String categoria;
	
	@Column(name = "palabras_clave",length = 200)
	private String palabras_clave;

	public Articulo() {
		super();
	}

	public Articulo(Long id, Usuario usuario, String titulo, String anio, String autores, String citacion, Pais pais,
			String resumen, String conclusiones, String vacio, String url, String notas, String fecha_creacion,
			String revista, String palabras_clave) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.anio = anio;
		this.autores = autores;
		this.citacion = citacion;
		this.pais = pais;
		this.resumen = resumen;
		this.conclusiones = conclusiones;
		this.vacio = vacio;
		this.url = url;
		this.notas = notas;
		this.fecha_creacion = fecha_creacion;
		this.revista = revista;
		this.palabras_clave = palabras_clave;
	}
	
	public Articulo(Usuario usuario, String titulo, String anio, String autores, String citacion, Pais pais,
			String resumen, String conclusiones, String vacio, String url, String notas, String fecha_creacion,
			String revista,String palabras_clave) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.anio = anio;
		this.autores = autores;
		this.citacion = citacion;
		this.pais = pais;
		this.resumen = resumen;
		this.conclusiones = conclusiones;
		this.vacio = vacio;
		this.url = url;
		this.notas = notas;
		this.fecha_creacion = fecha_creacion;
		this.revista = revista;
		this.palabras_clave = palabras_clave;
	}	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getCitacion() {
		return citacion;
	}

	public void setCitacion(String citacion) {
		this.citacion = citacion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getConclusiones() {
		return conclusiones;
	}

	public void setConclusiones(String conclusiones) {
		this.conclusiones = conclusiones;
	}

	public String getVacio() {
		return vacio;
	}

	public void setVacio(String vacio) {
		this.vacio = vacio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}


	public String getRevista() {
		return revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getPalabras_clave() {
		return palabras_clave;
	}

	public void setPalabras_clave(String palabras_clave) {
		this.palabras_clave = palabras_clave;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + "]";
	}

	
	
	
	
	
	
}
