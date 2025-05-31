package mitrack_proyecto.mitrack.gestionarCarga.repository;

import org.springframework.stereotype.Repository;

import mitrack_proyecto.mitrack.gestionarCarga.model.GestionarCarga;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GestionarCargaRepository {

    // Genera lista de cargas
    private final List<GestionarCarga> listaCargas = new ArrayList<>();

    // Retorna lista de cargas
    public List<GestionarCarga> obtenerCargas() {
        return listaCargas;
    }

    // Guarda carga
    // utilizando .add para agregar carga a la lista
    public GestionarCarga guardar(GestionarCarga carga) {
        listaCargas.add(carga);
        return carga;
    }

    // Elimina carga
    // utilizando .removeIf para eliminar carga de la lista
    public boolean eliminarPorId(Long id_carga) {
        return listaCargas.removeIf(carga -> carga.getId_carga().equals(id_carga));
    }

    // Busca carga por id
    // utilizando
    // .stream para buscar carga en la lista
    // .filter para filtrar carga por id
    // .findFirst para obtener el primer carga encontrado
    // .orElse para devolver null si no se encuentra la carga
    public GestionarCarga buscarPorId(Long id_carga) {
        return listaCargas.stream()
                .filter(carga -> carga.getId_carga().equals(id_carga))
                .findFirst()
                .orElse(null);
    }

    // Actualiza carga
    // utilizando un bucle for para recorrer la lista de cargas
    // utilizando .set para actualizar la carga encontrada
    public GestionarCarga actualizarPorId(GestionarCarga cargaActualizada) {
        for (int i = 0; i < listaCargas.size(); i++) {
            if (cargaActualizada.getId_carga().equals(listaCargas.get(i).getId_carga())) {
                listaCargas.set(i, cargaActualizada);
                return cargaActualizada;
            }
        }
        throw new RuntimeException("Carga no encontrada");
    }

}
