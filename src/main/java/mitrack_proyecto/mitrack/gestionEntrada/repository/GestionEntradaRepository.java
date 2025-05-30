package mitrack_proyecto.mitrack.gestionEntrada.repository;

import com.mitrack.gestionentrada.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GestionEntradaRepository extends JpaRepository<Vehiculo, Long> {
    
    Optional<Vehiculo> findByPatente(String patente);
    
    List<Vehiculo> findByEstado(String estado);
    
    @Query("SELECT v FROM Vehiculo v WHERE v.patente = :patente AND v.estado = 'ENTRADA'")
    Optional<Vehiculo> findByPatenteAndEntrada(@Param("patente") String patente);
    
    @Query("SELECT COUNT(v) FROM Vehiculo v WHERE v.estado = 'ENTRADA'")
    Long countVehiculosEnEntrada();
    
    @Query("SELECT v FROM Vehiculo v WHERE v.kmActual BETWEEN :kmMin AND :kmMax")
    List<Vehiculo> findByKilometrajeRange(@Param("kmMin") Double kmMin, @Param("kmMax") Double kmMax);
}

