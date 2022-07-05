package com.registro.usuarios.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Estado;
import com.registro.usuarios.modelo.Pais;
import com.registro.usuarios.modelo.Proyecto;
import com.registro.usuarios.repositorio.EstadoRepositorio;
import com.registro.usuarios.repositorio.PaisRepositorio;
import com.registro.usuarios.repositorio.ProyectoRepositorio;

@Service
public class PaisServicioImplement implements PaisServicio{
	
	
	@Autowired
	private PaisRepositorio pais;



	@Override
	public List<Pais> listaPais() {
		// TODO Auto-generated method stub
		return pais.findAll();
	}



}
