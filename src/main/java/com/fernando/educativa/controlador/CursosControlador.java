package com.fernando.educativa.controlador;

import com.fernando.educativa.modelo.Cursos;
import com.fernando.educativa.modelo.Estudiantes;
import com.fernando.educativa.servicio.CursosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursosControlador {

    @Autowired
    private CursosServicio cursosServicio;

    @GetMapping
    public String getAllCursos(Model model) {
        List<Cursos> cursos = cursosServicio.getAllCursos();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("cursos", new Cursos());
        return "crear_cursos";
    }

    @PostMapping
    public String createCurso(@ModelAttribute("curso") Cursos curso) {
        cursosServicio.createCursos(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Cursos> cursos = cursosServicio.getCursosById(id);
        if (cursos.isPresent()) {
            model.addAttribute("cursos", cursos.get());
            return "editar_cursos";
        } else {
            return "redirect:/cursos";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updateCurso(@PathVariable Integer id, @ModelAttribute("curso") Cursos cursoDetails) {
        cursosServicio.updateCursos(id, cursoDetails);
        return "redirect:/cursos";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCurso(@PathVariable Integer id) {
        cursosServicio.deleteCursos(id);
        return "redirect:/cursos";
    }
}