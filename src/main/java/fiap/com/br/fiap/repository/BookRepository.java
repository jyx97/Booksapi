package fiap.com.br.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.fiap.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
