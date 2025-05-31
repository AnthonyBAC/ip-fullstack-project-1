package mitrack_proyecto.mitrack.gestionarUsuarios.repository;

import org.springframework.stereotype.Repository;

import mitrack_proyecto.mitrack.gestionarUsuarios.model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    // Genera lista de usuarios
    private final List<Usuario> listaUsuarios = new ArrayList<>();

    // Retorna lista de usuarios
    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    // Guarda usuario
    // utilizando .add para agregar usuario a la lista
    public Usuario guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    // Elimina usuario
    // utilizando .removeIf para eliminar usuario de la lista
    public boolean eliminarPorId(Long id) {
        return listaUsuarios.removeIf(usuario -> usuario.getId_usuario().equals(id));
    }

    // Busca usuario por id
    // utilizando
    // .stream para buscar usuario en la lista
    // .filter para filtrar usuario por id
    // .findFirst para obtener el primer usuario encontrado
    // .orElse para devolver null si no se encuentra el usuario
    public Usuario buscarPorId(Long id) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getId_usuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Busca usuario por nombre
    public Usuario buscarPorNombre(String nombre) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getNombre_usr().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Actualiza usuario
    // utilizando un bucle for para recorrer la lista de usuarios
    // utilizando .set para actualizar el usuario encontrado
    public Usuario actualizarPorId(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (usuarioActualizado.getId_usuario().equals(listaUsuarios.get(i).getId_usuario())) {
                listaUsuarios.set(i, usuarioActualizado);
                return usuarioActualizado;
            }
        }
        throw new RuntimeException("Usuario no encontrado");
    }

}
