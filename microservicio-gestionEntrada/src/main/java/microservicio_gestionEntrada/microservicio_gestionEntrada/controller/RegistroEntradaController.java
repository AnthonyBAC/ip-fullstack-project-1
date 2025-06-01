package microservicio_gestionEntrada.microservicio_gestionEntrada.controller;

import microservicio_gestionEntrada.microservicio_gestionEntrada.model.VehiculoEntrada;
import microservicio_gestionEntrada.microservicio_gestionEntrada.services.VehiculoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class RegistroEntradaController {

    @Autowired
    private VehiculoEntradaService service;

    // Endpoint de prueba
    @GetMapping("/test")
    public String test() {
        return "Microservicio Registro Entrada funcionando!";
    }

    // Registrar entrada
    @PostMapping("/registrar")
    public VehiculoEntrada registrarEntrada(@RequestBody VehiculoEntrada vehiculo) {
        return service.registrarEntrada(vehiculo);
    }

    // Obtener todas las entradas
    @GetMapping
    public List<VehiculoEntrada> obtenerTodas() {
        return service.obtenerTodas();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoEntrada> buscarPorId(@PathVariable Long id) {
        Optional<VehiculoEntrada> vehiculo = service.buscarPorId(id);
        if (vehiculo.isPresent()) {
            return ResponseEntity.ok(vehiculo.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar por patente
    @GetMapping("/patente/{patente}")
    public List<VehiculoEntrada> buscarPorPatente(@PathVariable String patente) {
        return service.buscarPorPatente(patente);
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public List<VehiculoEntrada> buscarPorEstado(@PathVariable String estado) {
        return service.buscarPorEstado(estado);
    }

    // Contar total
    @GetMapping("/count")
    public long contarTotal() {
        return service.contarTotal();
    }

    // Actualizar entrada
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoEntrada> actualizar(@PathVariable Long id,
            @RequestBody VehiculoEntrada vehiculoActualizado) {
        Optional<VehiculoEntrada> vehiculoExistente = service.buscarPorId(id);
        if (vehiculoExistente.isPresent()) {
            VehiculoEntrada vehiculo = vehiculoExistente.get();
            vehiculo.setPatente(vehiculoActualizado.getPatente());
            vehiculo.setEstado(vehiculoActualizado.getEstado());
            vehiculo.setKmActual(vehiculoActualizado.getKmActual());
            vehiculo.setTipoOperacion(vehiculoActualizado.getTipoOperacion());
            service.actualizar(vehiculo);
            return ResponseEntity.ok(vehiculo);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar entrada
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Entrada eliminada correctamente");
    }
}
