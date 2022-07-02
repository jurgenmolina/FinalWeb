package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Proyecto;


public interface ProyectoServicio {
	
public List<Proyecto> listProyectosbyIdUsuario(long id);
	
	public Proyecto insertProyecto(Proyecto proyecto);
	
	public Proyecto selectProyectobyID(long id);
	
	public Proyecto updateProyecto(Proyecto proyecto);
	
	public void deleteProyecto(long id);

}
