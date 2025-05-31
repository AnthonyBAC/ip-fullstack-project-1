package microservicio_reporteGeneral.microservicio_reporteGeneral.services;

import com.mitrack.reportegeneral.model.ReporteGeneralModel;
import com.mitrack.reportegeneral.repository.ReporteGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteGeneralServices {
    
    @Autowired
    private ReporteGeneralRepository repository;
    
    public List<ReporteGeneralModel> obtenerTodos() {
        return repository.findAll();
    }
    
    public ReporteGeneralModel crear(ReporteGeneralModel reporte) {
        return repository.save(reporte);
    }
    
    public Optional<ReporteGeneralModel> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public List<ReporteGeneralModel> buscarPorPatente(String patente) {
        return repository.findByPatente(patente);
    }
    
    public List<ReporteGeneralModel> buscarPorTipo(String tipo) {
        return repository.findByTipoOperacion(tipo);
    }
    
    public long contarTotal() {
        return repository.count();
    }
    
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
