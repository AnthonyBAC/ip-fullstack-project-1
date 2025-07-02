package microservicio_empresa.microservicio_empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// Genera un constructor
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
public class EmpresaRequest {
    private String nombreEmp;
    private int rutEmp;
    private int dvEmp;
    private String dirEmp;

}