package mitrack_proyecto.mitrack.reporteGeneral.controllerntroller;

import mitrack_proyecto.mitrack.reporteGeneral.dto.MiTrackDashboardDTO;
import mitrack_proyecto.mitrack.reporteGeneral.dto.UsuarioReporteDTO;
import mitrack_proyecto.mitrack.reporteGeneral.service.MiTrackReporteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mitrack/reportes")
@CrossOrigin(origins = "*")
public class MiTrackReporteController {

    private static final Logger logger = LoggerFactory.getLogger(MiTrackReporteController.class);

    @Autowired
    private MiTrackReporteService reporteService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> status = new HashMap<>();
        boolean isHealthy = reporteService.verificarSalud();

        status.put("service", "MiTrack Reporte Service");
        status.put("status", isHealthy ? "UP" : "DOWN");
        status.put("database", isHealthy ? "CONNECTED" : "DISCONNECTED");
        status.put("port", 8081);
        status.put("timestamp", System.currentTimeMillis());

        logger.info("🏥 Health check: {}", isHealthy ? "SALUDABLE" : "CON PROBLEMAS");

        return ResponseEntity.ok(status);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<MiTrackDashboardDTO> obtenerDashboard() {
        logger.info("📊 Solicitud de dashboard recibida");

        try {
            MiTrackDashboardDTO dashboard = reporteService.generarDashboard();
            return ResponseEntity.ok(dashboard);
        } catch (Exception e) {
            logger.error("❌ Error generando dashboard: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/usuarios/resumen")
    public ResponseEntity<UsuarioReporteDTO> obtenerResumenUsuarios() {
        logger.info("👥 Solicitud de reporte de usuarios recibida");

        try {
            UsuarioReporteDTO reporte = reporteService.generarReporteUsuarios();
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            logger.error("❌ Error generando reporte de usuarios: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> obtenerInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("proyecto", "MiTrack");
        info.put("servicio", "Reporte Service");
        info.put("version", "1.0.0");
        info.put("descripcion", "Microservicio de reportes para el sistema MiTrack");
        info.put("endpoints", new String[] {
                "GET /api/mitrack/reportes/health",
                "GET /api/mitrack/reportes/dashboard",
                "GET /api/mitrack/reportes/usuarios/resumen",
                "GET /api/mitrack/reportes/info"
        });

        return ResponseEntity.ok(info);
    }
}

// Script SQL para testing - mitrack_test_data.sql
/*
 * -- Script de prueba para MiTrack
 * -- Ejecutar en Oracle para crear datos de prueba
 * 
 * -- Crear tablas básicas si no existen
 * CREATE TABLE USUARIOS (
 * ID NUMBER PRIMARY KEY,
 * NOMBRE VARCHAR2(100),
 * EMAIL VARCHAR2(150),
 * ACTIVO NUMBER(1) DEFAULT 1,
 * FECHA_CREACION TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 * );
 * 
 * CREATE TABLE CLIENTES (
 * ID NUMBER PRIMARY KEY,
 * NOMBRE VARCHAR2(100),
 * RUT VARCHAR2(20),
 * ACTIVO NUMBER(1) DEFAULT 1
 * );
 * 
 * CREATE TABLE VEHICULOS (
 * ID NUMBER PRIMARY KEY,
 * PATENTE VARCHAR2(10),
 * MODELO VARCHAR2(50),
 * ESTADO VARCHAR2(20) DEFAULT 'DISPONIBLE'
 * );
 * 
 * CREATE TABLE RUTAS (
 * ID NUMBER PRIMARY KEY,
 * NOMBRE VARCHAR2(100),
 * ORIGEN VARCHAR2(100),
 * DESTINO VARCHAR2(100),
 * ESTADO VARCHAR2(20) DEFAULT 'ACTIVA'
 * );
 * 
 * CREATE TABLE CARGAS (
 * ID NUMBER PRIMARY KEY,
 * DESCRIPCION VARCHAR2(200),
 * PESO NUMBER(10,2),
 * FECHA_CARGA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 * );
 * 
 * -- Insertar datos de prueba
 * INSERT INTO USUARIOS VALUES (1, 'Admin MiTrack', 'admin@mitrack.com', 1,
 * CURRENT_TIMESTAMP);
 * INSERT INTO USUARIOS VALUES (2, 'Usuario Test', 'test@mitrack.com', 1,
 * CURRENT_TIMESTAMP);
 * INSERT INTO USUARIOS VALUES (3, 'Usuario Inactivo', 'inactivo@mitrack.com',
 * 0, CURRENT_TIMESTAMP);
 * 
 * INSERT INTO CLIENTES VALUES (1, 'Cliente A', '12345678-9', 1);
 * INSERT INTO CLIENTES VALUES (2, 'Cliente B', '98765432-1', 1);
 * 
 * INSERT INTO VEHICULOS VALUES (1, 'ABC-123', 'Camión Mercedes', 'DISPONIBLE');
 * INSERT INTO VEHICULOS VALUES (2, 'XYZ-789', 'Camión Volvo', 'EN_RUTA');
 * 
 * INSERT INTO RUTAS VALUES (1, 'Santiago-Valparaíso', 'Santiago', 'Valparaíso',
 * 'ACTIVA');
 * INSERT INTO RUTAS VALUES (2, 'Santiago-Concepción', 'Santiago', 'Concepción',
 * 'INACTIVA');
 * 
 * INSERT INTO CARGAS VALUES (1, 'Carga de prueba 1', 1500.50,
 * CURRENT_TIMESTAMP);
 * INSERT INTO CARGAS VALUES (2, 'Carga de prueba 2', 2300.75,
 * CURRENT_TIMESTAMP);
 * 
 * COMMIT;
 * 
 * -- Verificar datos
 * SELECT 'USUARIOS' as TABLA, COUNT(*) as TOTAL FROM USUARIOS
 * UNION ALL
 * SELECT 'CLIENTES', COUNT(*) FROM CLIENTES
 * UNION ALL
 * SELECT 'VEHICULOS', COUNT(*) FROM VEHICULOS
 * UNION ALL
 * SELECT 'RUTAS', COUNT(*) FROM RUTAS
 * UNION ALL
 * SELECT 'CARGAS', COUNT(*) FROM CARGAS;
 */