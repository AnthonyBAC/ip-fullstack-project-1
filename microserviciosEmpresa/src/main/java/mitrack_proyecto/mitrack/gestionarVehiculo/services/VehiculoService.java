package mitrack_proyecto.mitrack.gestionarVehiculo.services;

import mitrack_proyecto.mitrack.gestionarVehiculo.repository.VehiculoRepository;
import mitrack_proyecto.mitrack.gestionarVehiculo.model.Vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Metodo para obtener lista de vehiculos
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.obtenerVehiculos();
    }

    // Metodo para buscar vehiculo por id
    // Retorna vehiculo si se encuentra, sino lanza excepcion
    public Vehiculo buscarPorId(Long id) {
        Vehiculo vehiculo = vehiculoRepository.buscarPorId(id);
        if (vehiculo == null) {
            throw new RuntimeException("Vehiculo no encontrado");
        }
        return vehiculo;
    }

    // Metodo para buscar vehiculo por patente
    public Vehiculo buscarPorPatente(String patente) {
        Vehiculo vehiculo = vehiculoRepository.buscarPorPatente(patente);
        if (vehiculo == null) {
            throw new RuntimeException("Vehiculo no encontrado");
        }
        return vehiculo;
    }

    // Metodo para guardar vehiculo
    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.guardar(vehiculo);
    }

    // Metodo para eliminar vehiculo por id
    public String eliminarVehiculoPorId(Long id) {
        boolean vehiculoid = vehiculoRepository.eliminarPorId(id);
        if (!vehiculoid) {
            throw new RuntimeException("No se encontró vehiculo para eliminar");
        }
        return "Vehiculo eliminado exitosamente";
    }

    // Metodo para actualizar vehiculo
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.actualizarPorId(vehiculo);
    }
}
