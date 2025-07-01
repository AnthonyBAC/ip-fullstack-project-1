package microservicio_empresa.microservicio_empresa.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.services.EmpresaService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SuppressWarnings("removal")
@WebMvcTest(EmpresaController.class)
public class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa();
        empresa.setIdEmp(1L);
        empresa.setNombreEmp("Empresa 1");
        empresa.setRutEmp(28965852);
        empresa.setDvEmp(2);
        empresa.setDirEmp("Calle Francia, Wakanda");
    }

    // Test para obtener todas las empresas
    @Test
    public void testGetAllEmpresas() throws Exception {
        when(empresaService.obtenerEmpresas()).thenReturn(List.of(empresa));

        mockMvc.perform(get("/api/v1/empresa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEmp").value(1L))
                .andExpect(jsonPath("$[0].nombreEmp").value("Empresa 1"))
                .andExpect(jsonPath("$[0].rutEmp").value(28965852))
                .andExpect(jsonPath("$[0].dvEmp").value(2))
                .andExpect(jsonPath("$[0].dirEmp").value("Calle Francia, Wakanda"));
    }

    // Test para obtener empresa por ID
    @Test
    public void testGetEmpresaById() throws Exception {
        when(empresaService.buscarPorId(1L)).thenReturn((empresa));

        mockMvc.perform(get("/api/v1/empresa/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmp").value(1L))
                .andExpect(jsonPath("$.nombreEmp").value("Empresa 1"))
                .andExpect(jsonPath("$.rutEmp").value(28965852))
                .andExpect(jsonPath("$.dvEmp").value(2))
                .andExpect(jsonPath("$.dirEmp").value("Calle Francia, Wakanda"));

    }

    // Test para guardar una empresa
    @Test
    public void testSaveEmpresa() throws Exception {
        when(empresaService.guardarEmpresa(any(Empresa.class))).thenReturn((empresa));

        mockMvc.perform(post("/api/v1/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empresa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmp").value(1L))
                .andExpect(jsonPath("$.nombreEmp").value("Empresa 1"))
                .andExpect(jsonPath("$.rutEmp").value(28965852))
                .andExpect(jsonPath("$.dvEmp").value(2))
                .andExpect(jsonPath("$.dirEmp").value("Calle Francia, Wakanda"));
    }

    // Test para actualizar una empresa POR ID
    @Test
    public void testUpdateEmpresa() throws Exception {
        when(empresaService.actualizarEmpresa(eq(1L), (any(Empresa.class)))).thenReturn((empresa));

        mockMvc.perform(put("/api/v1/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empresa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmp").value(1L))
                .andExpect(jsonPath("$.nombreEmp").value("Empresa 1"))
                .andExpect(jsonPath("$.rutEmp").value(28965852))
                .andExpect(jsonPath("$.dvEmp").value(2))
                .andExpect(jsonPath("$.dirEmp").value("Calle Francia, Wakanda"));
    }

    // Test para eliminar por ID
    @Test
    public void testDeleteEmpresaById_Encontrada() throws Exception {
        when(empresaService.eliminarEmpresaPorId(1L)).thenReturn("Empresa eliminada correctamente");

        mockMvc.perform(delete("/api/v1/empresa/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Empresa eliminada correctamente"));

        verify(empresaService, times(1)).eliminarEmpresaPorId(1L);
    }

    // Test para eliminar por ID pero no se encuentra el ID
    @Test
    public void testDeleteEmpresaById_NoEncontrada() throws Exception {
        when(empresaService.actualizarEmpresa(eq(1L), any(Empresa.class)))
                .thenThrow(new RuntimeException("Empresa no encontrada para actualizar."));

        mockMvc.perform(put("/api/v1/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empresa)))
                .andExpect(status().isBadRequest()) // gracias al @ExceptionHandler
                .andExpect(content().string("Empresa no encontrada para actualizar."));
    }
}
