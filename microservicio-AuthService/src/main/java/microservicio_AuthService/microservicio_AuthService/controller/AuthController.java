package microservicio_AuthService.microservicio_AuthService.controller;

import microservicio_AuthService.microservicio_AuthService.model.Usuario;
import microservicio_AuthService.microservicio_AuthService.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/verificar-admin")
    public String verificar(@RequestBody Usuario usuario) {
        authService.verificarAdmin(usuario);
        return "Autorizado como admin";
    }
}
