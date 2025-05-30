package mitrack_proyecto.mitrack.reporteGeneral.services;

import com.mitrack.reporteGeneral.dto.MiTrackDashboardDTO;
import com.mitrack.reporteGeneral.dto.UsuarioReporteDTO;
import com.mitrack.reporteGeneral.repository.MiTrackReporteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiTrackReporteService {

    private static final Logger logger = LoggerFactory.getLogger(MiTrackReporteService.class);

    @Autowired
    private MiTrackReporteRepository reporteRepository;

    public MiTrackDashboardDTO generarDashboard() {
        logger.info("🔄 Generando dashboard de MiTrack...");

        MiTrackDashboardDTO dashboard = new MiTrackDashboardDTO();

        dashboard.setTotalUsuarios(reporteRepository.contarUsuarios());
        dashboard.setTotalClientes(reporteRepository.contarClientes());
        dashboard.setTotalVehiculos(reporteRepository.contarVehiculos());
        dashboard.setTotalRutas(reporteRepository.contarRutas());
        dashboard.setTotalCargas(reporteRepository.contarCargas());
        dashboard.setUsuariosActivos(reporteRepository.contarUsuariosActivos());
        dashboard.setVehiculosDisponibles(reporteRepository.contarVehiculosDisponibles());
        dashboard.setRutasActivas(reporteRepository.contarRutasActivas());

        logger.info("✅ Dashboard generado exitosamente");
        return dashboard;
    }

    public UsuarioReporteDTO generarReporteUsuarios() {
        logger.info("🔄 Generando reporte de usuarios...");

        Long totalUsuarios = reporteRepository.contarUsuarios();
        Long usuariosActivos = reporteRepository.contarUsuariosActivos();

        return new UsuarioReporteDTO(totalUsuarios, usuariosActivos);
    }

    public boolean verificarSalud() {
        return reporteRepository.verificarConexion();
    }
}