package com.fernando.educativa.servicio;

import com.fernando.educativa.modelo.Aulas;
import com.fernando.educativa.modelo.Cursos;


import java.util.List;
import java.util.Optional;

public interface AulasServicio {
    List<Aulas> getAllAulas();
    List<Cursos> getAllCursos();
    Optional<Aulas> getAulasById(Integer id);
    Aulas createAulas(Aulas cursos);
    Optional<Aulas> updateAulas(Integer id, Aulas aulasDetails);
    boolean deleteAulas(Integer id);
}
