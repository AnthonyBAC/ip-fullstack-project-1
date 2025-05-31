package microservicio_gestionUsuario.microservicio_gestionUsuario.controller;

import microservicio_gestionUsuario.microservicio_gestionUsuario.model.Usuario;
import microservicio_gestionUsuario.microservicio_gestionUsuario.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuario_service;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuario_service.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id_usuario) {
        return usuario_service.buscarPorId(id_usuario);
    }

    @GetMapping("/usuario/{nombre}")
    public Usuario buscarUsuarioPorNombre(@PathVariable("nombre") String nombre) {
        return usuario_service.buscarPorNombre(nombre);
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuario_service.guardarUsuario(usuario);
    }

    @DeleteMapping({ "/{id}" })
    public String eliminarUsuarioPorId(@PathVariable Long id_usuario) {
        return usuario_service.eliminarUsuarioPorId(id_usuario);
    }

    @PutMapping({ "/{id}" })
    public Usuario actualizarUsuario(@PathVariable Long id_usuario, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id_usuario);
        return usuario_service.actualizarUsuario(usuario);
    }

}
