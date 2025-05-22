package mitrack_proyecto.mitrack.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private int id_cli;
    private String nombre_cli;
    private String apellido_cli;
    private int run_cli;
    private String dv_cli;
    private int tel_cli;
    private String origen_cli;
    private String destino_cli;
}