package com.fernando.educativa.servicio.impl;

import com.fernando.educativa.modelo.Estudiantes;
import com.fernando.educativa.repositorio.EstudiantesRepositorio;
import com.fernando.educativa.servicio.EstudiantesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesServiceImpl implements EstudiantesServicio {

    @Autowired
    private EstudiantesRepositorio estudiantesRepositorio;

    @Override
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesRepositorio.findAll();
    }

    @Override
    public Optional<Estudiantes> getEstudiantesById(Integer id) {
        return estudiantesRepositorio.findById(id);
    }

    @Override
    public Estudiantes createEstudiantes(Estudiantes estudiantes) {
        return estudiantesRepositorio.save(estudiantes);
    }

    @Override
    public Optional<Estudiantes> updateEstudiantes(Integer id, Estudiantes estudiantesDetails) {
        Optional<Estudiantes> estudiantes = estudiantesRepositorio.findById(id);
        if (estudiantes.isPresent()) {
            Estudiantes existingEstudiantes = estudiantes.get();
            existingEstudiantes.setNombre(estudiantesDetails.getNombre());
            existingEstudiantes.setApellido(estudiantesDetails.getApellido());
            existingEstudiantes.setFecha_nacimiento(estudiantesDetails.getFecha_nacimiento());
            existingEstudiantes.setEmail(estudiantesDetails.getEmail());
            return Optional.of(estudiantesRepositorio.save(existingEstudiantes));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteEstudiantes(Integer id) {
        Optional<Estudiantes> estudiantes = estudiantesRepositorio.findById(id);
        if (estudiantes.isPresent()) {
            estudiantesRepositorio.delete(estudiantes.get());
            return true;
        } else {
            return false;
        }
    }
}
