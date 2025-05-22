package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Empresa;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    // Se crea una lista de empresas llamando el model Empresa
    // Guardando empresas en una lista variable (listaEmpresas)
    private List<Empresa> listaEmpresas = new ArrayList<>();

    // Devuelve lista de las empresas de la variable listaEmpresas
    public List<Empresa> obtenerEmpresas() {
        return listaEmpresas;
    }

    // Buscar empresa por ID
    // Recorre la lista de empresas de modelo Empresa, y hace una comparacion entre
    // el id de la empresa y el id que se le pasa por parametro
    public Empresa buscarPorId(int id_emp) {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getId_emp() == id_emp) {
                return empresa;
            }
        }
        return null;
    }

    // Buscar por nombre
    // Recorre la lista de empresas de modelo Empresa, y hace una comparacion entre
    // el nombre de la empresa y el nombre que se le pasa por parametro
    public Empresa buscarPorNombre(String nombre_emp) {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getNombre_emp().equals(nombre_emp)) {
                return empresa;
            }
        }
        return null;
    }

    // Guardar empresa
    // Crea una variable empresa y la agrega a la lista de empresas, utilizando
    // la entidad Empresa del model Empresa
    public Empresa guardarEmpresa(Empresa empresa) {
        listaEmpresas.add(empresa);
        return empresa;
    }

    // Eliminar empresa
    // Recorre la lista de empresas de modelo Empresa, y hace una comparacion entre
    // el id de la empresa y el id que se le pasa por parametro
    // Si encuentra la empresa, la elimina de la lista
    public void eliminarEmpresaPorId(int id_emp) {
        listaEmpresas.removeIf(empresa -> empresa.getId_emp() == id_emp);
    }

    // Modificar empresa
    // Busca la empresa por ID y la modifica
    // Recorre la lista de empresas de modelo Empresa, y hace una comparacion entre
    // el id de la empresa y el id que se le pasa por parametro
    // Si encuentra la empresa, la modifica
    public Empresa actualizarEmpresa(Empresa empresa) {
        Long id = 0L;
        int idPosicion = -1;

        for (int i = 0; i < listaEmpresas.size(); i++) {
            if (empresa.getId_emp() != null &&
                    empresa.getId_emp().equals(listaEmpresas.get(i).getId_emp())) {
                id = empresa.getId_emp();
                idPosicion = i;
                break;
            }
        }

        if (idPosicion == -1) {
            throw new RuntimeException("Empresa no encontrada");
        }

        Empresa empresa1 = new Empresa();
        empresa1.setId_emp(id);
        empresa1.setNombre_emp(empresa.getNombre_emp());
        empresa1.setRut_emp(empresa.getRut_emp());
        empresa1.setDv_emp(empresa.getDv_emp());
        empresa1.setDir_emp(empresa.getDir_emp());

        listaEmpresas.set(idPosicion, empresa1);
        return empresa1;
    }
}