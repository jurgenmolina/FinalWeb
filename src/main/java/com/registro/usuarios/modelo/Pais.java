package com.registro.usuarios.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "nombre",nullable = false,length = 100)
	private String nombre;
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private Set<Articulo> articulos = new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	


	public Set<Articulo> getArticulos() {
		return articulos;
	}


	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
		for (Articulo articulo : articulos) {
			articulo.setPais(this);
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Pais(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Pais() {
		super();
	}


	@Override
	public String toString() {
		return  nombre ;
	}
	
	
	
}
