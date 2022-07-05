package com.registro.usuarios.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.repositorio.ArticuloRepositorio;
import com.registro.usuarios.repositorio.ProyectoRepositorio;

@Service
public class ArticuloServicioImplement implements ArticuloServicio{
	
	
	@Autowired
	private ArticuloRepositorio repositorio;

	@Override
	public List<Articulo> listArticulobyIdUsuario(long id) {
		// TODO Auto-generated method stub
		List<Articulo> listaList = new ArrayList<Articulo>();
		for (Articulo articulo : repositorio.findAll()) {
			if (articulo.getUsuario().getId() == id) {
				listaList.add(articulo);
			}
		}
		
		return listaList;
	}

	@Override
	public Articulo insertArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		return repositorio.save(articulo);
	}

	@Override
	public Articulo selectArticulobyID(long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Articulo updateArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		return repositorio.save(articulo);
	}

	@Override
	public void deleteArticulo(long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
