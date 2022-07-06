package com.registro.usuarios.controlador;

import java.io.IOException;
import java.sql.Timestamp;
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

import com.registro.usuarios.export.ExportArticulos;
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
	

	@GetMapping("/articulos/ver/{id}")
	public String viewProyecto(@PathVariable long id, Model modelo) {
		modelo.addAttribute("articulo", articuloServicio.selectArticulobyID(id));
		return "viewArticulo";
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
		Long datetime = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(datetime);
	    String fechacreacion = timestamp.toString();
	    articulo.setFecha_creacion(fechacreacion);
	    
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
	
	@GetMapping("/articulos/exportarExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response, Authentication auth) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		String username = auth.getName();
		Usuario usuario = usuarioServicio.selectUsuariobyEmail(username);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Articulos_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Articulo> articulos = articuloServicio.listArticulobyIdUsuario(usuario.getId()); 
		
		ExportArticulos exporter = new ExportArticulos(articulos);
		exporter.exportar(response);
	}
	
	

}
