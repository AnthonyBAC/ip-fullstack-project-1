package mitrack_proyecto.mitrack.reporteGeneral.repository;

import com.mitrack.reportegeneral.model.VehiculoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VehiculoReporteRepository extends JpaRepository<VehiculoReporte, Long> {
    
    List<VehiculoReporte> findByTipoOperacion(String tipoOperacion);
    
    List<VehiculoReporte> findByPatente(String patente);
    
    @Query("SELECT v FROM VehiculoReporte v WHERE v.fechaRegistro BETWEEN :fechaInicio AND :fechaFin ORDER BY v.fechaRegistro DESC")
    List<VehiculoReporte> findByFechaRegistroBetween(
        @Param("fechaInicio") LocalDateTime fechaInicio, 
        @Param("fechaFin") LocalDateTime fechaFin
    );
    
    @Query("SELECT COUNT(v) FROM VehiculoReporte v WHERE v.tipoOperacion = :tipo AND DATE(v.fechaRegistro) = CURRENT_DATE")
    Long countByTipoOperacionHoy(@Param("tipo") String tipo);
    
    @Query("SELECT COUNT(v) FROM VehiculoReporte v WHERE v.tipoOperacion = :tipo")
    Long countByTipoOperacion(@Param("tipo") String tipo);
    
    @Query("SELECT AVG(v.kmActual) FROM VehiculoReporte v")
    Double findPromedioKilometraje();
    
    @Query("SELECT v FROM VehiculoReporte v ORDER BY v.fechaRegistro DESC")
    List<VehiculoReporte> findAllOrderByFechaDesc();
    
    @Query("SELECT DISTINCT v.patente FROM VehiculoReporte v")
    List<String> findAllPatentes();
    
    @Query("SELECT v FROM VehiculoReporte v WHERE v.patente = :patente ORDER BY v.fechaRegistro DESC")
    List<VehiculoReporte> findHistorialByPatente(@Param("patente") String patente);
}