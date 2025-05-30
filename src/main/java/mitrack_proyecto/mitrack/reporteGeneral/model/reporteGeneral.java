package mitrack_proyecto.mitrack.reporteGeneral.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VEHICULO_REPORTE")
public class reporteGeneral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_reporte_seq")
    @SequenceGenerator(name = "vehiculo_reporte_seq", sequenceName = "VEHICULO_REPORTE_SEQ", allocationSize = 1)
    @Column(name = "ID_VEHICULO")
    private Long idVehiculo;
    
    @Column(name = "PATENTE", nullable = false, length = 10)
    private String patente;
    
    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;
    
    @Column(name = "KM_ACTUAL", nullable = false)
    private Double kmActual;
    
    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;
    
    @Column(name = "TIPO_OPERACION", length = 10)
    private String tipoOperacion; // 'ENTRADA' o 'SALIDA'
    
    // Constructores
    public VehiculoReporte() {}
    
    public VehiculoReporte(String patente, String estado, Double kmActual, String tipoOperacion) {
        this.patente = patente;
        this.estado = estado;
        this.kmActual = kmActual;
        this.tipoOperacion = tipoOperacion;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getIdVehiculo() {
        return idVehiculo;
    }
    
    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
    public String getPatente() {
        return patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Double getKmActual() {
        return kmActual;
    }
    
    public void setKmActual(Double kmActual) {
        this.kmActual = kmActual;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getTipoOperacion() {
        return tipoOperacion;
    }
    
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
