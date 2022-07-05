package com.registro.usuarios.controlador;

import java.sql.Timestamp;
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

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Estado;
import com.registro.usuarios.modelo.Pais;
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.ArticuloServicio;
import com.registro.usuarios.servicio.EstadoServicio;
import com.registro.usuarios.servicio.PaisServicio;
import com.registro.usuarios.servicio.ProyectoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class ArticuloControlador {

	@Autowired
	private ArticuloServicio articuloServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private PaisServicio paisServicio;
	
	
	@GetMapping("/articulos")
	public String showListArticulos(Model modelo, Authentication auth) {
		
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		List<Articulo> listaArticulo = articuloServicio.listArticulobyIdUsuario(usuario.getId());
		modelo.addAttribute("listArticulos", listaArticulo);
		return "articulos";
	}
	
	@GetMapping("/articulos/nuevo")
	public String showFormArticulo(Model modelo,  Authentication auth) {
		String username = auth.getName();
		System.out.println(username);
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		System.out.println(usuario);
		Articulo articulo = new Articulo();
		articulo.setUsuario(usuario);
		
		List<Pais> pais = paisServicio.listaPais();
		System.out.println("coito" + articulo.getUsuario().getId());
		modelo.addAttribute("articulo", articulo);
		modelo.addAttribute("paises", pais);
		return "addArticulo"; //Retorna al archivo crear articulos
	}
	
	@PostMapping("/articulos")
	public String insertarArticulo(@ModelAttribute("articulo") Articulo articulo) {
		articuloServicio.insertArticulo(articulo);
		return "redirect:/articulos";
	}
	
	@GetMapping("/articulos/editar/{id}")
	public String showFormUpdateArticulo(@PathVariable long id, Model modelo) {
		modelo.addAttribute("articulo", articuloServicio.selectArticulobyID(id));		
		List<Pais> paises = paisServicio.listaPais();
		modelo.addAttribute("paises", paises);
		return "editArticulo";
	}
	
	@PostMapping("/articulos/{id}")
	public String updateArticulo(@PathVariable long id, @ModelAttribute("articulo") Articulo articulo,
			Model modelo) {
		Long datetime = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(datetime);
	    String fechacreacion = timestamp.toString();
	    
		Articulo articuloActual = articuloServicio.selectArticulobyID(id);
		articuloActual.setId(id);
		articuloActual.setTitulo(articulo.getTitulo());
		articuloActual.setAnio(articulo.getAnio());
		articuloActual.setAutores(articulo.getAutores());
		articuloActual.setCitacion(articulo.getCitacion());
		articuloActual.setPais(articulo.getPais());
		articuloActual.setResumen(articulo.getResumen());
		articuloActual.setConclusiones(articulo.getConclusiones());
		articuloActual.setVacio(articulo.getVacio());
		articuloActual.setUrl(articulo.getUrl());
		articuloActual.setNotas(articulo.getNotas());
		articuloActual.setFecha_creacion(fechacreacion);
		articuloActual.setRevista(articulo.getRevista());
		articuloActual.setCategoria(articulo.getCategoria());
		articuloActual.setPalabras_clave(articulo.getPalabras_clave());
		
		articuloServicio.updateArticulo(articuloActual);
		return "redirect:/articulos";
	}
	
	@GetMapping("/articulos/{id}")
	public String deleteArticulo(@PathVariable long id) {
		articuloServicio.deleteArticulo(id);
		return "redirect:/articulos";
	}
	
	

}
