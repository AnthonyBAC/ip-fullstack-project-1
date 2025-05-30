package mitrack_proyecto.mitrack.reporteGeneral.controller;

import com.mitrack.reportegeneral.model.VehiculoReporte;
import com.mitrack.reportegeneral.service.ReporteGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reporte-general")
@CrossOrigin(origins = "*")
public class ReporteGeneralController {
    
    @Autowired
    private ReporteGeneralService reporteGeneralService;
    
    @GetMapping("/resumen")
    public ResponseEntity<Map<String, Object>> obtenerReporteResumen() {
        Map<String, Object> reporte = reporteGeneralService.generarReporteResumen();
        return ResponseEntity.ok(reporte);
    }
    
    @GetMapping("/movimientos")
    public ResponseEntity<List<VehiculoReporte>> obtenerTodosLosMovimientos() {
        List<VehiculoReporte> movimientos = reporteGeneralService.obtenerTodosLosMovimientos();
        return ResponseEntity.ok(movimientos);
    }
    
    @GetMapping("/movimientos/por-fecha")
    public ResponseEntity<List<VehiculoReporte>> obtenerMovimientosPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        List<VehiculoReporte> movimientos = reporteGeneralService.obtenerMovimientosPorFecha(fechaInicio, fechaFin);
        return ResponseEntity.ok(movimientos);
    }
    
    @GetMapping("/movimientos/tipo/{tipo}")
    public ResponseEntity<List<VehiculoReporte>> obtenerMovimientosPorTipo(@PathVariable String tipo) {
        List<VehiculoReporte> movimientos = reporteGeneralService.obtenerMovimientosPorTipo(tipo);
        return ResponseEntity.ok(movimientos);
    }
    
    @GetMapping("/historial/{patente}")
    public ResponseEntity<List<VehiculoReporte>> obtenerHistorialPorPatente(@PathVariable String patente) {
        List<VehiculoReporte> historial = reporteGeneralService.obtenerHistorialPorPatente(patente);
        return ResponseEntity.ok(historial);
    }
    
    @GetMapping("/patentes")
    public ResponseEntity<List<String>> obtenerTodasLasPatentes() {
        List<String> patentes = reporteGeneralService.obtenerTodasLasPatentes();
        return ResponseEntity.ok(patentes);
    }
    
    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Long>> obtenerEstadisticasPorTipo() {
        Map<String, Long> estadisticas = reporteGeneralService.obtenerEstadisticasPorTipo();
        return ResponseEntity.ok(estadisticas);
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMovimiento(@RequestBody VehiculoReporte vehiculo) {
        try {
            VehiculoReporte movimientoRegistrado = reporteGeneralService.registrarMovimiento(vehiculo);
            return ResponseEntity.ok(movimientoRegistrado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        try {
            reporteGeneralService.eliminarMovimiento(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}