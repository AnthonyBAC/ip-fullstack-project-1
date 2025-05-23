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
        listaClientes.add(new Cliente(1, "Juan", "López", 99999999, "9", 912345678, "", ""));
        listaClientes.add(new Cliente(2, "Pedro", "Tapia", 11111111, "1", 923456781, "", ""));
        listaClientes.add(new Cliente(3, "Carlos",  "Jara",  12345678, "k", 944996666, "", ""));
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
    public Cliente buscarPorNombre(String nombreCli) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombreCli().equals(nombreCli)) {
                return cliente;
            }
        }
        return null;
    }

    //GUARDAR CLIENTE Y RETORNA

    public Cliente guardarCliente(Cliente cli) {
    listaClientes.add(cli);
    return cli;
    }

    //ELIMINAR CLIENTE

    public void eliminarCliente(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            listaClientes.remove(cliente);
        }
    }

    //ACTUALIZAR CLIENTE

    public Cliente actualizarCliente(Cliente cli) {
        int id = 0;
        int idPosicion = 0;

        //REPASO DE LA LISTA COMENZANDO DESDE LA POSICION 0 EN ID_CLIENTE
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdCli() == cli.getIdCli()) {
                id = cli.getIdCli();
                idPosicion = i;
            }
        }

        //SETEA DATOS NUEVOS A UNA LISTA NUEVA
        Cliente cliente1 = new Cliente();
        cliente1.setIdCli(id);
        cliente1.setNombreCli(cli.getNombreCli());
        cliente1.setApellidoCli(cli.getApellidoCli());
        cliente1.setRunCli(cli.getRunCli());
        cliente1.setDvCli(cli.getDvCli());
        cliente1.setTelCli(cli.getTelCli());
        cliente1.setOrigenCli(cli.getOrigenCli());
        cliente1.setDestinoCli(cli.getDestinoCli());

        listaClientes.set(idPosicion, cliente1);
        return cliente1;
    }

}
