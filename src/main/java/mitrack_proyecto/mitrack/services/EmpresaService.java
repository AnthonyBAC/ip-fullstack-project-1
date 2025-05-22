package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.repository.EmpresaRepository;
import mitrack_proyecto.mitrack.model.Empresa;
import mitrack_proyecto.mitrack.model.Usuario;
import mitrack_proyecto.mitrack.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    // Inyeccion de repositorio para utilizar sus metodos
    @Autowired
    private EmpresaRepository empresa_repository;

    @Autowired
    private AuthService authService;

    // Llamando metodos desde repository
    public List<Empresa> obtenerEmpresas() {
        return empresa_repository.obtenerEmpresas();
    }

    public Empresa buscarPorId(int id_emp, Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return empresa_repository.buscarPorId(id_emp);
    }

    public Empresa buscarPorNombre(String nombre_emp) {
        return empresa_repository.buscarPorNombre(nombre_emp);
    }

    public Empresa guardarEmpresa(Empresa empresa) {
        return empresa_repository.guardarEmpresa(empresa);
    }

    public String eliminarEmpresaPorId(int id_emp) {
        empresa_repository.eliminarEmpresaPorId(id_emp);
        return "Empresa eliminada existosamente";
    }

    public Empresa actualizarEmpresa(Empresa empresa) {
        return empresa_repository.actualizarEmpresa(empresa);
    }

}
