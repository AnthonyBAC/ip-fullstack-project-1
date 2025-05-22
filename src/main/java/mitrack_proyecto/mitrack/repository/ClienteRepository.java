package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Cliente;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository

public class ClienteRepository {
    //CREACION DE LISTA PARA CLIENTES
    private List<Cliente> listaClientes = new ArrayList<>();
    //DATOS DE CLIENTES
    public ClienteRepository() {
        listaClientes.add(new Cliente(1, "Juan López", 99999999, "9", 912345678, "jlopez@gmail.com", "", ""));
        listaClientes.add(new Cliente(2, "Pedro Tapia", 11111111, "1", 923456781, "ptapia@gmail.com", "", ""));
        listaClientes.add(new Cliente(3, "Carlos Jara", 12345678, "k", 923456781, "ptapia@gmail.com", "", ""));
    }

    //DEVUELVE LISTA DE CLIENTES
    public List<Cliente> obtenerClientes() {
        return listaClientes;
    }

    //BUSCAR CLIENTE POR ID
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCli() == id) {
                return cliente;
            }
        }
        return null;
    }

    //BUSCAR POR NOMBRE
    public Cliente buscarPorAutor(String autor) {
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }
}
