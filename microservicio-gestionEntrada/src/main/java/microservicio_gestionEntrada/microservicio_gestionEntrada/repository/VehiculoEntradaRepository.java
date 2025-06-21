package microservicio_gestionEntrada.microservicio_gestionEntrada.repository;

import microservicio_gestionEntrada.microservicio_gestionEntrada.model.VehiculoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoEntradaRepository extends JpaRepository<VehiculoEntrada, Long> {

}
