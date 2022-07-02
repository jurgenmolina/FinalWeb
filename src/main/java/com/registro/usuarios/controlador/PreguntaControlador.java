package com.registro.usuarios.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.modelo.Estado;
import com.registro.usuarios.modelo.Pregunta;
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.EstadoServicio;
import com.registro.usuarios.servicio.PreguntaServicio;
import com.registro.usuarios.servicio.ProyectoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class PreguntaControlador {
	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private ProyectoServicio proyectoServicio;
	
	
	@GetMapping("/proyectos/preguntas/{id}")
	public String listPreguntas(@PathVariable long id, Model modelo) {
		modelo.addAttribute("listPreguntas", preguntaServicio.listPreguntasbyIdProyecto(id));
		modelo.addAttribute("proyecto", proyectoServicio.selectProyectobyID(id));
		return "preguntas"; //Retorna al archivo preguntas
	}
	
	
	@GetMapping("/proyectos/preguntas/nuevo/{id}")
	public String showFormPregunta(@PathVariable int id, Model modelo) {
		Pregunta pregunta = new Pregunta();
		Proyecto proyecto = proyectoServicio.selectProyectobyID(id);
		pregunta.setProyecto(proyecto);
		modelo.addAttribute("pregunta", pregunta);
		return "addPregunta"; //Retorna al archivo crear preguntas
	}
	
	@PostMapping("/proyectos/preguntas/{id}")
	public String insertarPregunta(@ModelAttribute("pregunta") Pregunta pregunta, @PathVariable long id) {
		System.out.println(pregunta);
		preguntaServicio.insertPregunta(pregunta);
		return "redirect:/proyectos/preguntas/" + id;
	}
	
//	@GetMapping("/proyectos/editar/{id}")
//	public String showFormUpdateProyecto(@PathVariable long id, Model modelo) {
//		modelo.addAttribute("proyecto", proyectoServicio.selectProyectobyID(id));
//		List<Estado> estados = estadoServicio.listEstados();
//		modelo.addAttribute("estados", estados);
//		return "editProyecto";
//	}
//	
//	@PostMapping("/proyectos/{id}")
//	public String updateProyecto(@PathVariable long id, @ModelAttribute("proyecto") Proyecto proyecto,
//			Model modelo) {
//		Proyecto proyectoActual = proyectoServicio.selectProyectobyID(id);
//		proyectoActual.setId(id);
//		proyectoActual.setTitulo(proyecto.getTitulo());
//		proyectoActual.setFechaInicio(proyecto.getFechaInicio());
//		proyectoActual.setFechaFin(proyecto.getFechaFin());
//		proyectoActual.setNotas(proyecto.getNotas());
//		proyectoActual.setObjetivo(proyecto.getObjetivo());
//		proyectoActual.setEstado(proyecto.getEstado());
//		
//
//		proyectoServicio.updateProyecto(proyectoActual);
//		return "redirect:/proyectos";
//	}
//	
//	@GetMapping("/proyectos/{id}")
//	public String deleteProyecto(@PathVariable long id) {
//		proyectoServicio.deleteProyecto(id);
//		return "redirect:/proyectos";
//	}
	
	

}
