package microservicio_empresa.microservicio_empresa.controller;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.services.EmpresaService;

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
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    // Inyeccion de servicio para utilizar sus metodos
    @Autowired
    private EmpresaService empresa_service;

    // Obtiene lista de empresas
    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresa_service.obtenerEmpresas();
    }

    // Busca empresa por id
    @GetMapping("/{id_emp}")
    public Empresa buscarPorId(@PathVariable int id_emp) {
        return empresa_service.buscarPorId(id_emp);
    }

    // Busca empresa por nombre
    @GetMapping("/nombre/{nombre}")
    public Empresa buscarEmpresaPorNombre(@PathVariable("nombre") String nombre) {
        return empresa_service.buscarPorNombre(nombre);
    }

    // Guarda empresa, utilizando anotacion request body para mapear o buscar el
    // objeto empresa
    @PostMapping
    public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
        return empresa_service.guardarEmpresa(empresa);
    }

    // Elimina empresa, utilizando anotacion path variable para capturar el id y
    // pasarlo como parametro
    @DeleteMapping({ "/{id_emp}" })
    public String elimarEmpresaPorId(@PathVariable int id_emp) {
        return empresa_service.eliminarEmpresaPorId(id_emp);
    }

    // Actualiza empresa, utilizando anotacion path variable para buscar el id
    // y request body para mapear o buscar el objeto empresa
    @PutMapping("/{id_emp}")
    public Empresa actualizarEmpresa(@PathVariable int id_emp, @RequestBody Empresa empresa) {
        return empresa_service.actualizarEmpresa(id_emp, empresa);
    }

}
