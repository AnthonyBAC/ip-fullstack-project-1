package mitrack_proyecto.mitrack.gestionarCliente.services;

import mitrack_proyecto.mitrack.gestionarCliente.model.Cliente;
import mitrack_proyecto.mitrack.gestionarCliente.repository.ClienteRepository;
import mitrack_proyecto.mitrack.gestionarUsuarios.model.Usuario;
import mitrack_proyecto.mitrack.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    // VARIABLE PARA EL REPOSITORIO
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AuthService authService;

    // OBTENER LISTA DE CLIENTES
    public List<Cliente> getCliente() {
        return clienteRepository.obtenerClientes();
    }

    // AGREGAR CLIENTE
    public Cliente saveCliente(Cliente cliente, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return clienteRepository.guardarCliente(cliente);
    }

    // BUSCAR CLIENTE POR ID
    public Cliente getIdCliente(int id) {
        return clienteRepository.buscarPorId(id);
    }

    // ACTUALIZAR CLIENTE
    public Cliente updateCliente(Cliente cliente, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return clienteRepository.actualizarCliente(cliente);
    }

    // ELIMINAR CLIENTE
    public String deleteCliente(int id, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        clienteRepository.eliminarCliente(id);
        return "Cliente eliminado";
    }

}
