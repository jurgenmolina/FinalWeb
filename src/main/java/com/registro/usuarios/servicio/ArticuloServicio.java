package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Articulo;



public interface ArticuloServicio {
	
public List<Articulo> listArticulobyIdUsuario(long id);
	
	public Articulo insertArticulo(Articulo articulo);
	
	public Articulo selectArticulobyID(long id);
	
	public Articulo updateArticulo(Articulo articulo);
	
	public void deleteArticulo(long id);

}
