package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.repository.EmpresaRepository;
import mitrack_proyecto.mitrack.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    // Inyeccion de repositorio para utilizar sus metodos
    @Autowired
    private EmpresaRepository empresaRepository;

    // Llamando metodos desde repository
    public List<Empresa> getEmpresas() {
        return empresaRepository.obtener_empresas();
    }

    public Empresa buscar_por_id(int id_emp) {
        return empresaRepository.buscar_por_id(id_emp);
    }

    public Empresa buscar_por_nombre(String nombre_emp) {
        return empresaRepository.buscar_por_nombre(nombre_emp);
    }

    public Empresa guardar_empresa(Empresa empresa) {
        return empresaRepository.guardar_empresa(empresa);
    }

    public String eliminarEmpresa(int id_emp) {
        empresaRepository.eliminar_empresa(id_emp);
        return "Empresa eliminada existosamente";
    }

    public Empresa actualizarEmpresa(Empresa empresa) {
        return empresaRepository.actualizar_empresa(empresa);
    }

}
