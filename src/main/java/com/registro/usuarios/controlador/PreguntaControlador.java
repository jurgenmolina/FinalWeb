package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.registro.usuarios.modelo.Pregunta;
import com.registro.usuarios.servicio.PreguntaServicio;
import com.registro.usuarios.servicio.ProyectoServicio;

@Controller
public class PreguntaControlador {
	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private ProyectoServicio proyectoServicio;
	
	
	@GetMapping("/proyectos/preguntas/{proyecto_id}")
	public String listPreguntas(@PathVariable long proyecto_id,Model modelo) {
		
		modelo.addAttribute("listPreguntas", preguntaServicio.listPreguntasbyIdProyecto(proyecto_id));
		modelo.addAttribute("proyecto", proyectoServicio.selectProyectobyID(proyecto_id));
		return "preguntas"; //Retorna al archivo preguntas
	}
	
	@GetMapping("/proyectos/preguntas/ver/{id}")
	public String viewProyecto(@PathVariable int id, Model modelo) {
		modelo.addAttribute("pregunta", preguntaServicio.selectPreguntabyID(id));
		return "viewPregunta";
	}
	
	
	@GetMapping("/proyectos/preguntas/nuevo/{proyecto_id}")
	public String showFormPregunta(@PathVariable long proyecto_id, Model modelo) {
		Pregunta pregunta = new Pregunta();
		modelo.addAttribute("pregunta", pregunta);
		modelo.addAttribute("proyecto_id", proyecto_id);
		return "addPregunta"; //Retorna al archivo crear preguntas
	}
	
	@PostMapping("/proyectos/preguntas/")
	public String insertarPregunta(@ModelAttribute("pregunta") Pregunta pregunta) {
		preguntaServicio.insertPregunta(pregunta);
		return "redirect:/proyectos/preguntas/"+ pregunta.getProyecto().getId() ;
	}
	@GetMapping("/proyectos/preguntas/editar/{id}")
	public String showFormUpdatePregunta(@PathVariable int id, Model modelo) {
		modelo.addAttribute("pregunta", preguntaServicio.selectPreguntabyID(id));
		return "editPregunta";
	}
	
	@PostMapping("/proyectos/preguntas/editar/{id}")
	public String updatePregunta(@PathVariable int id, @ModelAttribute("pregunta") Pregunta pregunta,
			Model modelo) {
		Pregunta preguntaActual = preguntaServicio.selectPreguntabyID(id);
		preguntaActual.setId(id);
		preguntaActual.setCadena(pregunta.getCadena());
		preguntaActual.setNotas(pregunta.getNotas());		
		preguntaActual.setCuestion(pregunta.getCuestion());
		preguntaServicio.updatePregunta(preguntaActual);
		return "redirect:/proyectos/preguntas/" + pregunta.getProyecto().getId();
	}
	
	@GetMapping("/proyectos/pregunta/delete{id}")
	public String deletePregunta(@PathVariable int id) {
		preguntaServicio.deletePregunta(id);
		return "redirect:/proyectos";
	}
	
	

}
