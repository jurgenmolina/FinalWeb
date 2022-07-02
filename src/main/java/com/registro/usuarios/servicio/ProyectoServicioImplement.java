package com.registro.usuarios.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.repositorio.ProyectoRepositorio;

@Service
public class ProyectoServicioImplement implements ProyectoServicio{
	
	
	@Autowired
	private ProyectoRepositorio repositorio;

	@Override
	public List<Proyecto> listProyectosbyIdUsuario(long id) {
		// TODO Auto-generated method stub
		List<Proyecto> listaList = new ArrayList<Proyecto>();
		
		for (Proyecto proyecto : repositorio.findAll()) {
			if (proyecto.getUsuario().getId() == id) {
				listaList.add(proyecto);
			}
		}
		
		return listaList;
	}

	@Override
	public Proyecto insertProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return repositorio.save(proyecto);
	}

	@Override
	public Proyecto selectProyectobyID(long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Proyecto updateProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return repositorio.save(proyecto);
	}

	@Override
	public void deleteProyecto(long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
