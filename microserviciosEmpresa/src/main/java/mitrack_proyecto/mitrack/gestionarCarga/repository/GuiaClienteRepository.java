package mitrack_proyecto.mitrack.gestionarCarga.repository;

import org.springframework.stereotype.Repository;

import mitrack_proyecto.mitrack.gestionarCarga.model.GuiaCliente;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuiaClienteRepository {

    private final List<GuiaCliente> listaGuias = new ArrayList<>();

    // Retorna lista de guias
    public List<GuiaCliente> obtenerGuias() {
        return listaGuias;
    }

    // Guarda guia
    // utilizando .add para agregar guia a la lista
    public GuiaCliente guardar(GuiaCliente guia) {
        listaGuias.add(guia);
        return guia;
    }

    // Buscar guia por id
    // utilizando
    // .stream para buscar guia en la lista
    // .filter para filtrar guia por id
    // .findFirst para obtenerl la primera guia encontrada
    // .orElse para devolver null si no se encuentra la guia
    public GuiaCliente buscarPorId(Long id) {
        return listaGuias.stream()
                .filter(guia -> guia.getId_guia().equals(id))
                .findFirst()
                .orElse(null);
    }

}
