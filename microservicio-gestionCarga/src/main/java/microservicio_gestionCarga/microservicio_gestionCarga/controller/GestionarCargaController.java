package microservicio_gestionCarga.microservicio_gestionCarga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GestionarCarga;
import microservicio_gestionCarga.microservicio_gestionCarga.services.GestionarCargaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/gestionarcarga")
public class GestionarCargaController {
    @Autowired
    private GestionarCargaService gestionarCargaService;

    @GetMapping
    public List<GestionarCarga> obtenerCargas() {
        return gestionarCargaService.obtenerCargas();
    }

    @GetMapping("/{id}")
    public GestionarCarga buscarPorId(@PathVariable Long id) {
        return gestionarCargaService.buscarPorId(id);
    }

    @PostMapping
    public GestionarCarga guardar(@RequestBody GestionarCarga gestionarCarga) {
        return gestionarCargaService.guardar(gestionarCarga);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        return gestionarCargaService.eliminarPorId(id);
    }

    @PutMapping("/{id}")
    public GestionarCarga actualizarPorId(@PathVariable Long id, @RequestBody GestionarCarga gestionarCarga) {
        gestionarCarga.setId_carga(id);
        return gestionarCargaService.actualizarPorId(gestionarCarga);
    }

}
