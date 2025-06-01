package microservicio_gestionEntrada.microservicio_gestionEntrada.services;

import microservicio_gestionEntrada.microservicio_gestionEntrada.model.VehiculoEntrada;
import microservicio_gestionEntrada.microservicio_gestionEntrada.repository.VehiculoEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoEntradaService {

    @Autowired
    private VehiculoEntradaRepository repository;

    // Registrar entrada
    public VehiculoEntrada registrarEntrada(VehiculoEntrada vehiculo) {
        vehiculo.setEstado("ENTRADA");
        vehiculo.setTipoOperacion("ENTRADA");
        return repository.save(vehiculo);
    }

    // Obtener todas las entradas
    public List<VehiculoEntrada> obtenerTodas() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<VehiculoEntrada> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Buscar por patente
    public List<VehiculoEntrada> buscarPorPatente(String patente) {
        return repository.findByPatente(patente);
    }

    // Buscar por estado
    public List<VehiculoEntrada> buscarPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    // Contar total
    public long contarTotal() {
        return repository.count();
    }

    // Actualizar
    public VehiculoEntrada actualizar(VehiculoEntrada vehiculo) {
        return repository.save(vehiculo);
    }

    // Eliminar
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
