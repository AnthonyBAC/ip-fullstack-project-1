package microservicio_gestionCarga.microservicio_gestionCarga.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GestionarCarga;

@Repository
public interface GestionarCargaRepository extends JpaRepository<GestionarCarga, Long> {

}
