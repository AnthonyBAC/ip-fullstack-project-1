package mitrack_proyecto.mitrack.reporteGeneral.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MiTrackReporteRepository {

    private static final Logger logger = LoggerFactory.getLogger(MiTrackReporteRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método helper para ejecutar consultas con manejo de errores
    private Long ejecutarConsulta(String sql, String descripcion) {
        try {
            Long resultado = jdbcTemplate.queryForObject(sql, Long.class);
            logger.info("✅ {}: {}", descripcion, resultado);
            return resultado != null ? resultado : 0L;
        } catch (DataAccessException e) {
            logger.warn("⚠️ Error en {}: {} - Retornando 0", descripcion, e.getMessage());
            return 0L;
        }
    }

    // Consultas para cada módulo de MiTrack
    public Long contarUsuarios() {
        return ejecutarConsulta("SELECT COUNT(*) FROM USUARIOS", "Total Usuarios");
    }

    public Long contarClientes() {
        return ejecutarConsulta("SELECT COUNT(*) FROM CLIENTES", "Total Clientes");
    }

    public Long contarVehiculos() {
        return ejecutarConsulta("SELECT COUNT(*) FROM VEHICULOS", "Total Vehículos");
    }

    public Long contarRutas() {
        return ejecutarConsulta("SELECT COUNT(*) FROM RUTAS", "Total Rutas");
    }

    public Long contarCargas() {
        return ejecutarConsulta("SELECT COUNT(*) FROM CARGAS", "Total Cargas");
    }

    // Consultas con filtros
    public Long contarUsuariosActivos() {
        return ejecutarConsulta(
                "SELECT COUNT(*) FROM USUARIOS WHERE ACTIVO = 1 OR ESTADO = 'ACTIVO'",
                "Usuarios Activos");
    }

    public Long contarVehiculosDisponibles() {
        return ejecutarConsulta(
                "SELECT COUNT(*) FROM VEHICULOS WHERE ESTADO = 'DISPONIBLE' OR ACTIVO = 1",
                "Vehículos Disponibles");
    }

    public Long contarRutasActivas() {
        return ejecutarConsulta(
                "SELECT COUNT(*) FROM RUTAS WHERE ESTADO = 'ACTIVA' OR ACTIVO = 1",
                "Rutas Activas");
    }

    // Método para verificar conectividad
    public boolean verificarConexion() {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
            logger.info("✅ Conexión a base de datos Oracle verificada");
            return true;
        } catch (Exception e) {
            logger.error("❌ Error de conexión a base de datos: {}", e.getMessage());
            return false;
        }
    }
}
