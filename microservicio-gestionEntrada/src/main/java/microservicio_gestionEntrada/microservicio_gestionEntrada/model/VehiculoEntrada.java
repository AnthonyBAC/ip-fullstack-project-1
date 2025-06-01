package microservicio_gestionEntrada.microservicio_gestionEntrada.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VEHICULO_ENTRADA")
public class VehiculoEntrada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    
    @Column(name = "PATENTE")
    private String patente;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "KM_ACTUAL")
    private Double kmActual;
    
    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;
    
    @Column(name = "TIPO_OPERACION")
    private String tipoOperacion;
    
    // Constructores
    public VehiculoEntrada() {}
    
    // Getters y Setters
    public Long getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(Long idVehiculo) { this.idVehiculo = idVehiculo; }
    
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Double getKmActual() { return kmActual; }
    public void setKmActual(Double kmActual) { this.kmActual = kmActual; }
    
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    public String getTipoOperacion() { return tipoOperacion; }
    public void setTipoOperacion(String tipoOperacion) { this.tipoOperacion = tipoOperacion; }
    
    @PrePersist
    protected void onCreate() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
        if (estado == null) {
            estado = "ENTRADA";
        }
        if (tipoOperacion == null) {
            tipoOperacion = "ENTRADA";
        }
    }
}
