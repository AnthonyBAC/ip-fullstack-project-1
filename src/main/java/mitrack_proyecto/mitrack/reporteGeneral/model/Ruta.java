package mitrack_proyecto.mitrack.reporteGeneral.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RUTAS")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @Column(name = "ORIGEN", length = 100)
    private String origen;

    @Column(name = "DESTINO", length = 100)
    private String destino;

    @Column(name = "ESTADO", length = 20)
    private String estado;

    // Constructores
    public Ruta() {
    }

    public Ruta(String nombre, String origen, String destino) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.estado = "ACTIVA";
    }

    // Getters y Setters
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método helper
    public boolean isActiva() {
        return "ACTIVA".equals(estado);
    }
}