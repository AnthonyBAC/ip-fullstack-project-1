package mitrack_proyecto.mitrack.gestionSalida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "VEHICULOS_SALIDA")
public class GestionSalidaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "VEHICULO_SALIDA_SEQ", allocationSize = 1)
    @Column(name = "ID_VEHICULO")
    private Long idVehiculo;
    
    @Column(name = "PATENTE", nullable = false, length = 10)
    private String patente;
    
    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;
    
    @Column(name = "KM_ACTUAL", nullable = false)
    private Double kmActual;
    
    // Constructores
    public Vehiculo() {}
    
    public Vehiculo(String patente, String estado, Double kmActual) {
        this.patente = patente;
        this.estado = estado;
        this.kmActual = kmActual;
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
}
