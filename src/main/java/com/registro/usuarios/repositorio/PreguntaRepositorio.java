package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Pregunta;
import com.registro.usuarios.modelo.Proyecto;


@Repository
public interface PreguntaRepositorio extends JpaRepository<Pregunta, Integer> {

	
}
