package mitrack_proyecto.model;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReporteGeneral {

    private Double kmRecorridos;
    private Cliente cliente;
    private Ruta ruta;
    private Pago pago;
    private LocalTime horaSalida;
    private LocalTime horaEntrada;
    private LocalTime duracionViaje;
    private ReporteCarga ReporteCarga;
}
