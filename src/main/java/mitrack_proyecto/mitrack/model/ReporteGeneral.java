package mitrack_proyecto.mitrack.model;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mitrack_proyecto.mitrack.gestionarCarga.model.GestionarCarga;
import mitrack_proyecto.mitrack.gestionarCliente.model.Cliente;
import mitrack_proyecto.mitrack.gestionarRuta.model.Ruta;
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
    private GestionarCarga ReporteCarga;
}
