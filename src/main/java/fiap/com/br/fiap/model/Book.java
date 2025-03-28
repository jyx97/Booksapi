package fiap.com.br.fiap.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String nome; 
    private LocalDate data;
    private String autor;
    private String genero;
    private String sinopse;
    private String imagem; 
    
    public Book(Long id, String nome, LocalDate data, String autor, String genero, String sinopse, String imagem) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.autor = autor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.imagem = imagem;
    }
}
