package microservicio_GestionPago.microservicio_GestionPago.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import microservicio_GestionPago.microservicio_GestionPago.model.Pago;
import java.time.LocalDate;

@Repository

public class PagoRepository {

    //CREACION LISTA DE PAGOS
    private List<Pago> listaPagos = new ArrayList<>();

    public PagoRepository() {
        listaPagos.add(new Pago(100000.0, LocalDate.of(2025, 5, 5), "Efectivo"));
        listaPagos.add(new Pago(225000.0, LocalDate.of(2025, 5, 1), "Transferencia"));
        listaPagos.add(new Pago(250000.0, LocalDate.of(2025, 1, 10), "Transferencia"));
    }

    //MÉTODO PARA AGREGAR PAGOS
    public Pago agregarPago(Pago pago) {
        listaPagos.add(pago);
        return pago;
    }

    //MÉTODO PARA OBTENER LA LISTA DE PAGOS
    public List<Pago> obtenerPagos() {
        return listaPagos;
    }

    //MÉTODO PARA BUSCAR PAGO POR TIPO
    public Pago buscarPorTipo(String tipo) {
        return listaPagos.stream()
                .filter(pago -> pago.getTipo().equalsIgnoreCase(tipo))
                .findFirst()
                .orElse(null);
    }

}
