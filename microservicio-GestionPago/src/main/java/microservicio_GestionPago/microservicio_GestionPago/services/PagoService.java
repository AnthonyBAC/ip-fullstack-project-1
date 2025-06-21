package microservicio_GestionPago.microservicio_GestionPago.services;

import microservicio_GestionPago.microservicio_GestionPago.model.Pago;
import microservicio_GestionPago.microservicio_GestionPago.repository.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Metodo para obtener lista de pagos
    // Retorna lista de pagos
    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

    // Metodo para buscar pago por tipo
    public Pago buscarPorTipo(String tipo) {
        return pagoRepository.findByTipo(tipo);
    }

    // Metodo para guardar pago
    // retorna pago guardado
    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}
