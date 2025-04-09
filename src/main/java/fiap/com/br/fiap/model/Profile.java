package fiap.com.br.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 5, max = 255)
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "E-mail inválido")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 6, max = 12, message = "A senha deve ter entre 6 e 12 caracteres")
    private String password;
}
