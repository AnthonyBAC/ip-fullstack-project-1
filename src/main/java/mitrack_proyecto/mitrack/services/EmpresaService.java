package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.repository.EmpresaRepository;
import mitrack_proyecto.mitrack.model.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.obtenerEmpresas();
    }

    public Empresa buscarPorId(int id_emp) {
        Empresa empresa = empresaRepository.buscarPorId(id_emp);
        if (empresa == null) {
            throw new RuntimeException("Empresa no encontrada");
        }
        return empresa;
    }

    public Empresa buscarPorNombre(String nombre_emp) {
        Empresa empresa = empresaRepository.buscarPorNombre(nombre_emp);
        if (empresa == null) {
            throw new RuntimeException("Empresa no encontrada");
        }
        return empresa;
    }

    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.guardar(empresa);
    }

    public String eliminarEmpresaPorId(int id_emp) {
        boolean eliminado = empresaRepository.eliminar(id_emp);
        if (!eliminado) {
            throw new RuntimeException("No se encontró empresa para eliminar");
        }
        return "Empresa eliminada exitosamente";
    }

    public Empresa actualizarEmpresa(Empresa empresaActualizada) {
        return empresaRepository.actualizar(empresaActualizada);
    }

}
