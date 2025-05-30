package mitrack_proyecto.mitrack.reporteGeneral.services;

import com.mitrack.reportegeneral.model.VehiculoReporte;
import com.mitrack.reportegeneral.repository.VehiculoReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReporteGeneralService {
    
    @Autowired
    private VehiculoReporteRepository vehiculoReporteRepository;
    
    @Transactional(readOnly = true)
    public Map<String, Object> generarReporteResumen() {
        Map<String, Object> reporte = new HashMap<>();
        
        Long totalVehiculos = vehiculoReporteRepository.count();
        Long totalEntradas = vehiculoReporteRepository.countByTipoOperacion("ENTRADA");
        Long totalSalidas = vehiculoReporteRepository.countByTipoOperacion("SALIDA");
        Long entradasHoy = vehiculoReporteRepository.countByTipoOperacionHoy("ENTRADA");
        Long salidasHoy = vehiculoReporteRepository.countByTipoOperacionHoy("SALIDA");
        Double promedioKm = vehiculoReporteRepository.findPromedioKilometraje();
        
        reporte.put("totalVehiculos", totalVehiculos);
        reporte.put("totalEntradas", totalEntradas);
        reporte.put("totalSalidas", totalSalidas);
        reporte.put("entradasHoy", entradasHoy);
        reporte.put("salidasHoy", salidasHoy);
        reporte.put("promedioKilometraje", promedioKm != null ? promedioKm : 0.0);
        reporte.put("fechaReporte", LocalDateTime.now());
        
        return reporte;
    }
    
    @Transactional(readOnly = true)
    public List<VehiculoReporte> obtenerTodosLosMovimientos() {
        return vehiculoReporteRepository.findAllOrderByFechaDesc();
    }
    
    @Transactional(readOnly = true)
    public List<VehiculoReporte> obtenerMovimientosPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return vehiculoReporteRepository.findByFechaRegistroBetween(fechaInicio, fechaFin);
    }
    
    @Transactional(readOnly = true)
    public List<VehiculoReporte> obtenerMovimientosPorTipo(String tipoOperacion) {
        return vehiculoReporteRepository.findByTipoOperacion(tipoOperacion);
    }
    
    @Transactional(readOnly = true)
    public List<VehiculoReporte> obtenerHistorialPorPatente(String patente) {
        return vehiculoReporteRepository.findHistorialByPatente(patente);
    }
    
    @Transactional(readOnly = true)
    public List<String> obtenerTodasLasPatentes() {
        return vehiculoReporteRepository.findAllPatentes();
    }
    
    @Transactional(readOnly = true)
    public Map<String, Long> obtenerEstadisticasPorTipo() {
        Map<String, Long> estadisticas = new HashMap<>();
        estadisticas.put("ENTRADA", vehiculoReporteRepository.countByTipoOperacion("ENTRADA"));
        estadisticas.put("SALIDA", vehiculoReporteRepository.countByTipoOperacion("SALIDA"));
        return estadisticas;
    }
    
    public VehiculoReporte registrarMovimiento(VehiculoReporte vehiculo) {
        if (vehiculo.getPatente() == null || vehiculo.getPatente().trim().isEmpty()) {
            throw new IllegalArgumentException("La patente es obligatoria");
        }
        
        if (vehiculo.getKmActual() == null || vehiculo.getKmActual() < 0) {
            throw new IllegalArgumentException("El kilometraje debe ser válido");
        }
        
        if (vehiculo.getTipoOperacion() == null) {
            vehiculo.setTipoOperacion("CONSULTA");
        }
        
        vehiculo.setFechaRegistro(LocalDateTime.now());
        return vehiculoReporteRepository.save(vehiculo);
    }
    
    public void eliminarMovimiento(Long id) {
        vehiculoReporteRepository.deleteById(id);
    }
}
