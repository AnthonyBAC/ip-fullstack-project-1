package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.model.Usuario;
import mitrack_proyecto.mitrack.repository.UsuarioRepository;
import mitrack_proyecto.mitrack.model.RolNombre;
import mitrack_proyecto.mitrack.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class UsuarioService {

    // Verificar si es admin
    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuario_repository;

    // Listando usuarios
    public List<Usuario> obtenerUsuarios(Usuario usuarioActual) {
        authService.verificarAdmin(usuarioActual);
        return usuario_repository.obtenerUsuarios();

    }

}
