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

    @Test
    public void TestGetAllEmpresas()throws Exception{
        when(empresaService.)
    }
}
