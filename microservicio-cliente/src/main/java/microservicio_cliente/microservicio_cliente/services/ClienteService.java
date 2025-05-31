package microservicio_cliente.microservicio_cliente.services;

import microservicio_cliente.microservicio_cliente.model.Cliente;
import microservicio_cliente.microservicio_cliente.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    // VARIABLE PARA EL REPOSITORIO
    @Autowired
    private ClienteRepository clienteRepository;

    // OBTENER LISTA DE CLIENTES
    public List<Cliente> getCliente() {
        return clienteRepository.obtenerClientes();
    }

    // AGREGAR CLIENTE
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.guardarCliente(cliente);
    }

    // BUSCAR CLIENTE POR ID
    public Cliente getIdCliente(int id) {
        return clienteRepository.buscarPorId(id);
    }

    // ACTUALIZAR CLIENTE
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.actualizarCliente(cliente);
    }

    // ELIMINAR CLIENTE
    public String deleteCliente(int id) {
        clienteRepository.eliminarCliente(id);
        return "Cliente eliminado";
    }

}
