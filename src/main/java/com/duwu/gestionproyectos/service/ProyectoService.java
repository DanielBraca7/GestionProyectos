package com.duwu.gestionproyectos.service;

import com.duwu.gestionproyectos.model.Proyecto;
import com.duwu.gestionproyectos.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElseThrow(()->  new IllegalArgumentException("Proyecto no encontrado con id: " + id));
    }

    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}

