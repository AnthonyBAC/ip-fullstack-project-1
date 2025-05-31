package mitrack_proyecto.mitrack.gestionarCarga.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GestionarCarga {

    private Long id_carga;
    private String descripcion;
}

/*
 * Carga (id, descripcion)
 * GuiaCliente (id, id_cliente, id_ruta, id_carga)
 */
