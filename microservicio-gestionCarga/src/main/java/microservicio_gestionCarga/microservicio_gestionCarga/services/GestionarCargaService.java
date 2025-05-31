package microservicio_gestionCarga.microservicio_gestionCarga.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GestionarCarga;
import microservicio_gestionCarga.microservicio_gestionCarga.repository.GestionarCargaRepository;

@Service
public class GestionarCargaService {
    @Autowired
    private GestionarCargaRepository gestionarCargaRepository;

    // Metodo para obtener lista de cargas
    // Retorna lista de cargas
    public List<GestionarCarga> obtenerCargas() {
        return gestionarCargaRepository.obtenerCargas();
    }

    // Metodo para buscar carga por id
    // Retorna carga si se encuentra, sino lanza excepcion
    public GestionarCarga buscarPorId(Long id) {
        GestionarCarga carga = gestionarCargaRepository.buscarPorId(id);
        if (carga == null) {
            throw new RuntimeException("Carga no encontrada");
        }
        return carga;
    }

    // Metodo para guardar carga
    // Retorna carga guardada
    public GestionarCarga guardar(GestionarCarga carga) {
        return gestionarCargaRepository.guardar(carga);
    }

    // Metodo para eliminar carga por id
    // Retorna mensaje de confirmacion si se elimina, sino lanza excepcion
    public String eliminarPorId(Long id) {
        boolean cargaid = gestionarCargaRepository.eliminarPorId(id);
        if (!cargaid) {
            throw new RuntimeException("No se encontró carga para eliminar");
        }
        return "Carga eliminada exitosamente";
    }

    // Metodo para actualizar carga
    // Retorna carga actualizada
    public GestionarCarga actualizarPorId(GestionarCarga cargaActualizada) {
        return gestionarCargaRepository.actualizarPorId(cargaActualizada);
    }

}
