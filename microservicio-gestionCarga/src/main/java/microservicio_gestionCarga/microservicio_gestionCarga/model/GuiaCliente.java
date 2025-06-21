package microservicio_gestionCarga.microservicio_gestionCarga.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_guia;

    // private GestionarRuta id_ruta;
    private GestionarCarga id_carga;

    // public static class Cliente {
    // // Define clave primaria
    // // Se indica que esta id se generara de manera automatica de forma
    // // auto-incremental
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int idCli;
    // private String nombreCli;
    // private String apellidoCli;
    // private int runCli;
    // private String dvCli;
    // private int telCli;
    // private String origenCli;
    // private String destinoCli;
    // }

}
