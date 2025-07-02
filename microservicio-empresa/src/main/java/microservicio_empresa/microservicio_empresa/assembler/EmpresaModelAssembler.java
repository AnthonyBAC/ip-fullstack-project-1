package microservicio_empresa.microservicio_empresa.assembler;

import microservicio_empresa.microservicio_empresa.controller.EmpresaControllerV2;
import microservicio_empresa.microservicio_empresa.model.Empresa;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EmpresaModelAssembler implements RepresentationModelAssembler<Empresa, EntityModel<Empresa>> {

    @Override
    @NonNull
    public EntityModel<Empresa> toModel(@NonNull Empresa empresa) {
        return EntityModel.of(empresa,
                linkTo(methodOn(EmpresaControllerV2.class).buscarPorId(empresa.getIdEmp())).withSelfRel(),
                linkTo(methodOn(EmpresaControllerV2.class).obtenerEmpresas()).withRel("empresas"));
    }
}
