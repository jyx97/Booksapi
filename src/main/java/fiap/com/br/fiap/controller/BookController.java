package fiap.com.br.fiap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fiap.com.br.fiap.model.Book;
import fiap.com.br.fiap.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookRepository repository;

    @GetMapping
    @Cacheable("books")
    @Operation(tags = "Book", summary = "Listar livros", description = "Retorna todos os livros cadastrados no sistema.")
    public List<Book> listarLivros() {
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "books", allEntries = true)
    @Operation(summary = "Cadastrar um novo livro", responses = {
        @ApiResponse(responseCode = "201", description = "Livro criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<Book> cadastrarLivro(@RequestBody @Valid Book book) {
        logInfo("Cadastrando livro: " + book.getTitle());
        repository.save(book);
        return criarResposta(book, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> buscarLivro(@PathVariable Long id) {
        logInfo("Buscando livro " + id);
        return criarResposta(buscarLivroNoRepositorio(id), HttpStatus.OK);
    }

    //Busca um livro no repositório pelo ID
    private Book buscarLivroNoRepositorio(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    //resposta
    private ResponseEntity<Book> criarResposta(Book livro, HttpStatus status) {
        return ResponseEntity.status(status).body(livro);
    }

    // metodo pro log
    private void logInfo(String mensagem) {
        log.info(mensagem);
    }
}
