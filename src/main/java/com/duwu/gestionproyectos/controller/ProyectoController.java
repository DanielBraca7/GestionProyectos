package com.duwu.gestionproyectos.controller;

import com.duwu.gestionproyectos.model.Proyecto;
import com.duwu.gestionproyectos.service.ProyectoService;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
    private final ProyectoService proyectoService;
    
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyectos/proyectos-form"; 
    }

    
    @GetMapping
    public String listarProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/proyectos";
    }

    @GetMapping("/editar/{id}")
    public String editarProyecto(@PathVariable("id") Long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        model.addAttribute("proyecto", proyecto);
        return "proyectos/proyectos-form"; 
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProyecto(@PathVariable("id") Long id, @ModelAttribute Proyecto proyectoActualizado) {
        Proyecto proyectoExistente = proyectoService.obtenerProyectoPorId(id);
        
        if (proyectoExistente != null) {
            proyectoExistente.setNombre(proyectoActualizado.getNombre());
            proyectoExistente.setDescripcion(proyectoActualizado.getDescripcion());
            proyectoExistente.setFechaInicio(proyectoActualizado.getFechaInicio());
            proyectoExistente.setEstado(proyectoActualizado.getEstado());
            proyectoService.guardarProyecto(proyectoExistente);
        }
        
        return "redirect:/proyectos"; 
    }

    @PostMapping("/guardar")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable("id") Long id) {
        proyectoService.eliminarProyecto(id);
        return "redirect:/proyectos";
    }
}
