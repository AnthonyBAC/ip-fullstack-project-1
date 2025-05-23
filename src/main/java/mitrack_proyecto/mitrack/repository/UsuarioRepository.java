package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Usuario guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    public boolean eliminar(Long id) {
        return listaUsuarios.removeIf(usuario -> usuario.getId_usuario().equals(id));
    }

    public Usuario buscarPorId(Long id) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getId_usuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Usuario buscarPorNombre(String nombre) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getNombre_usr().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Usuario actualizar(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (usuarioActualizado.getId_usuario().equals(listaUsuarios.get(i).getId_usuario())) {
                listaUsuarios.set(i, usuarioActualizado);
                return usuarioActualizado;
            }
        }
        throw new RuntimeException("Usuario no encontrado");
    }

}
