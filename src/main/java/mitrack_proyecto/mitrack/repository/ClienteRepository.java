package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Cliente;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository

public class ClienteRepository {
    //CREACION DE LISTA PARA CLIENTES
    private List<Cliente> lista_clientes = new ArrayList<>();

    //DATOS DE CLIENTES
    public ClienteRepository() {
        lista_clientes.add(new Cliente(1, "Juan", "López", 99999999, "9", 912345678, "", ""));
        lista_clientes.add(new Cliente(2, "Pedro", "Tapia", 11111111, "1", 923456781, "", ""));
        lista_clientes.add(new Cliente(3, "Carlos",  "Jara",  12345678, "k", 944996666, "", ""));
    }

    //DEVUELVE LISTA DE CLIENTES
    public List<Cliente> obtener_clientes() {
        return lista_clientes;
    }

    //BUSCAR CLIENTE POR ID
    public Cliente buscar_por_id(int id) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.getId_cli() == id) {
                return cliente;
            }
        }
        return null;
    }

    //BUSCAR POR NOMBRE
    public Cliente buscar_por_autor(String nombre_cli) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.getNombre_cli().equals(nombre_cli)) {
                return cliente;
            }
        }
        return null;
    }

    //GUARDAR CLIENTE Y RETORNA

    public Cliente guardar_cliente(Cliente cli) {
    lista_clientes.add(cli);
    return cli;
    }

    //ELIMINAR CLIENTE

    public void eliminar_cliente(int id) {
        Cliente cliente = buscar_por_id(id);
        if (cliente != null) {
            lista_clientes.remove(cliente);
        }
    }

    //ACTUALIZAR CLIENTE

    public Cliente actualizar_cliente(Cliente cli) {
        int id = 0;
        int idPosicion = 0;

        //REPASO DE LA LISTA COMENZANDO DESDE LA POSICION 0 EN ID_CLIENTE
        for (int i = 0; i < lista_clientes.size(); i++) {
            if (lista_clientes.get(i).getId_cli() == cli.getId_cli()) {
                id = cli.getId_cli();
                idPosicion = i;
            }
        }

        //SETEA DATOS NUEVOS A UNA LISTA NUEVA
        Cliente cliente1 = new Cliente();
        cliente1.setId_cli(id);
        cliente1.setNombre_cli(cli.getNombre_cli());
        cliente1.setApellido_cli(cli.getApellido_cli());
        cliente1.setRun_cli(cli.getRun_cli());
        cliente1.setDv_cli(cli.getDv_cli());
        cliente1.setTel_cli(cli.getTel_cli());
        cliente1.setOrigen_cli(cli.getOrigen_cli());
        cliente1.setDestino_cli(cli.getDestino_cli());

        lista_clientes.set(idPosicion, cliente1);
        return cliente1;
    }

}
