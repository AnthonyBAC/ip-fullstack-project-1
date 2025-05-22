package mitrack_proyecto.mitrack.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    private int id_emp;
    private String nombre_emp;
    private int rut_emp;
    private String dv_emp;
    private String dir_emp;

}
