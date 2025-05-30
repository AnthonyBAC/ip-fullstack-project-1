package mitrack_proyecto.mitrack.reporteGeneral.model;

import jakarta.persistence.*;

@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PATENTE", length = 10)
    private String patente;

    @Column(name = "MODELO", length = 50)
    private String modelo;

    @Column(name = "ESTADO", length = 20)
    private String estado;

    // Constructores
    public Vehiculo() {
    }

    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
        this.estado = "DISPONIBLE";
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método helper
    public boolean isDisponible() {
        return "DISPONIBLE".equals(estado);
    }
}
