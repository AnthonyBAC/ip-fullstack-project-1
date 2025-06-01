package microservicio_gestionSalida.microservicio_gestionSalida.controller;

import microservicio_gestionSalida.microservicio_gestionSalida.model.VehiculoSalida;
import microservicio_gestionSalida.microservicio_gestionSalida.services.VehiculoSalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "*")
public class RegistroSalidaController {

    @Autowired
    private VehiculoSalidaService service;

    // Endpoint de prueba
    @GetMapping("/test")
    public String test() {
        return "Microservicio Registro Salida funcionando!";
    }

    // Registrar salida
    @PostMapping("/registrar")
    public VehiculoSalida registrarSalida(@RequestBody VehiculoSalida vehiculo) {
        return service.registrarSalida(vehiculo);
    }

    // Obtener todas las salidas
    @GetMapping
    public List<VehiculoSalida> obtenerTodas() {
        return service.obtenerTodas();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoSalida> buscarPorId(@PathVariable Long id) {
        Optional<VehiculoSalida> vehiculo = service.buscarPorId(id);
        if (vehiculo.isPresent()) {
            return ResponseEntity.ok(vehiculo.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar por patente
    @GetMapping("/patente/{patente}")
    public List<VehiculoSalida> buscarPorPatente(@PathVariable String patente) {
        return service.buscarPorPatente(patente);
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public List<VehiculoSalida> buscarPorEstado(@PathVariable String estado) {
        return service.buscarPorEstado(estado);
    }

    // Contar total
    @GetMapping("/count")
    public long contarTotal() {
        return service.contarTotal();
    }

    // Actualizar salida
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoSalida> actualizar(@PathVariable Long id,
            @RequestBody VehiculoSalida vehiculoActualizado) {
        Optional<VehiculoSalida> vehiculoExistente = service.buscarPorId(id);
        if (vehiculoExistente.isPresent()) {
            VehiculoSalida vehiculo = vehiculoExistente.get();
            vehiculo.setPatente(vehiculoActualizado.getPatente());
            vehiculo.setEstado(vehiculoActualizado.getEstado());
            vehiculo.setKmActual(vehiculoActualizado.getKmActual());
            vehiculo.setTipoOperacion(vehiculoActualizado.getTipoOperacion());
            service.actualizar(vehiculo);
            return ResponseEntity.ok(vehiculo);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar salida
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Salida eliminada correctamente");
    }
}
