package microservicio_gestionEntrada.microservicio_gestionEntrada.repository;

import com.microservicio.registroentrada.model.VehiculoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculoEntradaRepository extends JpaRepository<VehiculoEntrada, Long> {
    
    // Métodos básicos automáticos
    List<VehiculoEntrada> findByPatente(String patente);
    List<VehiculoEntrada> findByEstado(String estado);
    
    // JpaRepository ya incluye: findAll(), save(), findById(), deleteById(), count()
}
