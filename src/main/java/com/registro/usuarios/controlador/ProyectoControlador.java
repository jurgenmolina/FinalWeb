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
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.EstadoServicio;
import com.registro.usuarios.servicio.ProyectoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class ProyectoControlador {

	@Autowired
	private ProyectoServicio proyectoServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private EstadoServicio estadoServicio;
	
	
	@GetMapping("/proyectos")
	public String showListProyectos(Model modelo, Authentication auth) {
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		List<Proyecto> listaProyectos = proyectoServicio.listProyectosbyIdUsuario(usuario.getId());
		modelo.addAttribute("listProyectos", listaProyectos);
		return "proyectos";
	}
	
	@GetMapping("/proyectos/nuevo")
	public String showFormProyecto(Model modelo,  Authentication auth) {
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		Proyecto proyecto = new Proyecto();
		proyecto.setUsuario(usuario);
		
		List<Estado> estados = estadoServicio.listEstados();
		
		modelo.addAttribute("proyecto", proyecto);
		modelo.addAttribute("estados", estados);
		return "addProyecto"; //Retorna al archivo crear proyectos
	}
	
	@PostMapping("/proyectos")
	public String insertarProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoServicio.insertProyecto(proyecto);
		return "redirect:/proyectos";
	}
	
	

}
