package mitrack_proyecto.mitrack.gestionEntrada.services;

import com.mitrack.gestionentrada.model.Vehiculo;
import com.mitrack.gestionentrada.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GestionEntradaService {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    public Vehiculo registrarEntrada(Vehiculo vehiculo) {
        // Validar que el vehículo no esté ya registrado en entrada
        Optional<Vehiculo> vehiculoExistente = vehiculoRepository.findByPatenteAndEntrada(vehiculo.getPatente());
        if (vehiculoExistente.isPresent()) {
            throw new RuntimeException("El vehículo con patente " + vehiculo.getPatente() + " ya está registrado en entrada");
        }
        
        vehiculo.setEstado("ENTRADA");
        return vehiculoRepository.save(vehiculo);
    }
    
    @Transactional(readOnly = true)
    public List<Vehiculo> obtenerTodasLasEntradas() {
        return vehiculoRepository.findByEstado("ENTRADA");
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
    public Long contarVehiculosEnEntrada() {
        return vehiculoRepository.countVehiculosEnEntrada();
    }
    
    @Transactional(readOnly = true)
    public List<Vehiculo> buscarPorRangoKilometraje(Double kmMin, Double kmMax) {
        return vehiculoRepository.findByKilometrajeRange(kmMin, kmMax);
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
        
        // Validar que el nuevo kilometraje sea mayor al anterior
        if (nuevoKm < vehiculo.getKmActual()) {
            throw new RuntimeException("El nuevo kilometraje no puede ser menor al anterior");
        }
        
        vehiculo.setKmActual(nuevoKm);
        return vehiculoRepository.save(vehiculo);
    }
    
    public Vehiculo procesarRegreso(Long id, Double kmFinal) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(id);
        if (vehiculoOpt.isEmpty()) {
            throw new RuntimeException("No se encontró el vehículo con ID: " + id);
        }
        
        Vehiculo vehiculo = vehiculoOpt.get();
        vehiculo.setKmActual(kmFinal);
        vehiculo.setEstado("REGRESADO");
        return vehiculoRepository.save(vehiculo);
    }
}
