package microservicio_empresa.microservicio_empresa.services;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Obtener todas las empresas
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }

    // Buscar por ID
    public Empresa buscarPorId(Long idEmp) {
        return empresaRepository.findById(idEmp)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    // Guardar empresa
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Eliminar por ID
    public String eliminarEmpresaPorId(Long idEmp) {
        if (!empresaRepository.existsById(idEmp)) {
            throw new RuntimeException("No se encontró empresa para eliminar");
        }
        empresaRepository.deleteById(idEmp);
        return "Empresa eliminada exitosamente";
    }

    // Actualizar empresa
    public Empresa actualizarEmpresa(Long idEmp, Empresa empresaActualizada) {
        if (!empresaActualizada.getIdEmp().equals(idEmp)) {
            throw new RuntimeException("No se permite modificar el ID de la empresa.");
        }
        if (!empresaRepository.existsById(idEmp)) {
            throw new RuntimeException("Empresa no encontrada para actualizar.");
        }
        return empresaRepository.save(empresaActualizada);
    }
}
