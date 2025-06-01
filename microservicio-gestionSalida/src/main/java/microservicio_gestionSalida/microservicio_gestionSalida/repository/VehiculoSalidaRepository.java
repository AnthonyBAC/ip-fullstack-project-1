package microservicio_gestionSalida.microservicio_gestionSalida.repository;

import microservicio_gestionSalida.microservicio_gestionSalida.model.VehiculoSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculoSalidaRepository extends JpaRepository<VehiculoSalida, Long> {

    // Métodos básicos automáticos
    List<VehiculoSalida> findByPatente(String patente);

    List<VehiculoSalida> findByEstado(String estado);

    // JpaRepository ya incluye: findAll(), save(), findById(), deleteById(),
    // count()
}
