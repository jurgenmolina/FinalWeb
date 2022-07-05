package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Integer> {

}
