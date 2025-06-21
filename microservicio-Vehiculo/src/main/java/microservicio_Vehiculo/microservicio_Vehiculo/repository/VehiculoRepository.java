package microservicio_Vehiculo.microservicio_Vehiculo.repository;

import org.springframework.stereotype.Repository;
import microservicio_Vehiculo.microservicio_Vehiculo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Vehiculo findByPatente(String patente);
}