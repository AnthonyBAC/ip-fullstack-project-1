package microservicio_cliente.microservicio_cliente.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import microservicio_cliente.microservicio_cliente.model.Cliente;

@Repository

public class ClienteRepository {
    // CREACION DE LISTA PARA CLIENTES
    private List<Cliente> listaClientes = new ArrayList<>();

    // DATOS DE CLIENTES
    public ClienteRepository() {
        listaClientes.add(new Cliente(1L, "Juan", "López", 99999999, "9", 912345678, "", ""));
        listaClientes.add(new Cliente(2L, "Pedro", "Tapia", 11111111, "1", 923456781, "", ""));
        listaClientes.add(new Cliente(3L, "Carlos", "Jara", 12345678, "k", 944996666, "", ""));
    }

    // DEVUELVE LISTA DE CLIENTES
    public List<Cliente> obtenerClientes() {
        return listaClientes;
    }

    // BUSCAR CLIENTE POR ID
    public Cliente buscarPorId(int id) {
        return listaClientes.stream()
                .filter(cliente -> cliente.getIdCli() == id)
                .findFirst()
                .orElse(null);
    }

    // BUSCAR POR NOMBRE
    public Cliente buscarPorNombre(String nombreCli) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombreCli().equals(nombreCli)) {
                return cliente;
            }
        }
        return null;
    }

    // GUARDAR CLIENTE Y RETORNA

    public Cliente guardarCliente(Cliente cli) {
        listaClientes.add(cli);
        return cli;
    }

    // ELIMINAR CLIENTE
    public boolean eliminarCliente(int id) {
        return listaClientes.removeIf(cliente -> cliente.getIdCli() == id);
    }

    // ACTUALIZAR CLIENTE
    public Cliente actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (clienteActualizado.getIdCli().equals(listaClientes.get(i).getIdCli())) {
                listaClientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        throw new RuntimeException("Cliente no encontrado");
    }


}
