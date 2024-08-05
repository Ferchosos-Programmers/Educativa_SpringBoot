package com.fernando.educativa.servicio;
import com.fernando.educativa.modelo.Estudiantes;
import java.util.List;
import java.util.Optional;

public interface EstudiantesServicio {
    List<Estudiantes> getAllEstudiantes();
    Optional<Estudiantes> getEstudiantesById(Integer id);
    Estudiantes createEstudiantes(Estudiantes estudiantes);
    Optional<Estudiantes> updateEstudiantes(Integer id, Estudiantes estudiantesDetails);
    boolean deleteEstudiantes(Integer id);
}
