package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.model.Usuario;
import mitrack_proyecto.mitrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

    public Usuario buscarPorNombre(String nombre) {
        Usuario usuario = usuarioRepository.buscarPorNombre(nombre);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    public String eliminarUsuarioPorId(Long id) {
        boolean eliminado = usuarioRepository.eliminar(id);
        if (!eliminado) {
            throw new RuntimeException("No se encontró usuario para eliminar");
        }
        return "Usuario eliminado exitosamente";
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

}
