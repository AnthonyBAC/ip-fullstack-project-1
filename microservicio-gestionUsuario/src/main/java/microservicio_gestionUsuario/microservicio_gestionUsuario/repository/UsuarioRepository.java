package microservicio_gestionUsuario.microservicio_gestionUsuario.repository;

import org.springframework.stereotype.Repository;

import microservicio_gestionUsuario.microservicio_gestionUsuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}