package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.model.Usuario;
import mitrack_proyecto.mitrack.repository.UsuarioRepository;
import mitrack_proyecto.mitrack.model.Rol;
import mitrack_proyecto.mitrack.model.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    // Verificar si es admin
    private void verificarAdmin(Usuario usuarioActual) {
        if (usuarioActual.getRol().getNombre_rol() != RolNombre.ADMIN) {
            throw new RuntimeException("Solo administradores pueden buscar usuarios");
        }

    }

    @Autowired
    private UsuarioRepository usuario_repository;

    // Listando usuarios
    public List<Usuario> obtenerUsuarios(Usuario usuarioActual) {
        verificarAdmin(usuarioActual);
        return usuario_repository.obtenerUsuarios();

    }

}
