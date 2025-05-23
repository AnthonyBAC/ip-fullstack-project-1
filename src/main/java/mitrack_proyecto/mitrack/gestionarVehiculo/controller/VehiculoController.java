package mitrack_proyecto.mitrack.gestionarVehiculo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import mitrack_proyecto.mitrack.gestionarVehiculo.services.VehiculoService;
import mitrack_proyecto.mitrack.gestionarVehiculo.model.Vehiculo;

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
@RequestMapping("/api/v1/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculo_service;

    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculo_service.obtenerVehiculos();
    }

    @GetMapping("/{id}")
    public Vehiculo buscarPorId(@PathVariable Long id_vehiculo) {
        return vehiculo_service.buscarPorId(id_vehiculo);
    }

    @GetMapping("/vehiculo/{patente}")
    public Vehiculo buscarVehiculoPorPatente(@PathVariable("patente") String patente) {
        return vehiculo_service.buscarPorPatente(patente);
    }

    @PostMapping
    public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculo_service.guardarVehiculo(vehiculo);
    }

    @DeleteMapping({ "/{id}" })
    public String eliminarVehiculoPorId(@PathVariable Long id_vehiculo) {
        return vehiculo_service.eliminarVehiculoPorId(id_vehiculo);
    }

    @PutMapping({ "/{id}" })
    public Vehiculo actualizarVehiculo(@PathVariable Long id_vehiculo, @RequestBody Vehiculo vehiculo) {
        vehiculo.setId_vehiculo(id_vehiculo);
        return vehiculo_service.actualizarVehiculo(vehiculo);
    }

}
