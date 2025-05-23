package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Empresa;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    private List<Empresa> listaEmpresas;

    public EmpresaRepository() {
        this.listaEmpresas = new ArrayList<>();
    }

    public List<Empresa> obtenerEmpresas() {
        return listaEmpresas;
    }

    public Empresa guardar(Empresa empresa) {
        listaEmpresas.add(empresa);
        return empresa;
    }

    public boolean eliminar(int id_emp) {
        return listaEmpresas.removeIf(empresa -> empresa.getId_emp() == id_emp);
    }

    public Empresa buscarPorId(int id_emp) {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getId_emp() == id_emp) {
                return empresa;
            }
        }
        return null;
    }

    public Empresa buscarPorNombre(String nombre_emp) {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getNombre_emp().equals(nombre_emp)) {
                return empresa;
            }
        }
        return null;
    }

    public Empresa actualizar(Empresa empresaActualizada) {
        for (int i = 0; i < listaEmpresas.size(); i++) {
            if (empresaActualizada.getId_emp().equals(listaEmpresas.get(i).getId_emp())) {
                listaEmpresas.set(i, empresaActualizada);
                return empresaActualizada;
            }
        }
        throw new RuntimeException("Empresa no encontrada");
    }

}