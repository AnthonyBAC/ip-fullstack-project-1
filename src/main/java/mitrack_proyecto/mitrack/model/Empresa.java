package mitrack_proyecto.mitrack.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//Genera automaticamente getters y setters toStringetc() ahorro.
@Data
// Genera un constructor con todos los campos como parametro
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emp;
    private String nombre_emp;
    private int rut_emp;
    private String dv_emp;
    private String dir_emp;

}
