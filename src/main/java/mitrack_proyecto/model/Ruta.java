package mitrack_proyecto.model;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ruta {

    private String origen;
    private String destino;
    private LocalTime tiempoEstimado;
}
