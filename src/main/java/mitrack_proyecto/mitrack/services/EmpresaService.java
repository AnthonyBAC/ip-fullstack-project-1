package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.repository.EmpresaRepository;
import mitrack_proyecto.mitrack.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {
    // Inyeccion de dependencia
    @Autowired
    // Inyeccion de dependencia
    private EmpresaRepository empresaRepository;

    // Obtiene todas las empresas llamando al repository
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.obtenerEmpresas();
    }

    // Busca una empresa por su ID llamando al repository
    public Empresa buscarPorId(int id_emp) {
        return empresaRepository.buscarPorId(id_emp);
    }

    // Busca una empresa por su nombre llamando al repository
    public Empresa buscarPorNombre(String nombre_emp) {
        return empresaRepository.buscarPorNombre(nombre_emp);
    }

    // Guarda una empresa llamando al repository
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.guardarEmpresa(empresa);
    }

    // Elimina una empresa llamando al repository
    public void eliminarEmpresa(int id_emp) {
        empresaRepository.eliminarEmpresa(id_emp);
    }

    // Actualiza una empresa llamando al repository
    public Empresa actualizar_empresa(Empresa empresa) {
        return empresaRepository.actualizar_empresa(empresa);
    }
}
