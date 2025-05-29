package mitrack_proyecto.reporteGeneral.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARGAS")
public class Carga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    
    @Column(name = "PESO", precision = 10, scale = 2)
    private BigDecimal peso;
    
    @Column(name = "FECHA_CARGA")
    private LocalDateTime fechaCarga;
    
    // Constructores
    public Carga() {}
    
    public Carga(String descripcion, BigDecimal peso) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.fechaCarga = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public BigDecimal getPeso() { return peso; }
    public void setPeso(BigDecimal peso) { this.peso = peso; }
    
    public LocalDateTime getFechaCarga() { return fechaCarga; }
    public void setFechaCarga(LocalDateTime fechaCarga) { this.fechaCarga = fechaCarga; }
}