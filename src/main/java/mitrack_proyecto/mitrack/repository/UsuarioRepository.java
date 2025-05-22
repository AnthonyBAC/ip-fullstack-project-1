package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    // Listar usuarios
    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    // Buscar usuarios por id
    public Usuario buscarPorId(Long id_usuario, Usuario usuarioActual) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId_usuario().equals(id_usuario)) {
                return usuario;
            }
        }
        return null;
    }

    // Buscar usuarios por Nombre
    public Usuario buscarPorNOmbre(String nombre_usr, Usuario usuarioActual) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre_usr().equals(nombre_usr)) {
                return usuario;
            }
        }
        return null;
    }

    // Buscar usuarios por nombre
    public Usuario buscarPorNombre(String nombre_usr) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre_usr().equals(nombre_usr)) {
                return usuario;
            }
        }
        return null;
    }

    // guardar usuario
    public Usuario guardarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    // eliminar usuario
    public void eliminarUsuarioPorId(Long id_usuario) {
        listaUsuarios.removeIf(id -> id.getId_usuario().equals(id_usuario));
    }

    // Actualizar usuarios
    public Usuario actualizarUsuario(Usuario usuario) {
        Long id = 0L;
        int idPosicion = -1;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (usuario.getId_usuario() != null &&
                    usuario.getId_usuario().equals(listaUsuarios.get(i).getId_usuario())) {
                id = usuario.getId_usuario();
                idPosicion = i;
                break;
            }
        }
        if (idPosicion == -1) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId_usuario(id);
        usuario1.setNombre_usr(usuario.getNombre_usr());
        usuario1.setRol(usuario.getRol());
        usuario1.setEmail_usr(usuario.getEmail_usr());
        usuario1.setContraseña_usr(usuario.getContraseña_usr());

        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;

    }

}
