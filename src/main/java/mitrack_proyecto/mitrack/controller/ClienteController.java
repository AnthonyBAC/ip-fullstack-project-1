package mitrack_proyecto.mitrack.controller;

import mitrack_proyecto.mitrack.model.Cliente;
import mitrack_proyecto.mitrack.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MAPEO DE CLIENTES
@RestController
@RequestMapping("/api/v1/empresas/{id_emp}")
public class ClienteController {

    //VARIABLE PARA EL SERVICE
    @Autowired
    private ClienteService cliente_service;

    //METODO GET PARA OBTENER LISTA DE CLIENTES
    @GetMapping
    public List<Cliente> listar_cliente() {
        return cliente_service.get_cliente();
    }

    //METODO POST PARA AGREGAR UN CLIENTE
    @PostMapping
    public Cliente agregar_cliente(@RequestBody Cliente cliente) {
        return cliente_service.save_cliente(cliente);
    }

    //METODO GET PARA BUSCAR EL CLIENTE POR ID
    @GetMapping("{id}")
    public Cliente buscar_cliente(@PathVariable int id_cli) {
        return cliente_service.get_id_cliente(id_cli);
    }

    //METODO PUT PARA ACTUALIZAR CLIENTE
    @PutMapping
    public Cliente actualizar_cliente(@PathVariable int id_cli, @RequestBody Cliente cliente) {
        return cliente_service.update_cliente(cliente);
    }

    //METODO DELETE PARA ELIMINAR CLIENTE
    @DeleteMapping
    public String eliminar_cliente(@PathVariable int id_cli) {
        return cliente_service.delete_cliente(id_cli);
    }
}
