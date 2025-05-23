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

    // Metodo para obtener lista de usuarios
    // Retorna lista de usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

    // Metodo para buscar usuario por id
    // Retorna usuario si se encuentra, sino lanza excepcion
    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

    // Metodo para buscar usuario por nombre
    // Retorna usuario si se encuentra, sino lanza excepcion
    public Usuario buscarPorNombre(String nombre) {
        Usuario usuario = usuarioRepository.buscarPorNombre(nombre);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

    // Metodo para guardar usuario
    // retorna usuario guardado
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    // Metodo para eliminar usuario por id
    // retorna mensaje de confirmacion si se elimina, sino lanza excepcion
    public String eliminarUsuarioPorId(Long id) {
        boolean usuarioid = usuarioRepository.eliminar(id);
        if (!usuarioid) {
            throw new RuntimeException("No se encontró usuario para eliminar");
        }
        return "Usuario eliminado exitosamente";
    }

    // Metodo para actualizar usuario
    // Retorna usuario actualizado
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

}
