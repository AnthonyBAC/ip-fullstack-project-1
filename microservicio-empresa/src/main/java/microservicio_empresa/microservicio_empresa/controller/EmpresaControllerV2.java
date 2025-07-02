package microservicio_empresa.microservicio_empresa.controller;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.services.EmpresaService;
import microservicio_empresa.microservicio_empresa.assembler.EmpresaModelAssembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/empresa")
public class EmpresaControllerV2 {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaModelAssembler assembler;

    // Obtener todas las empresas
    @GetMapping
    public CollectionModel<EntityModel<Empresa>> obtenerEmpresas() {
        List<EntityModel<Empresa>> empresas = empresaService.obtenerEmpresas()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(empresas,
                linkTo(methodOn(EmpresaControllerV2.class).obtenerEmpresas()).withSelfRel());
    }

    // Buscar empresa por ID
    @GetMapping("/{idEmp}")
    public EntityModel<Empresa> buscarPorId(
            @PathVariable Long idEmp) {
        Empresa empresa = empresaService.buscarPorId(idEmp);
        return assembler.toModel(empresa);
    }

    // Guardar nueva empresa
    @PostMapping
    public EntityModel<Empresa> guardarEmpresa(@RequestBody Empresa empresa) {
        Empresa nueva = empresaService.guardarEmpresa(empresa);
        return assembler.toModel(nueva);
    }

    // Eliminar empresa por ID
    @DeleteMapping("/{idEmp}")
    public String eliminarEmpresaPorId(
            @PathVariable Long idEmp) {
        return empresaService.eliminarEmpresaPorId(idEmp);
    }

    // Actualizar empresa
    @PutMapping("/{idEmp}")
    public EntityModel<Empresa> actualizarEmpresa(
            @PathVariable Long idEmp,
            @RequestBody Empresa empresa) {
        Empresa actualizada = empresaService.actualizarEmpresa(idEmp, empresa);
        return assembler.toModel(actualizada);
    }

}
