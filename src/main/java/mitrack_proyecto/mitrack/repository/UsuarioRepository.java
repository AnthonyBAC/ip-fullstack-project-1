package mitrack_proyecto.mitrack.repository;

import mitrack_proyecto.mitrack.model.RolNombre;
import mitrack_proyecto.mitrack.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(Long id_usuario, Usuario usuarioActual){
        if (usuarioActual.getRol().getNombre_rol() != RolNombre.ADMIN){
            throw new RuntimeException("Solo administradores pueden buscar usuarios");
        }
        for (Usuario usuario : listaUsuarios){
            if (usuario.getId_usuario().equals(id_usuario)) {
                return usuario;
            }
        }
        return null;
    }


    public Usuario buscarPorNombre(String nombre_usr) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre_usr().equals(nombre_usr)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    public

}
