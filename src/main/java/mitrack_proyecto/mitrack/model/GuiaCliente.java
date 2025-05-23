package mitrack_proyecto.mitrack.model;

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
    private Cliente id_cliente;
    // private GestionarRuta id_ruta;
    private GestionarCarga id_carga;

}
