package mitrack_proyecto.mitrack.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//Genera automaticamente getters y setters toStringetc() ahorro.
@Data
// Genera un constructor con todos los campos como parametro
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor

public class Cliente {

    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCli;
    private String nombreCli;
    private String apellidoCli;
    private int runCli;
    private String dvCli;
    private int telCli;
    private String origenCli;
    private String destinoCli;
}