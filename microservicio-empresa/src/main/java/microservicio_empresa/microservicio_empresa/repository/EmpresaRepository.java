package microservicio_empresa.microservicio_empresa.repository;

import org.springframework.stereotype.Repository;

import microservicio_empresa.microservicio_empresa.model.Empresa;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    // Lista que almacena las empresas en memoria
    private final List<Empresa> listaEmpresas = new ArrayList<>();

    // Insertar datos en la lista
    public void insertarDatos() {
        listaEmpresas.add(new Empresa(1L, "Empresa 1", 12345678, 1, "Huechuraba, Ciudad Empresarial"));
        listaEmpresas.add(new Empresa(2L, "Empresa 2", 12345678, 2, "Santiago Centro"));
        listaEmpresas.add(new Empresa(3L, "Empresa 3", 12345678, 3, "Concepcion"));

    }

    // Retorna lista de empresas
    public List<Empresa> obtenerEmpresas() {
        return listaEmpresas;
    }

    // Guarda empresa
    // utilizando .add para agregar empresa a la lista
    public Empresa guardar(Empresa empresa) {
        listaEmpresas.add(empresa);
        return empresa;
    }

    // Elimina empresa
    // utilizando .removeIf para eliminar empresa de la lista
    public boolean eliminar(int id_emp) {
        return listaEmpresas.removeIf(empresa -> empresa.getId_emp() == id_emp);
    }

    // Busca empresa por id
    // utilizando
    // .stream para buscar empresa en la lista
    // .filter para filtrar empresa por id
    // .findFirst para obtener la primer empresa encontrado
    // .orElse para devolver null si no se encuentra la empresa
    public Empresa buscarPorId(int id_emp) {
        return listaEmpresas.stream()
                .filter(empresa -> empresa.getId_emp() == id_emp)
                .findFirst()
                .orElse(null);
    }

    // Busca empresa por nombre
    public Empresa buscarPorNombre(String nombre_emp) {
        return listaEmpresas.stream()
                .filter(empresa -> empresa.getNombre_emp().equals(nombre_emp))
                .findFirst()
                .orElse(null);
    }

    // Actualiza empresa
    // utilizando un bucle for para recorrer la lista de empresas
    // utilizando .set para actualizar la empresa encontrada
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