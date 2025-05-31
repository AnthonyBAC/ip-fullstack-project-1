package microservicio_AuthService.microservicio_AuthService.services;

import org.springframework.stereotype.Service;

import microservicio_AuthService.microservicio_AuthService.model.RolNombre;
import microservicio_AuthService.microservicio_AuthService.model.Usuario;

@Service
public class AuthService {
    public void verificarAdmin(Usuario usuarioActual) {
        if (usuarioActual.getRol().getNombre_rol() != RolNombre.ADMIN) {
            throw new RuntimeException("Solo administradores pueden buscar usuarios");
        }

    }
}
