package microservicio_reporteGeneral.microservicio_reporteGeneral.services;

import microservicio_reporteGeneral.microservicio_reporteGeneral.model.ReporteGeneralModel;
import microservicio_reporteGeneral.microservicio_reporteGeneral.repository.ReporteGeneralRepository;
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

    /**
     * Actualiza un reporte existente
     * 
     * @param reporte El reporte con los datos actualizados
     * @return El reporte actualizado
     */
    public ReporteGeneralModel actualizar(ReporteGeneralModel reporte) {
        return repository.save(reporte);
    }

    /**
     * Actualiza un reporte existente de forma segura, verificando que existe
     * 
     * @param id      El ID del reporte a actualizar
     * @param reporte Los nuevos datos del reporte
     * @return Optional con el reporte actualizado si existe, vacío si no existe
     */
    public Optional<ReporteGeneralModel> actualizarSeguro(Long id, ReporteGeneralModel reporte) {
        return repository.findById(id)
                .map(reporteExistente -> {
                    // Establecer el ID para asegurar que se actualice el registro correcto
                    reporte.setIdVehiculo(id);
                    return repository.save(reporte);
                });
    }
}
