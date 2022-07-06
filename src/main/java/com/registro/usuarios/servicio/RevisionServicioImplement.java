package com.registro.usuarios.servicio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Revision;
import com.registro.usuarios.repositorio.RevisionRepositorio;

@Service
public class RevisionServicioImplement implements RevisionServicio{
	
	
	@Autowired
	private RevisionRepositorio repositorio;

	@Override
	public List<Revision> listRevisionbyIdPregunta(int id) {
		List<Revision> listaList = new ArrayList<Revision>();
		for (Revision revision : repositorio.findAll()) {
			if (revision.getPregunta().getId() == id) {
				listaList.add(revision);
			}
		}
		return listaList;
	}

	@Override
	public Revision insertRevision(Revision revision) {
		// TODO Auto-generated method stub
		return repositorio.save(revision);
	}

	@Override
	public Revision selectRevisionbyID(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Revision updateRevision(Revision revision) {
		// TODO Auto-generated method stub
		return repositorio.save(revision);
	}

	@Override
	public void deleteRevision(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
