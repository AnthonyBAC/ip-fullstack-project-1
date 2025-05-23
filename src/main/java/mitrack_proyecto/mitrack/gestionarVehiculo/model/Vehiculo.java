package mitrack_proyecto.mitrack.gestionarVehiculo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;
    private String patente;
    private String estado;
    private double km_actual;
}

// Vehiculo (id, patente, estado, km_actual)