package com.fernando.educativa.servicio.impl;


import com.fernando.educativa.modelo.Aulas;
import com.fernando.educativa.modelo.Cursos;
import com.fernando.educativa.repositorio.AulasRepositorio;
import com.fernando.educativa.repositorio.CursosRepositorio;
import com.fernando.educativa.servicio.AulasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulasServicioImpl implements AulasServicio {

    @Autowired
    private AulasRepositorio aulasRepositorio;

    @Autowired
    private CursosRepositorio cursosRepositorio;

    @Override
    public List<Aulas> getAllAulas() {
        return aulasRepositorio.findAll();
    }

    @Override
    public Optional<Aulas> getAulasById(Integer id) {
        return aulasRepositorio.findById(id);
    }

    @Override
    public Aulas createAulas(Aulas aulas) {
        return aulasRepositorio.save(aulas);
    }

    @Override
    public Optional<Aulas> updateAulas(Integer id, Aulas aulasDetails) {
        Optional<Aulas> aulas = aulasRepositorio.findById(id);
        if (aulas.isPresent()) {
            Aulas existingAulas = aulas.get();
            existingAulas.setNumero_aula(aulasDetails.getNumero_aula());
            existingAulas.setCapacidad(aulasDetails.getCapacidad());
            existingAulas.setCursos(aulasDetails.getCursos());
            return Optional.of(aulasRepositorio.save(existingAulas));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteAulas(Integer id) {
        Optional<Aulas> curso = aulasRepositorio.findById(id);
        if (curso.isPresent()) {
            aulasRepositorio.delete(curso.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Cursos> getAllCursos() {
        return cursosRepositorio.findAll();
    }
}
