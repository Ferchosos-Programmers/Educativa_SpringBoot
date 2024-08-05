package com.fernando.educativa.controlador;

import com.fernando.educativa.modelo.Estudiantes;
import com.fernando.educativa.servicio.EstudiantesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesControlador {

    @Autowired
    private EstudiantesServicio estudiantesServicio;

    @GetMapping
    public String getAllEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudiantesServicio.getAllEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("estudiantes", new Estudiantes());
        return "crear_estudiantes";
    }

    @PostMapping
    public String createEstudiantes(@ModelAttribute("estudiantes") Estudiantes estudiantes) {
        estudiantesServicio.createEstudiantes(estudiantes);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Estudiantes> estudiantes = estudiantesServicio.getEstudiantesById(id);
        if (estudiantes.isPresent()) {
            model.addAttribute("estudiantes", estudiantes.get());
            return "editar_estudiantes";
        } else {
            return "redirect:/estudiantes";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updateEstudiantes(@PathVariable Integer id, @ModelAttribute("estudiantes") Estudiantes estudiantesDetails) {
        estudiantesServicio.updateEstudiantes(id, estudiantesDetails);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEstudiantes(@PathVariable Integer id) {
        estudiantesServicio.deleteEstudiantes(id);
        return "redirect:/estudiantes";
    }
}
