package com.duwu.gestionproyectos.model;
import jakarta.persistence.*;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Proyecto {
	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
    private String descripcion;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
    
    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;
    
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;
    
    public enum EstadoProyecto {
        ACTIVO, EN_PROGRESO, FINALIZADO
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
 
    
    
}
