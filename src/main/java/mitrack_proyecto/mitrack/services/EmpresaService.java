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

    // Metodo para obtener lista de empresas
    // Retorna lista de empresas
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.obtenerEmpresas();
    }

    // Metodo para buscar empresa por id
    // Retorna empresa si se encuentra, sino lanza excepcion
    public Empresa buscarPorId(int id_emp) {
        Empresa empresa = empresaRepository.buscarPorId(id_emp);
        if (empresa == null) {
            throw new RuntimeException("Empresa no encontrada");
        }
        return empresa;
    }

    // Metodo para buscar empresa por nombre
    // Retorna empresa si se encuentra, sino lanza excepcion
    public Empresa buscarPorNombre(String nombre_emp) {
        Empresa empresa = empresaRepository.buscarPorNombre(nombre_emp);
        if (empresa == null) {
            throw new RuntimeException("Empresa no encontrada");
        }
        return empresa;
    }

    // Metodo para guardar empresa
    // Retorna empresa guardada
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.guardar(empresa);
    }

    // Metodo para eliminar empresa por id
    // Retorna mensaje de confirmacion si se elimina, sino lanza excepcion
    public String eliminarEmpresaPorId(int id_emp) {
        boolean empresa = empresaRepository.eliminar(id_emp);
        if (!empresa) {
            throw new RuntimeException("No se encontró empresa para eliminar");
        }
        return "Empresa eliminada exitosamente";
    }

    // Metodo para actualizar empresa
    // Retorna empresa actualizada
    public Empresa actualizarEmpresa(Empresa empresaActualizada) {
        return empresaRepository.actualizar(empresaActualizada);
    }

}
