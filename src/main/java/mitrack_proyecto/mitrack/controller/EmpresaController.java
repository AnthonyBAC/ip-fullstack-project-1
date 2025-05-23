package mitrack_proyecto.mitrack.controller;

import mitrack_proyecto.mitrack.model.Empresa;
import mitrack_proyecto.mitrack.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresa_service;

    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresa_service.obtenerEmpresas();
    }

    @GetMapping("{id}")
    public Empresa buscarPorId(@PathVariable int id_emp) {
        return empresa_service.buscarPorId(id_emp);
    }

    @GetMapping("/empresa/{nombre}")
    public Empresa buscarEmpresaPorNombre(@PathVariable("nombre") String nombre) {
        return empresa_service.buscarPorNombre(nombre);
    }

    @PostMapping
    public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
        return empresa_service.guardarEmpresa(empresa);
    }

    @DeleteMapping({ "id" })
    public String elimarEmpresaPorId(@PathVariable int id_emp) {
        return empresa_service.eliminarEmpresaPorId(id_emp);
    }

    @PutMapping({ "id" })
    public Empresa actualizarEmpresa(@PathVariable int id_emp, @RequestBody Empresa empresa) {
        return empresa_service.actualizarEmpresa(empresa);
    }

}
