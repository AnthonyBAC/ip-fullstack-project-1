package microservicio_gestionSalida.microservicio_gestionSalida.services;

import microservicio_gestionSalida.microservicio_gestionSalida.model.VehiculoSalida;
import microservicio_gestionSalida.microservicio_gestionSalida.repository.VehiculoSalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoSalidaService {

    @Autowired
    private VehiculoSalidaRepository repository;

    // Registrar salida
    public VehiculoSalida registrarSalida(VehiculoSalida vehiculo) {
        vehiculo.setEstado("SALIDA");
        vehiculo.setTipoOperacion("SALIDA");
        return repository.save(vehiculo);
    }

    // Obtener todas las salidas
    public List<VehiculoSalida> obtenerTodas() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<VehiculoSalida> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Buscar por patente
    public List<VehiculoSalida> buscarPorPatente(String patente) {
        return repository.findByPatente(patente);
    }

    // Buscar por estado
    public List<VehiculoSalida> buscarPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    // Contar total
    public long contarTotal() {
        return repository.count();
    }

    // Actualizar
    public VehiculoSalida actualizar(VehiculoSalida vehiculo) {
        return repository.save(vehiculo);
    }

    // Eliminar
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
