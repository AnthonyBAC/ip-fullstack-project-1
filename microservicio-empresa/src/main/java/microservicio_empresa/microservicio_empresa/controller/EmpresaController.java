package microservicio_empresa.microservicio_empresa.controller;

import microservicio_empresa.microservicio_empresa.dto.EmpresaRequest;
import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
@Tag(name = "Empresas", description = "Información respecto a las empresas")
public class EmpresaController {
        // Inyeccion
        @Autowired
        private EmpresaService empresa_service;

        // Obtiene lista de empresas
        @GetMapping
        @Operation(summary = "Obtener todas las empresas", description = "Obtiene una lista de todas las empresas en la base de datos")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class, type = "array"))),
                        @ApiResponse(responseCode = "405", description = "Operación no exitosa")
        })
        public List<Empresa> obtenerEmpresas() {
                return empresa_service.obtenerEmpresas();
        }

        // Busca empresa por id
        @GetMapping("/{idEmp}")
        @Operation(summary = "Buscar empresa por ID", description = "Te permite buscar una empresa con un ID específico")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Empresa encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))),
                        @ApiResponse(responseCode = "405", description = "Empresa no encontrada")
        })
        public Empresa buscarPorId(
                        @Parameter(description = "ID único de la empresa a buscar", required = true) @PathVariable Long idEmp) {
                return empresa_service.buscarPorId(idEmp);
        }

        // Guarda empresa, utilizando anotacion request body para mapear o buscar el
        // objeto empresa
        @PostMapping
        @Operation(summary = "Agregar/Guardar una empresa", description = "Permite ingresar una nueva empresa (sin ID) y guardarla en la base de datos.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Empresa guardada con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))),
                        @ApiResponse(responseCode = "405", description = "No se ejecutó la operación")
        })
        public Empresa guardarEmpresa(@RequestBody EmpresaRequest empresaRequest) {
                Empresa empresa = new Empresa();
                empresa.setNombreEmp(empresaRequest.getNombreEmp());
                empresa.setRutEmp(empresaRequest.getRutEmp());
                empresa.setDvEmp(empresaRequest.getDvEmp());
                empresa.setDirEmp(empresaRequest.getDirEmp());

                return empresa_service.guardarEmpresa(empresa);
        }

        // Elimina empresa, utilizando anotacion path variable para capturar el id y
        // pasarlo como parametro
        @DeleteMapping("/{idEmp}")
        @Operation(summary = "Eliminar empresa por ID", description = "Te permite eliminar empresa, se debe ingresar el respectivo ID de la empresa para poder eliminar")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Empresa eliminada con éxito"),
                        @ApiResponse(responseCode = "405", description = "No se ejecutó la eliminación de empresa")
        })
        public String elimarEmpresaPorId(
                        @Parameter(description = "ID único de la empresa a eliminar", required = true) @PathVariable Long idEmp) {
                return empresa_service.eliminarEmpresaPorId(idEmp);
        }

        // Actualiza empresa, utilizando anotacion path variable para buscar el id y
        // request body para mapear o buscar el objeto empresa
        @PutMapping("/{idEmp}")
        @Operation(summary = "Actualizar / Modificar empresa ya existente", description = "Te permite modificar empresa ya existente, se tiene que especificar ID")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Empresa modificada con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))),
                        @ApiResponse(responseCode = "405", description = "Empresa no se pudo modificar o no existe")
        })

        public Empresa actualizarEmpresa(
                        @Parameter(description = "ID único de la empresa a modificar", required = true) @PathVariable Long idEmp,
                        @RequestBody Empresa empresa) {
                return empresa_service.actualizarEmpresa(idEmp, empresa);
        }
}
