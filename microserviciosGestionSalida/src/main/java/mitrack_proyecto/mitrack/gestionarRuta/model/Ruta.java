package mitrack_proyecto.mitrack.gestionarRuta.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Genera automaticamente getters y setters toStringetc() ahorro.
@Data
// Genera un constructor con todos los campos como parametro
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
public class Ruta {

    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruta;
    private String origen;
    private String destino;
    private double distancia_km;
    private double tiempo_estimado;

}

// Ruta (origen, destino, distancia_km, tiempo_estimado)