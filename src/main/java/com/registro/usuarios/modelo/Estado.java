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
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "descripcion",nullable = false,length = 50)
	private String descripcion;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
	private Set<Proyecto> proyectos = new HashSet<>();


	public int getId() {
		return id;
	}

	

	public Set<Proyecto> getProyectos() {
		return proyectos;
	}



	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
		for (Proyecto proyecto : proyectos) {
			proyecto.setEstado(this);
		}
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Estado(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public Estado(String descripcion) {
		super();
		this.descripcion = descripcion;
	}


	public Estado() {
		super();
	}


	@Override
	public String toString() {
		return descripcion ;
	}
	
	

}
