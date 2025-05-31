package microservicio_gestionCarga.microservicio_gestionCarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GuiaCliente;
import microservicio_gestionCarga.microservicio_gestionCarga.services.GuiaClienteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/guiacliente")
public class GuiaClienteController {
    @Autowired
    private GuiaClienteService guiaClienteService;

    @GetMapping
    public List<GuiaCliente> obtenerGuias() {
        return guiaClienteService.obtenerGuias();
    }

    @GetMapping("/{id}")
    public GuiaCliente buscarPorId(@PathVariable Long id_guia) {
        return guiaClienteService.buscarPorId(id_guia);
    }

    @PostMapping
    public GuiaCliente guardarGuia(@RequestBody GuiaCliente guiaCliente) {
        return guiaClienteService.guardarGuia(guiaCliente);
    }

}
