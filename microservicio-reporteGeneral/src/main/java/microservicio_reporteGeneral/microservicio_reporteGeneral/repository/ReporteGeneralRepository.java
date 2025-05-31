package microservicio_reporteGeneral.microservicio_reporteGeneral.repository;

import com.mitrack.reportegeneral.model.ReporteGeneralModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReporteGeneralRepository extends JpaRepository<ReporteGeneralModel, Long> {
    
    List<ReporteGeneralModel> findByTipoOperacion(String tipoOperacion);
    List<ReporteGeneralModel> findByPatente(String patente);
}
