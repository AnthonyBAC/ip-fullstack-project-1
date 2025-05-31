package microservicio_Ruta.microservicio_Ruta.controller;

import microservicio_Ruta.microservicio_Ruta.model.Ruta;
import microservicio_Ruta.microservicio_Ruta.services.RutaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ruta")
public class RutaController {
    @Autowired
    private RutaService ruta_service;

    @GetMapping
    public List<Ruta> obtenerRutas() {
        return ruta_service.obtenerRutas();
    }

    @GetMapping("/{id}")
    public Ruta buscarPorId(@PathVariable Long id_ruta) {
        return ruta_service.buscarPorId(id_ruta);
    }

    @GetMapping("/ruta/{origen}")
    public Ruta buscarRutaPorOrigen(@PathVariable("origen") String origen) {
        return ruta_service.buscarPorOrigen(origen);
    }

    @PostMapping
    public Ruta guardarRuta(@RequestBody Ruta ruta) {
        return ruta_service.guardarRuta(ruta);
    }

    @DeleteMapping({ "/{id}" })
    public String eliminarRutaPorId(@PathVariable Long id_ruta) {
        return ruta_service.eliminarRutaPorId(id_ruta);
    }

    @PutMapping({ "/{id}" })
    public Ruta actualizarRuta(@PathVariable Long id_ruta, @RequestBody Ruta ruta) {
        ruta.setId_ruta(id_ruta);
        return ruta_service.actualizarRuta(ruta);
    }
}
