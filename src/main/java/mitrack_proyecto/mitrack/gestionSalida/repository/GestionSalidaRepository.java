package mitrack_proyecto.mitrack.gestionSalida.repository;

import com.mitrack.gestionsalida.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GestionSalidaRepository extends JpaRepository<Vehiculo, Long> {
    
    Optional<Vehiculo> findByPatente(String patente);
    
    List<Vehiculo> findByEstado(String estado);
    
    @Query("SELECT v FROM Vehiculo v WHERE v.patente = :patente AND v.estado = 'SALIDA'")
    Optional<Vehiculo> findByPatenteAndSalida(@Param("patente") String patente);
    
    @Query("SELECT COUNT(v) FROM Vehiculo v WHERE v.estado = 'SALIDA'")
    Long countVehiculosEnSalida();
}
