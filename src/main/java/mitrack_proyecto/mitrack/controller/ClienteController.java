package mitrack_proyecto.mitrack.controller;

import mitrack_proyecto.mitrack.model.Cliente;
import mitrack_proyecto.mitrack.model.Usuario;
import mitrack_proyecto.mitrack.services.AuthService;
import mitrack_proyecto.mitrack.services.ClienteService;

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

    @Autowired
    private AuthService authService;

    // METODO GET PARA OBTENER LISTA DE CLIENTES
    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.getCliente();
    }

    // METODO POST PARA AGREGAR UN CLIENTE
    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return clienteService.saveCliente(cliente, usuarioActual);
    }

    // METODO GET PARA BUSCAR EL CLIENTE POR ID
    @GetMapping("{id}")
    public Cliente buscarCliente(@PathVariable int idCli) {
        return clienteService.getIdCliente(idCli);
    }

    // METODO PUT PARA ACTUALIZAR CLIENTE
    @PutMapping
    public Cliente actualizarCliente(@PathVariable int idCli, @RequestBody Cliente cliente, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return clienteService.updateCliente(cliente, usuarioActual);
    }

    // METODO DELETE PARA ELIMINAR CLIENTE
    @DeleteMapping
    public String eliminarCliente(@PathVariable int idCli, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return clienteService.deleteCliente(idCli, usuarioActual);
    }
}
