package com.fernando.educativa.controlador;

import com.fernando.educativa.modelo.Aulas;
import com.fernando.educativa.modelo.Cursos;
import com.fernando.educativa.servicio.AulasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aulas")
public class AulasControlador {

    @Autowired
    private AulasServicio aulasServicio;

    @GetMapping
    public String getAllAulas(Model model) {
        List<Aulas> aulas = aulasServicio.getAllAulas();
        model.addAttribute("aulas", aulas);
        return "aulas";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("aulas", new Aulas());
        model.addAttribute("cursos", aulasServicio.getAllCursos()); // Suponiendo que tienes un método para obtener todos los cursos
        return "crear_aulas";
    }

    @PostMapping
    public String createAula(@ModelAttribute("aulas") Aulas aula) {
        aulasServicio.createAulas(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Aulas> aula = aulasServicio.getAulasById(id);
        if (aula.isPresent()) {
            model.addAttribute("aulas", aula.get());
            model.addAttribute("cursos", aulasServicio.getAllCursos()); // Suponiendo que tienes un método para obtener todos los cursos
            return "editar_aulas";
        } else {
            return "redirect:/aulas";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updateAula(@PathVariable Integer id, @ModelAttribute("aulas") Aulas aulaDetails) {
        aulasServicio.updateAulas(id, aulaDetails);
        return "redirect:/aulas";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteAula(@PathVariable Integer id) {
        aulasServicio.deleteAulas(id);
        return "redirect:/aulas";
    }

}
