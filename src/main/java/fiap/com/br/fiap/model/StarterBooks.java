package fiap.com.br.fiap.model;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fiap.com.br.fiap.repository.BookRepository;

@Component
public class StarterBooks implements CommandLineRunner {

    private final BookRepository repository;

    public StarterBooks(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserção dos livros diretamente no banco
        repository.save(new Book("O Senhor dos Anéis", LocalDate.of(1954, 7, 29), "J.R.R. Tolkien", "FANTASY",
                "No pacífico Condado, a vida do hobbit Frodo Bolseiro muda para sempre ao herdar um anel de seu tio Bilbo.",
                "https://m.media-amazon.com/images/I/81SWBRKfExL._AC_UF1000,1000_QL80_.jpg"));
        
        repository.save(new Book("A Hora da Estrela", LocalDate.of(1977, 10, 25), "Clarice Lispector", "DRAMA",
                "Macabéa, uma jovem nordestina órfã e ingênua, vive uma existência simples no Rio de Janeiro.",
                "https://m.media-amazon.com/images/I/61TaHURu27L._AC_UF894,1000_QL80_.jpg"));
        
        repository.save(new Book("As Vantagens de Ser Invisível", LocalDate.of(1999, 2, 1), "Stephen Chbosky", "DRAMA",
                "Charlie, um adolescente introspectivo, escreve cartas anônimas para lidar com suas angústias.",
                "https://m.media-amazon.com/images/I/61WvSMKRBfL._AC_UF1000,1000_QL80_.jpg"));
        
        repository.save(new Book("Os Dois Morrem no Final", LocalDate.of(2017, 9, 5), "Adam Silvera", "ROMANCE",
                "Mateo e Rufus recebem uma ligação que informa que têm apenas 24 horas de vida.",
                "https://m.media-amazon.com/images/I/61QhNRjycfL._AC_UF1000,1000_QL80_.jpg"));
        
        repository.save(new Book("Admirável Mundo Novo", LocalDate.of(1932, 1, 1), "Aldous Huxley", "DYSTOPIA",
                "Em uma sociedade futurista onde a liberdade foi substituída pelo controle absoluto.",
                "https://m.media-amazon.com/images/I/61xLTuHpmwL._AC_UF1000,1000_QL80_.jpg"));
    }
}
