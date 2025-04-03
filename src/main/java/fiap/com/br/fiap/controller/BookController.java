package fiap.com.br.fiap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import fiap.com.br.fiap.model.Book;
import fiap.com.br.fiap.model.BooksEnum;
import fiap.com.br.fiap.repository.BookRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        log.info("Cadastrando livro: {}", book.getTitle());
        repository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("{id}")
    public Book get(@PathVariable Long id) {
        log.info("Buscando livro {}", id);
        return getBook(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Removendo livro {}", id);
        repository.delete(getBook(id));
    }

    @PutMapping("{id}")
    public Book update(@PathVariable Long id, @RequestBody @Valid Book book) {
        log.info("Atualizando livro {} para {}", id, book);
        book.setId(id);
        return repository.save(book);
    }

    @GetMapping("/listed/{id}")
    public ResponseEntity<Book> getBookFromEnum(@PathVariable Long id) {
        var bookEnum = List.of(BooksEnum.values()).stream() // Corrigido o nome da variável
            .map(BooksEnum::getBook) // Obtendo o objeto Book do enum
            .filter(book -> book.getId().equals(id))
            .findFirst();
    
        return BooksEnum
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Book getBook(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }
}
