package mitrack_proyecto.reporteGeneral.model;

package com.mitrack.reporte.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    
    @Column(name = "EMAIL", length = 150)
    private String email;
    
    @Column(name = "ACTIVO")
    private Integer activo;
    
    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;
    
    // Constructores
    public Usuario() {}
    
    public Usuario(String nombre, String email, Integer activo) {
        this.nombre = nombre;
        this.email = email;
        this.activo = activo;
        this.fechaCreacion = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getActivo() { return activo; }
    public void setActivo(Integer activo) { this.activo = activo; }
    
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    // Método helper
    public boolean isActivo() {
        return activo != null && activo == 1;
    }
}