package mitrack_proyecto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Conductor {

    private int idConductor;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private int telefonoCon;
}
