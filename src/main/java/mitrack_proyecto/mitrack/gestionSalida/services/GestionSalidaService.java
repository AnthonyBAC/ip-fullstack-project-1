package mitrack_proyecto.mitrack.gestionSalida.services;

import com.mitrack.gestionsalida.model.Vehiculo;
import com.mitrack.gestionsalida.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GestionSalidaService {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    public Vehiculo registrarSalida(Vehiculo vehiculo) {
        // Validar que el vehículo no esté ya en salida
        Optional<Vehiculo> vehiculoExistente = vehiculoRepository.findByPatenteAndSalida(vehiculo.getPatente());
        if (vehiculoExistente.isPresent()) {
            throw new RuntimeException("El vehículo con patente " + vehiculo.getPatente() + " ya está registrado en salida");
        }
        
        vehiculo.setEstado("SALIDA");
        return vehiculoRepository.save(vehiculo);
    }
    
    @Transactional(readOnly = true)
    public List<Vehiculo> obtenerTodosLosSalidas() {
        return vehiculoRepository.findByEstado("SALIDA");
    }
    
    @Transactional(readOnly = true)
    public Optional<Vehiculo> buscarPorPatente(String patente) {
        return vehiculoRepository.findByPatente(patente);
    }
    
    @Transactional(readOnly = true)
    public Optional<Vehiculo> buscarPorId(Long id) {
        return vehiculoRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Long contarVehiculosEnSalida() {
        return vehiculoRepository.countVehiculosEnSalida();
    }
    
    public void eliminarRegistro(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new RuntimeException("No se encontró el registro con ID: " + id);
        }
        vehiculoRepository.deleteById(id);
    }
    
    public Vehiculo actualizarKilometraje(Long id, Double nuevoKm) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(id);
        if (vehiculoOpt.isEmpty()) {
            throw new RuntimeException("No se encontró el vehículo con ID: " + id);
        }
        
        Vehiculo vehiculo = vehiculoOpt.get();
        vehiculo.setKmActual(nuevoKm);
        return vehiculoRepository.save(vehiculo);
    }
}
