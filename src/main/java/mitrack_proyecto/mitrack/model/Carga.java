package mitrack_proyecto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Carga {

    private String producto;
    private int cantidad;
    private Double precioUnitario;
}
