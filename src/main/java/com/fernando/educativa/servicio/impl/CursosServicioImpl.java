package com.fernando.educativa.servicio.impl;

import com.fernando.educativa.modelo.Cursos;
import com.fernando.educativa.repositorio.CursosRepositorio;
import com.fernando.educativa.servicio.CursosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosServicioImpl implements CursosServicio {

    @Autowired
    private CursosRepositorio cursosRepositorio;

    @Override
    public List<Cursos> getAllCursos() {
        return cursosRepositorio.findAll();
    }

    @Override
    public Optional<Cursos> getCursosById(Integer id) {
        return cursosRepositorio.findById(id);
    }

    @Override
    public Cursos createCursos(Cursos curso) {
        return cursosRepositorio.save(curso);
    }

    @Override
    public Optional<Cursos> updateCursos(Integer id, Cursos cursoDetails) {
        Optional<Cursos> curso = cursosRepositorio.findById(id);
        if (curso.isPresent()) {
            Cursos existingCurso = curso.get();
            existingCurso.setNombre(cursoDetails.getNombre());
            existingCurso.setDescripcion(cursoDetails.getDescripcion());
            existingCurso.setCreditos(cursoDetails.getCreditos());
            return Optional.of(cursosRepositorio.save(existingCurso));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteCursos(Integer id) {
        Optional<Cursos> curso = cursosRepositorio.findById(id);
        if (curso.isPresent()) {
            cursosRepositorio.delete(curso.get());
            return true;
        } else {
            return false;
        }
    }
}
