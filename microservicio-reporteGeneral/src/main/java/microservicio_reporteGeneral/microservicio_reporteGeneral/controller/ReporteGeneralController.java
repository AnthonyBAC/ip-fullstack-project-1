package microservicio_reporteGeneral.microservicio_reporteGeneral.controller;

import com.mitrack.reportegeneral.model.ReporteGeneralModel;
import com.mitrack.reportegeneral.services.ReporteGeneralServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteGeneralController {
    
    @Autowired
    private ReporteGeneralServices services;
    
    @GetMapping("/test")
    public String test() {
        return "Microservicio Reporte General funcionando!";
    }
    
    @GetMapping
    public List<ReporteGeneralModel> obtenerTodos() {
        return services.obtenerTodos();
    }
    
    @PostMapping
    public ReporteGeneralModel crear(@RequestBody ReporteGeneralModel reporte) {
        return services.crear(reporte);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ReporteGeneralModel> buscarPorId(@PathVariable Long id) {
        Optional<ReporteGeneralModel> reporte = services.buscarPorId(id);
        if (reporte.isPresent()) {
            return ResponseEntity.ok(reporte.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/patente/{patente}")
    public List<ReporteGeneralModel> buscarPorPatente(@PathVariable String patente) {
        return services.buscarPorPatente(patente);
    }
    
    @GetMapping("/tipo/{tipo}")
    public List<ReporteGeneralModel> buscarPorTipo(@PathVariable String tipo) {
        return services.buscarPorTipo(tipo);
    }
    
    @GetMapping("/count")
    public long contarTotal() {
        return services.contarTotal();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        services.eliminar(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
}
