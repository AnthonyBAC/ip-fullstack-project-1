package microservicio_empresa.microservicio_empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import microservicio_empresa.microservicio_empresa.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}