package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.model.Cliente;
import mitrack_proyecto.mitrack.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    // VARIABLE PARA EL REPOSITORIO
    @Autowired
    private ClienteRepository cliente_repository;

    // OBTENER LISTA DE CLIENTES
    public List<Cliente> get_cliente() {
        return cliente_repository.obtener_clientes();
    }

    // AGREGAR CLIENTE
    public Cliente save_cliente(Cliente cliente) {
        return cliente_repository.guardar_cliente(cliente);
    }

    // BUSCAR CLIENTE POR ID
    public Cliente get_id_cliente(int id) {
        return cliente_repository.buscar_por_id(id);
    }

    // ACTUALIZAR CLIENTE
    public Cliente update_cliente(Cliente cliente) {
        return cliente_repository.actualizar_cliente(cliente);
    }

    // ELIMINAR CLIENTE
    public String delete_cliente(int id) {
        cliente_repository.eliminar_cliente(id);
        return "Cliente eliminado";
    }

}
