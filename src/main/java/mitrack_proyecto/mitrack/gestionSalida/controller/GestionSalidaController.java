package mitrack_proyecto.mitrack.gestionSalida.controller;

import com.mitrack.gestionsalida.model.Vehiculo;
import com.mitrack.gestionsalida.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gestion-salida")
@CrossOrigin(origins = "*")
public class GestionSalidaController {
    
    @Autowired
    private GestionSalidaController vehiculoService;
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarSalida(@RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo vehiculoRegistrado = vehiculoService.registrarSalida(vehiculo);
            return ResponseEntity.ok(vehiculoRegistrado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Vehiculo>> obtenerTodosLosSalidas() {
        try {
            List<Vehiculo> vehiculos = vehiculoService.obtenerTodosLosSalidas();
            return ResponseEntity.ok(vehiculos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar-patente/{patente}")
    public ResponseEntity<?> buscarPorPatente(@PathVariable String patente) {
        try {
            Optional<Vehiculo> vehiculo = vehiculoService.buscarPorPatente(patente);
            if (vehiculo.isPresent()) {
                return ResponseEntity.ok(vehiculo.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar vehículo: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Optional<Vehiculo> vehiculo = vehiculoService.buscarPorId(id);
            if (vehiculo.isPresent()) {
                return ResponseEntity.ok(vehiculo.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar vehículo: " + e.getMessage());
        }
    }
    
    @GetMapping("/contar")
    public ResponseEntity<Long> contarVehiculosEnSalida() {
        try {
            Long cantidad = vehiculoService.contarVehiculosEnSalida();
            return ResponseEntity.ok(cantidad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}/kilometraje")
    public ResponseEntity<?> actualizarKilometraje(@PathVariable Long id, @RequestBody Double nuevoKm) {
        try {
            Vehiculo vehiculoActualizado = vehiculoService.actualizarKilometraje(id, nuevoKm);
            return ResponseEntity.ok(vehiculoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegistro(@PathVariable Long id) {
        try {
            vehiculoService.eliminarRegistro(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
    }
}

