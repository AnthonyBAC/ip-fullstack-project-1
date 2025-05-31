package microservicio_Vehiculo.microservicio_Vehiculo.repository;

import org.springframework.stereotype.Repository;
import microservicio_Vehiculo.microservicio_Vehiculo.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculoRepository {

    private final List<Vehiculo> listaVehiculos = new ArrayList<>();

    // Retorna lista de vehiculos
    public List<Vehiculo> obtenerVehiculos() {
        return listaVehiculos;
    }

    // Guarda vehiculo
    // utilizando .add para agregar vehiculo a la lista
    public Vehiculo guardar(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
        return vehiculo;
    }

    // Elimina vehiculo
    // utilizando .removeIf para eliminar vehiculo de la lista
    public boolean eliminarPorId(Long id) {
        return listaVehiculos.removeIf(vehiculo -> vehiculo.getId_vehiculo().equals(id));
    }

    // Busca vehiculo por id
    // utilizando
    // .stream para buscar vehiculo en la lista
    // .filter para filtrar vehiculo por id
    // .findFirst para obtener el primer vehiculo encontrado
    // .orElse para devolver null si no se encuentra el vehiculo
    public Vehiculo buscarPorId(Long id) {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getId_vehiculo().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Busca vehiculo por patente
    public Vehiculo buscarPorPatente(String patente) {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }

    // Actualiza vehiculo
    // utilizando un bucle for para recorrer la lista de vehiculos
    // utilizando .set para actualizar el vehiculo encontrado
    public Vehiculo actualizarPorId(Vehiculo vehiculoActualizado) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (vehiculoActualizado.getId_vehiculo().equals(listaVehiculos.get(i).getId_vehiculo())) {
                listaVehiculos.set(i, vehiculoActualizado);
                return vehiculoActualizado;
            }
        }
        throw new RuntimeException("Vehiculo no encontrado");
    }

}
