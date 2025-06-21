package microservicio_Ruta.microservicio_Ruta.services;

import microservicio_Ruta.microservicio_Ruta.repository.RutaRepository;
import microservicio_Ruta.microservicio_Ruta.model.Ruta;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    // Metodo para obtener lista de rutas
    // Retorna lista de rutas
    public List<Ruta> obtenerRutas() {
        return rutaRepository.findAll();
    }

    // Metodo para buscar ruta por id
    // Retorna ruta si se encuentra, sino lanza excepcion
    public Ruta buscarPorId(Long id) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
        return ruta;
    }

    // Metodo para buscar ruta por origen
    // Retorna ruta si se encuentra, sino lanza excepcion
    public Ruta buscarPorOrigen(String origen) {
        Ruta ruta = rutaRepository.findByOrigen(origen);
        if (ruta == null) {
            throw new RuntimeException("Ruta no encontrada");
        }
        return ruta;
    }

    // Metodo para guardar ruta
    // Retorna ruta guardada
    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    // Metodo para eliminar ruta por id
    // Retorna mensaje de confirmacion si se elimina, sino lanza excepcion
    public String eliminarRutaPorId(Long id) {
        boolean rutaid = rutaRepository.existsById(id);
        if (!rutaid) {
            throw new RuntimeException("No se encontró ruta para eliminar");
        }
        return "Ruta eliminada exitosamente";
    }

    // Metodo para actualizar ruta
    // Retorna ruta actualizada
    public Ruta actualizarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }
}
