package com.duwu.gestionproyectos.controller;

import com.duwu.gestionproyectos.model.Tarea;
import com.duwu.gestionproyectos.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tareas")
public class TareaController {
	private final TareaService tareaService;
	
	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}
	
	@GetMapping("/{proyectoId}")
	public String listar(@PathVariable("proyectoId") Long proyectoId, Model model) {
		List<Tarea> tarea = tareaService.obtenerProyectos(proyectoId);
		model.addAttribute("tareas", tarea);
        model.addAttribute("proyectoId", proyectoId);
		return "tarea/tareas";
		
	}
	
	@PostMapping("/guardar/{proyectoId}")
	public String guardar(@PathVariable("proyectoId") Long proyectoId,@ModelAttribute Tarea tarea) {
		tareaService.guardarTareas(proyectoId, tarea);
		return "redirect:/tareas/" + proyectoId;
	}
	
	@GetMapping("/eliminar/{id}/{proyectoId}")
	public String borrar(@PathVariable("id") Long id, @PathVariable("proyectoId") Long proyectoId) {
		tareaService.eliminarTarea(id);
		return "redirect:/tareas/" + proyectoId;
	}
	

}
