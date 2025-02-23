package com.duwu.gestionproyectos.repository;

import com.duwu.gestionproyectos.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyectoId(Long proyectoId);
}
