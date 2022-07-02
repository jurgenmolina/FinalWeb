package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Pregunta;


public interface PreguntaServicio {
	
public List<Pregunta> listPreguntasbyIdProyecto(long id);
	
	public Pregunta insertPregunta(Pregunta pregunta);
	
	public Pregunta selectPreguntabyID(int id);
	
	public Pregunta updatePregunta(Pregunta pregunta);
	
	public void deletePregunta(int id);

}
