package microservicio_reporteGeneral.microservicio_reporteGeneral.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VEHICULO_REPORTE")
public class ReporteGeneralModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICULO")
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
    public ReporteGeneralModel() {
    }

    // Getters
    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public String getEstado() {
        return estado;
    }

    public Double getKmActual() {
        return kmActual;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    // Setters
    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setKmActual(Double kmActual) {
        this.kmActual = kmActual;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @PrePersist
    protected void onCreate() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }
}