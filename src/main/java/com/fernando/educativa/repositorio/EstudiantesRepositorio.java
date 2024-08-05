package com.fernando.educativa.repositorio;

import com.fernando.educativa.modelo.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepositorio  extends JpaRepository<Estudiantes, Integer> {
}
