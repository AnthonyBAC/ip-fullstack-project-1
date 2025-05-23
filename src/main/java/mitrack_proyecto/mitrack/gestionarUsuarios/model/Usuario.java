package mitrack_proyecto.mitrack.gestionarUsuarios.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//Genera automaticamente getters y setters toStringetc() ahorro.
@Data
// Genera un constructor con todos los campos como parametro
@AllArgsConstructor
// Genera un constructor vacio (sin argumentos)
@NoArgsConstructor
public class Usuario {

    // Define clave primaria
    // Se indica que esta id se generara de manera automatica de forma
    // auto-incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre_usr;
    @Email
    @NotBlank
    private String email_usr;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
