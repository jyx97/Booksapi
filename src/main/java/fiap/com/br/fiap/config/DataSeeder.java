package fiap.com.br.fiap.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fiap.com.br.fiap.model.Book;
import fiap.com.br.fiap.repository.BookRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    @Autowired
    private BookRepository repository;

    @PostConstruct
    public void init() {
        var books = List.of(
            new Book(
                "O Senhor dos Anéis",
                LocalDate.of(1954, 7, 29),
                "J.R.R. Tolkien",
                "FANTASY",
                "No pacífico Condado, a vida do hobbit Frodo Bolseiro muda para sempre ao herdar um anel de seu tio Bilbo.",
                "https://m.media-amazon.com/images/I/81SWBRKfExL._AC_UF1000,1000_QL80_.jpg"
            ),
            new Book(
                "A Hora da Estrela",
                LocalDate.of(1977, 10, 25),
                "Clarice Lispector",
                "DRAMA",
                "Macabéa, uma jovem nordestina órfã e ingênua, vive uma existência simples no Rio de Janeiro.",
                "https://m.media-amazon.com/images/I/61TaHURu27L._AC_UF894,1000_QL80_.jpg"
            ),
            new Book(
                "As Vantagens de Ser Invisível",
                LocalDate.of(1999, 2, 1),
                "Stephen Chbosky",
                "DRAMA",
                "Charlie, um adolescente introspectivo, escreve cartas anônimas para lidar com suas angústias.",
                "https://m.media-amazon.com/images/I/61WvSMKRBfL._AC_UF1000,1000_QL80_.jpg"
            ),
            new Book(
                "Os Dois Morrem no Final",
                LocalDate.of(2017, 9, 5),
                "Adam Silvera",
                "ROMANCE",
                "Mateo e Rufus recebem uma ligação que informa que têm apenas 24 horas de vida.",
                "https://m.media-amazon.com/images/I/61QhNRjycfL._AC_UF1000,1000_QL80_.jpg"
            ),
            new Book(
                "Admirável Mundo Novo",
                LocalDate.of(1932, 1, 1),
                "Aldous Huxley",
                "DYSTOPIA",
                "Em uma sociedade futurista onde a liberdade foi substituída pelo controle absoluto.",
                "https://m.media-amazon.com/images/I/61xLTuHpmwL._AC_UF1000,1000_QL80_.jpg"
            )
        );

        repository.saveAll(books);
    }
}
