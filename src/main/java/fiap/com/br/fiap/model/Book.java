package fiap.com.br.fiap.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Título é obrigatório")
    @Size(min = 2, max = 255)
    private String title;

    @PastOrPresent(message = "A data de publicação não pode estar no futuro")
    private LocalDate publicationDate;

    @NotBlank(message = "Autor é obrigatório")
    @Size(min = 3, max = 300)
    private String author;

    @NotBlank(message = "Gênero é obrigatório")
    private String genre;

    @Size(max = 5000, message = "A sinopse deve ter no máximo 1000 caracteres")
    private String synopsis;

    private String picture;
}
