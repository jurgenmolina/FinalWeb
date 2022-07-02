package com.registro.usuarios.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Pregunta;
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.repositorio.PreguntaRepositorio;
import com.registro.usuarios.repositorio.ProyectoRepositorio;

@Service
public class PreguntaServicioImplement implements PreguntaServicio{
	
	
	@Autowired
	private PreguntaRepositorio repositorio;

	@Override
	public List<Pregunta> listPreguntasbyIdProyecto(long id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		List<Pregunta> listaList = new ArrayList<Pregunta>();
		
		for (Pregunta pregunta : repositorio.findAll()) {
			if (pregunta.getProyecto().getId() == id) {
				listaList.add(pregunta);
			}
		}
		System.out.println(listaList);
		return listaList;
	}

	@Override
	public Pregunta insertPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return repositorio.save(pregunta);
	}

	@Override
	public Pregunta selectPreguntabyID(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Pregunta updatePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return repositorio.save(pregunta);
	}

	@Override
	public void deletePregunta(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
