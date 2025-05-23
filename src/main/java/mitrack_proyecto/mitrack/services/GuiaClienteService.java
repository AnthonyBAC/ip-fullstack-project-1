package mitrack_proyecto.mitrack.services;

import mitrack_proyecto.mitrack.repository.GuiaClienteRepository;
import mitrack_proyecto.mitrack.model.GuiaCliente;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

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
