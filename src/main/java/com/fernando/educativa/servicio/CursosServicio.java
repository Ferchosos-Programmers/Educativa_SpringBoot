package com.fernando.educativa.servicio;

import com.fernando.educativa.modelo.Cursos;


import java.util.List;
import java.util.Optional;

public interface CursosServicio {
    List<Cursos> getAllCursos();
    Optional<Cursos> getCursosById(Integer id);
    Cursos createCursos(Cursos cursos);
    Optional<Cursos> updateCursos(Integer id, Cursos cursosDetails);
    boolean deleteCursos(Integer id);
}
