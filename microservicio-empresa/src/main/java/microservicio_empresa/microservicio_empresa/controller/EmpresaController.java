package microservicio_empresa.microservicio_empresa.controller;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
@Tag(name = "Empresas", description = "Informacion respecto a las empresas")
public class EmpresaController {
    // Inyeccion
    @Autowired
    private EmpresaService empresa_service;

    // Obtiene lista de empresas
    @GetMapping
    @Operation(summary = "Obtener todas las empresas", description = "Obtiene una lista de todas las empresas en la base de datos")
    public List<Empresa> obtenerEmpresas() {
        return empresa_service.obtenerEmpresas();
    }

    // Busca empresa por id
    @GetMapping("/{idEmp}")
    public Empresa buscarPorId(@PathVariable Long idEmp) {
        return empresa_service.buscarPorId(idEmp);
    }

    // Guarda empresa, utilizando anotacion request body para mapear o buscar el
    // objeto empresa
    @PostMapping
    public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
        return empresa_service.guardarEmpresa(empresa);
    }

    // Elimina empresa, utilizando anotacion path variable para capturar el id y
    // pasarlo como parametro
    @DeleteMapping({ "/{idEmp}" })
    public String elimarEmpresaPorId(@PathVariable Long idEmp) {
        return empresa_service.eliminarEmpresaPorId(idEmp);
    }

    // Actualiza empresa, utilizando anotacion path variable para buscar el id
    // y request body para mapear o buscar el objeto empresa
    @PutMapping("/{idEmp}")
    public Empresa actualizarEmpresa(@PathVariable Long idEmp, @RequestBody Empresa empresa) {
        return empresa_service.actualizarEmpresa(idEmp, empresa);
    }

}
