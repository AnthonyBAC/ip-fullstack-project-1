package mitrack_proyecto.mitrack.gestionarRuta.repository;

import org.springframework.stereotype.Repository;
import mitrack_proyecto.mitrack.gestionarRuta.model.Ruta;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RutaRepository {

    // Genera lista de rutas
    private final List<Ruta> listaRutas = new ArrayList<>();

    // Retorna lista de rutas
    public List<Ruta> obtenerRutas() {
        return listaRutas;
    }

    // Guarda ruta
    // utilizando .add para agregar ruta a la lista
    public Ruta guardar(Ruta ruta) {
        listaRutas.add(ruta);
        return ruta;
    }

    // Elimina ruta
    // utilizando .removeIf para eliminar ruta de la lista
    public boolean eliminarPorId(Long id) {
        return listaRutas.removeIf(ruta -> ruta.getId_ruta().equals(id));
    }

    // Busca ruta por id
    // utilizando
    // .stream para buscar ruta en la lista
    // .filter para filtrar ruta por id
    // .findFirst para obtener la primera ruta encontrado
    // .orElse para devolver null si no se encuentra la ruta
    public Ruta buscarPorId(Long id) {
        return listaRutas.stream()
                .filter(ruta -> ruta.getId_ruta().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Busca ruta por origen
    public Ruta buscarPorOrigen(String origen) {
        return listaRutas.stream()
                .filter(ruta -> ruta.getOrigen().equalsIgnoreCase(origen))
                .findFirst()
                .orElse(null);
    }

    // Actualiza ruta
    // utilizando un bucle for para recorrer la lista de rutas
    // utilizando .set para actualizar la ruta encontrado
    public Ruta actualizarPorId(Ruta rutaActualizada) {
        for (int i = 0; i < listaRutas.size(); i++) {
            if (rutaActualizada.getId_ruta().equals(listaRutas.get(i).getId_ruta())) {
                listaRutas.set(i, rutaActualizada);
                return rutaActualizada;
            }
        }
        throw new RuntimeException("Ruta no encontrada");
    }

}
