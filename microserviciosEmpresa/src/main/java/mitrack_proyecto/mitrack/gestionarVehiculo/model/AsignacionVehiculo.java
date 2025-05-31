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
public class AsignacionVehiculo {
    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;
    private Long id_conductor;
    private Long id_vehiculo;
    private String fecha_asignacion;

}

// AsignacionVehiculo(id,id_conductor,id_vehiculo,fecha_asignacion)