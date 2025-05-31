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
    // Retorna cliente si se encuentra, sino lanza excepcion
    public Cliente buscarPorId(int id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        return cliente;
    }

    // ACTUALIZAR CLIENTE
     public Cliente actualizarCliente(int idCli, Cliente clienteActualizado) {
        if (!clienteActualizado.getIdCli().equals((long) idCli)) {
            throw new RuntimeException("No se permite modificar el ID del cliente.");
        }
        return clienteRepository.actualizarCliente(clienteActualizado);
    }

    // ELIMINAR CLIENTE
    // Retorna mensaje de confirmacion si se elimina, sino lanza excepcion
    public String eliminarClientePorId(int id) {
        boolean cliente = clienteRepository.eliminarCliente(id);
        if (!cliente) {
            throw new RuntimeException("No se encontró cliente para eliminar");
        }
        return "Cliente eliminado exitosamente";
    }
}
