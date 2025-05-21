package mitrack_proyecto.mitrack.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private String nombreCli;
    private int rutCli;
    private String dvrunCli;
    private int telefonoCli;
    private String emailCli;
}