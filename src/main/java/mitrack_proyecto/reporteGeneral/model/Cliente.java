package mitrack_proyecto.reporteGeneral.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    
    @Column(name = "RUT", length = 20)
    private String rut;
    
    @Column(name = "ACTIVO")
    private Integer activo;
    
    // Constructores
    public Cliente() {}
    
    public Cliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.activo = 1;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    
    public Integer getActivo() { return activo; }
    public void setActivo(Integer activo) { this.activo = activo; }
}
