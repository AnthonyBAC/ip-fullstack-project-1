package mitrack_proyecto.mitrack.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pago {

    private Double monto;
    private LocalDate fechaPago;
    private String tipo;
}
