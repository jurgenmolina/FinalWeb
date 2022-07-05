package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Articulo;
import com.registro.usuarios.modelo.Proyecto;


@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {

	
}
