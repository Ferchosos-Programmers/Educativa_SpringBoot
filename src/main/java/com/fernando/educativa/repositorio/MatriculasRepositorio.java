package com.fernando.educativa.repositorio;

import com.fernando.educativa.modelo.Matriculas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculasRepositorio  extends JpaRepository<Matriculas, Integer> {
}
