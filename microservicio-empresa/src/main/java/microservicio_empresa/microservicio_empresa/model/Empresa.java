package microservicio_empresa.microservicio_empresa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//Genera automaticamente G y S
@Data
// Genera un constructor
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;

    private String nombreEmp;
    private int rutEmp;
    private int dvEmp;
    private String dirEmp;

}
