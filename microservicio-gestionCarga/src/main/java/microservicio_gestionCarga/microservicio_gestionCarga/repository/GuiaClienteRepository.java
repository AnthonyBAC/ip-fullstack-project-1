package microservicio_gestionCarga.microservicio_gestionCarga.repository;

import org.springframework.stereotype.Repository;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GuiaCliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GuiaClienteRepository extends JpaRepository<GuiaCliente, Long> {

}
