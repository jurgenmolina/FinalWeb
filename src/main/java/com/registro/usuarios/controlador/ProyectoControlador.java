package com.registro.usuarios.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.export.ExportProyectos;
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
	
	@GetMapping("/proyectos/editar/{id}")
	public String showFormUpdateProyecto(@PathVariable long id, Model modelo) {
		modelo.addAttribute("proyecto", proyectoServicio.selectProyectobyID(id));
		List<Estado> estados = estadoServicio.listEstados();
		modelo.addAttribute("estados", estados);
		return "editProyecto";
	}
	
	@PostMapping("/proyectos/{id}")
	public String updateProyecto(@PathVariable long id, @ModelAttribute("proyecto") Proyecto proyecto,
			Model modelo) {
		Proyecto proyectoActual = proyectoServicio.selectProyectobyID(id);
		proyectoActual.setId(id);
		proyectoActual.setTitulo(proyecto.getTitulo());
		proyectoActual.setFechaInicio(proyecto.getFechaInicio());
		proyectoActual.setFechaFin(proyecto.getFechaFin());
		proyectoActual.setNotas(proyecto.getNotas());
		proyectoActual.setObjetivo(proyecto.getObjetivo());
		proyectoActual.setEstado(proyecto.getEstado());
		

		proyectoServicio.updateProyecto(proyectoActual);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/proyectos/{id}")
	public String deleteProyecto(@PathVariable long id) {
		proyectoServicio.deleteProyecto(id);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/proyectos/exportarExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response, Authentication auth) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Proyecto> proyectos = proyectoServicio.listProyectosbyIdUsuario(usuario.getId());
		
		ExportProyectos exporter = new ExportProyectos(proyectos);
		exporter.exportar(response);
	}
	
	

}
