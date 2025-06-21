package microservicio_Ruta.microservicio_Ruta.repository;

import org.springframework.stereotype.Repository;
import microservicio_Ruta.microservicio_Ruta.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    Ruta findByOrigen(String origen);
}