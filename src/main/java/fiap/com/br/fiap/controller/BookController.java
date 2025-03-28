package fiap.com.br.fiap.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.fiap.model.Book;
import fiap.com.br.fiap.model.LivrosEnum;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> repository;

    // Inicialização do repositório com os livros do enum
    public BookController() {
        this.repository = new ArrayList<>();
        // Preencher a lista de livros com os livros do enum
        Arrays.stream(LivrosEnum.values())
            .forEach(livroEnum -> repository.add(livroEnum.getLivro()));
    }

    // Listar todos os livros
    @GetMapping
    public List<Book> index() {
        return repository;
    }

    // Adicionar um novo livro
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Book> create(@RequestBody Book book) {
        System.out.println("Cadastrando Livro: " + book.getNome());
        repository.add(book);
        return ResponseEntity.status(201).body(book);
    }

    // Buscar livro por id no repositório
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        System.out.println("Buscando livro " + id);
        var book = repository.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book.get());
    }

    // Buscar livro por id utilizando o enum
    @GetMapping("/listed/{id}")
    public ResponseEntity<Book> buscarLivroPorEnumId(@PathVariable Long id) {
        var livroEnum = Arrays.stream(LivrosEnum.values())
            .filter(livro -> livro.getLivro().getId().equals(id))
            .findFirst();

        if (livroEnum.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(livroEnum.get().getLivro());
    }
}
