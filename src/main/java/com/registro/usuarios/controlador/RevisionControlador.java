package com.registro.usuarios.controlador;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Estado;
import com.registro.usuarios.modelo.Pregunta;
import com.registro.usuarios.modelo.Revision;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.ArticuloServicio;
import com.registro.usuarios.servicio.EstadoServicio;
import com.registro.usuarios.servicio.PreguntaServicio;
import com.registro.usuarios.servicio.ProyectoServicio;
import com.registro.usuarios.servicio.RevisionServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RevisionControlador {
	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private RevisionServicio revisionServicio;
	
	@Autowired
	private ArticuloServicio articuloServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private EstadoServicio estadoServicio;
	
	@GetMapping("/proyectos/preguntas/revision/{pregunta_id}")
	public String listPreguntas(@PathVariable int pregunta_id ,Model modelo) {
		modelo.addAttribute("pregunta", preguntaServicio.selectPreguntabyID(pregunta_id));
		modelo.addAttribute("listRevisiones", revisionServicio.listRevisionbyIdPregunta(pregunta_id));
		return "revisiones"; //Retorna al archivo preguntas
	}
	

	@GetMapping("/proyectos/preguntas/revision/ver/{id}")
	public String viewProyecto(@PathVariable int id, Model modelo) {
		modelo.addAttribute("revision", revisionServicio.selectRevisionbyID(id));
		return "viewRevision";
	}
	
	@GetMapping("/proyectos/preguntas/revision/nuevo/{pregunta_id}")
	public String showFormPreguntaArticulos(@PathVariable int pregunta_id, Model modelo,  Authentication auth) {
		Pregunta pregunta = preguntaServicio.selectPreguntabyID(pregunta_id);
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		List<Articulo> listaArticulo = articuloServicio.listArticulobyIdUsuario(usuario.getId());
		
		modelo.addAttribute("pregunta", pregunta);
		modelo.addAttribute("listArticulos", listaArticulo);
		return "addAR"; //Retorna al archivo crear revisiones
	}
	
	@GetMapping("/proyectos/preguntas/revision/nuevo/{pregunta_id}/{articulo_id}")
	public String showFormRevision(@PathVariable int pregunta_id, @PathVariable int articulo_id, Model modelo) {
		Revision revision = new Revision();
		Pregunta pregunta = preguntaServicio.selectPreguntabyID(pregunta_id);
		revision.setPregunta(pregunta);
		Articulo articulo = articuloServicio.selectArticulobyID(articulo_id);
		revision.setArticulo(articulo);
		
		modelo.addAttribute("revision", revision);
		return "addRevision"; //Retorna al archivo crear revisiones
	}
	
	
	@PostMapping("/proyectos/preguntas/revision/")
	public String insertarRevision(@ModelAttribute("revision") Revision revision) {
		
		Long datetime = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(datetime);
	    String fechacreacion = timestamp.toString();
	    revision.setFechacreacion(fechacreacion);
		revisionServicio.insertRevision(revision);
		return "redirect:/proyectos/preguntas/revision/"+ revision.getPregunta().getId() ;
	}
	
	@GetMapping("/proyectos/preguntas/revision/editar/{id}")
	public String showFormUpdateRevision(@PathVariable int id, Model modelo) {
		modelo.addAttribute("revision", revisionServicio.selectRevisionbyID(id));
		return "editRevision";
	}
	
	@PostMapping("/proyectos/preguntas/revision/editar/{id}")
	public String updatePregunta(@PathVariable int id, @ModelAttribute("revision") Revision revision, Model modelo) {
		Revision revisionActual = revisionServicio.selectRevisionbyID(id);
		revisionActual.setId(id);
		revisionActual.setAporte(revision.getAporte());
		revisionActual.setNotas(revision.getNotas());		
		revisionActual.setRazonexclusion(revision.getRazonexclusion());
		revisionServicio.updateRevision(revisionActual);
		return "redirect:/proyectos/preguntas/revision/" + revisionActual.getPregunta().getId();
	}
	
	@GetMapping("/proyectos/preguntas/revision/delete/{id}")
	public String deleteRevision(@PathVariable int id) {
		Revision revision = revisionServicio.selectRevisionbyID(id);
		
		revisionServicio.deleteRevision(id);
		return "redirect:/proyectos/preguntas/revision/" + revision.getPregunta().getId();
	}
	
	

}
