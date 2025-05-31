package microservicio_GestionPago.microservicio_GestionPago.controller;
import microservicio_GestionPago.microservicio_GestionPago.model.Pago;
import microservicio_GestionPago.microservicio_GestionPago.services.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//MAPEO DE PAGOS
@RestController
@RequestMapping("/api/v1/pagos")

public class PagoController {

    // VARIABLE PARA EL SERVICE
    @Autowired
    private PagoService pagoService;

    // METODO GET PARA OBTENER LISTA DE PAGOS
    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.obtenerPagos();
    }

    // METODO POST PARA AGREGAR UN PAGO
    @PostMapping
    public Pago agregarPago(@RequestBody Pago pago) {
        return pagoService.guardarPago(pago);
    }

    // METODO GET PARA BUSCAR EL PAGO POR TIPO
    @GetMapping("/{tipo}")
    public Pago buscarTipo(@PathVariable String tipo) {
        return pagoService.buscarPorTipo(tipo);
    }

}
