package fiap.com.br.fiap.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fiap.com.br.fiap.model.Book;
import fiap.com.br.fiap.repository.BookRepository;
import jakarta.annotation.PostConstruct;

//ver repositório do professor e passar os daos para o DataSeeder
@Component
public class DataSeeder {
    @Autowired
    private BookRepository repository;

    @PostConstruct
    public void init(){
        var books = List.of(
            Book.builder().title("O Senhor dos Anéis")
        .publicationDate(LocalDate.of(1954, 7, 29))
        .author("J.R.R. Tolkien")
        .genre("FANTASY")
        .synopsis("No pacífico Condado, a vida do hobbit Frodo Bolseiro muda para sempre ao herdar um anel de seu tio Bilbo.")
        .picture("https://m.media-amazon.com/images/I/81SWBRKfExL._AC_UF1000,1000_QL80_.jpg")
        .build(),

        Book.builder().title("A Hora da Estrela")
        .publicationDate(LocalDate.of(1977, 10, 25))
        .author("Clarice Lispector")
        .genre("DRAMA")
        .synopsis("Macabéa, uma jovem nordestina órfã e ingênua, vive uma existência simples no Rio de Janeiro.")
        .picture("https://m.media-amazon.com/images/I/61TaHURu27L._AC_UF894,1000_QL80_.jpg")
        .build(),
        
        Book.builder().title("As Vantagens de Ser Invisível")
        .publicationDate(LocalDate.of(1999, 2, 1))
        .author("Stephen Chbosky")
        .genre("DRAMA")
        .synopsis("Charlie, um adolescente introspectivo, escreve cartas anônimas para lidar com suas angústias.")
        .picture("https://m.media-amazon.com/images/I/61WvSMKRBfL._AC_UF1000,1000_QL80_.jpg")
        .build(),
        
        Book.builder().title("Os Dois Morrem no Final")
        .publicationDate(LocalDate.of(2017, 9, 5))
        .author("Adam Silvera")
        .genre("ROMANCE")
        .synopsis("Mateo e Rufus recebem uma ligação que informa que têm apenas 24 horas de vida.")
        .picture("https://m.media-amazon.com/images/I/61QhNRjycfL._AC_UF1000,1000_QL80_.jpg")
        .build(),
        
        Book.builder().title("Admirável Mundo Novo")
        .publicationDate(LocalDate.of(1932, 1, 1))
        .author("Aldous Huxley")
        .genre("DYSTOPIA")
        .synopsis("Em uma sociedade futurista onde a liberdade foi substituída pelo controle absoluto.")
        .picture("https://m.media-amazon.com/images/I/61xLTuHpmwL._AC_UF1000,1000_QL80_.jpg")
        .build()
        );

        repository.saveAll(books);
    }
}
