package microservicio_GestionPago.microservicio_GestionPago.repository;

import org.springframework.stereotype.Repository;

import microservicio_GestionPago.microservicio_GestionPago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    Pago findByTipo(String tipo);

}