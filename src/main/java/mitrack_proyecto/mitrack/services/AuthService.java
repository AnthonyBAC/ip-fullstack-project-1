package mitrack_proyecto.mitrack.services;

import org.springframework.stereotype.Service;

import mitrack_proyecto.mitrack.model.RolNombre;
import mitrack_proyecto.mitrack.model.Usuario;

@Service
public class AuthService {
    public void verificarAdmin(Usuario usuarioActual) {
        if (usuarioActual.getRol().getNombre_rol() != RolNombre.ADMIN) {
            throw new RuntimeException("Solo administradores pueden buscar usuarios");
        }

    }
}
