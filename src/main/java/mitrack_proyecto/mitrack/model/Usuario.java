package mitrack_proyecto.mitrack.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    private String nombreUsuario;
    private String passUsuario;
}
