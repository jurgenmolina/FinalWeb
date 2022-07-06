package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Revision;



public interface RevisionServicio {

	public List<Revision> listRevisionbyIdPregunta(int id);

	public Revision insertRevision(Revision articulo);

	public Revision selectRevisionbyID(int id);

	public Revision updateRevision(Revision articulo);

	public void deleteRevision(int id);

}
