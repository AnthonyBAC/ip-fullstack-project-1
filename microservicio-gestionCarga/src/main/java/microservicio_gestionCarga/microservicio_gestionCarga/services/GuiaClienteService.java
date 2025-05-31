package microservicio_gestionCarga.microservicio_gestionCarga.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import microservicio_gestionCarga.microservicio_gestionCarga.model.GuiaCliente;
import microservicio_gestionCarga.microservicio_gestionCarga.repository.GuiaClienteRepository;

@Service
public class GuiaClienteService {

    @Autowired
    private GuiaClienteRepository guiaClienteRepository;

    // Metodo para obtener lista de guias
    public List<GuiaCliente> obtenerGuias() {
        return guiaClienteRepository.obtenerGuias();
    }

    // Metodo para buscar guia por id
    public GuiaCliente buscarPorId(Long id) {
        GuiaCliente guiaCliente = guiaClienteRepository.buscarPorId(id);
        if (guiaCliente == null) {
            throw new RuntimeException("Guia no encontrada");
        }
        return guiaCliente;
    }

    // Metodo para guardar guia
    public GuiaCliente guardarGuia(GuiaCliente guiaCliente) {
        return guiaClienteRepository.guardar(guiaCliente);
    }

}
