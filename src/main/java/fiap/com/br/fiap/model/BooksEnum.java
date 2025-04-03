package fiap.com.br.fiap.model;

import java.time.LocalDate;

public enum BooksEnum {
    SENHOR_DOS_ANEIS(1L, "O Senhor dos Anéis", LocalDate.of(1954, 7, 29), "J.R.R. Tolkien", GenreEnum.FANTASY,
            "No pacífico Condado, a vida do hobbit Frodo Bolseiro muda para sempre ao herdar um anel de seu tio Bilbo. O que parecia um mero tesouro revela-se a chave para o poder sombrio de Sauron, o Senhor do Escuro, que busca escravizar a Terra-média.",
            "https://m.media-amazon.com/images/I/81SWBRKfExL._AC_UF1000,1000_QL80_.jpg"),

    HORA_DA_ESTRELA(2L, "A Hora da Estrela", LocalDate.of(1977, 10, 25), "Clarice Lispector", GenreEnum.DRAMA,
            "Macabéa, uma jovem nordestina órfã e ingênua, vive uma existência simples e sem grandes expectativas no Rio de Janeiro.",
            "https://m.media-amazon.com/images/I/61TaHURu27L._AC_UF894,1000_QL80_.jpg"),

    VANTAGENS_SER_INVISIVEL(3L, "As Vantagens de Ser Invisível", LocalDate.of(1999, 2, 1), "Stephen Chbosky", GenreEnum.DRAMA,
            "Charlie, um adolescente introspectivo e sensível, escreve cartas anônimas para lidar com suas angústias e descobertas.",
            "https://m.media-amazon.com/images/I/61WvSMKRBfL._AC_UF1000,1000_QL80_.jpg"),

    OS_DOIS_MORREM_FINAL(4L, "Os Dois Morrem no Final", LocalDate.of(2017, 9, 5), "Adam Silvera", GenreEnum.ROMANCE,
            "Em um futuro onde uma organização chamada Morte Súbita avisa as pessoas sobre sua morte iminente, Mateo e Rufus recebem a fatídica ligação: têm apenas 24 horas de vida.",
            "https://m.media-amazon.com/images/I/61QhNRjycfL._AC_UF1000,1000_QL80_.jpg"),

    ADMIRAVEL_MUNDO_NOVO(5L, "Admirável Mundo Novo", LocalDate.of(1932, 1, 1), "Aldous Huxley", GenreEnum.DYSTOPIA,
            "Em uma sociedade futurista onde a liberdade foi substituída pelo controle absoluto, os cidadãos vivem sob a promessa de felicidade eterna.",
            "https://m.media-amazon.com/images/I/61xLTuHpmwL._AC_UF1000,1000_QL80_.jpg");

    private final long id;
    private final String title;
    private final LocalDate publicationDate;
    private final String author;
    private final GenreEnum genre;
    private final String synopsis;
    private final String picture;

    BooksEnum(long id, String title, LocalDate publicationDate, String author, GenreEnum genre, String synopsis, String picture) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.author = author;
        this.genre = genre;
        this.synopsis = synopsis;
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPicture() {
        return picture;
    }

    Book getBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }
}

