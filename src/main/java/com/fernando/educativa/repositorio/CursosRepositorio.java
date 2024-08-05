package com.fernando.educativa.repositorio;

import com.fernando.educativa.modelo.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepositorio extends JpaRepository<Cursos, Integer> {
}
