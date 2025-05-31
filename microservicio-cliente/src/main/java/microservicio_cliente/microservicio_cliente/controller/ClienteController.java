package microservicio_cliente.microservicio_cliente.controller;

import microservicio_cliente.microservicio_cliente.model.Cliente;
import microservicio_cliente.microservicio_cliente.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MAPEO DE CLIENTES
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    // VARIABLE PARA EL SERVICE
    @Autowired
    private ClienteService clienteService;

    // METODO GET PARA OBTENER LISTA DE CLIENTES
    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.getCliente();
    }

    // METODO POST PARA AGREGAR UN CLIENTE
    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    // METODO GET PARA BUSCAR EL CLIENTE POR ID
    @GetMapping("/{idCli}")
    public Cliente buscarCliente(@PathVariable int idCli) {
        return clienteService.buscarPorId(idCli);
    }

    // METODO PUT PARA ACTUALIZAR CLIENTE
    @PutMapping({ "/{idCli}" })
    public Cliente actualizarCliente(@PathVariable int idCli, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(idCli, cliente);
    }

    // METODO DELETE PARA ELIMINAR CLIENTE
    @DeleteMapping({ "/{idCli}" })
    public String eliminarCliente(@PathVariable int idCli) {
        return clienteService.eliminarClientePorId(idCli);
    }
}
