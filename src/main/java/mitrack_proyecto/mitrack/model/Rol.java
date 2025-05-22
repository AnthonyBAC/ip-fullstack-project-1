package mitrack_proyecto.mitrack.model;

import mitrack_proyecto.mitrack.model.RolNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//Genera automaticamente getters y setters toStringetc() ahorro.
@Data
// Genera un constructor con todos los campos como parametro
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {

    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    @Enumerated(EnumType.STRING)
    private RolNombre nombre_rol;

}
