package mitrack_proyecto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReporteCarga {

    private int idFactura;
    private Cliente cliente;
    private String estado;
    private Carga producto;
}
