package com.duwu.gestionproyectos.service;

import com.duwu.gestionproyectos.model.Proyecto;
import com.duwu.gestionproyectos.model.Tarea;
import com.duwu.gestionproyectos.repository.ProyectoRepository;
import com.duwu.gestionproyectos.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
	private final TareaRepository tareaRepository;
	private final ProyectoRepository proyectoRepository;
	
	public TareaService(TareaRepository tareaRepository,ProyectoRepository proyectoRepository) {

		this.tareaRepository = tareaRepository;
		this.proyectoRepository = proyectoRepository;
		
	}
	
	public List<Tarea> obtenerProyectos(Long proyectoId){
		return tareaRepository.findByProyectoId(proyectoId);
	}
	
	public Tarea guardarTareas(Long proyectoId,Tarea tarea) {
		
		Proyecto proyecto = proyectoRepository.findById(proyectoId)
				.orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado con id: " + proyectoId));
	    tarea.setProyecto(proyecto);
		return tareaRepository.save(tarea);
		
	}
	
	  public void eliminarTarea(Long id) {
	        tareaRepository.deleteById(id);
	    }

}

