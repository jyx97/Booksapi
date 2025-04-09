package fiap.com.br.fiap.model;

public enum  GenreEnum {
    
    FANTASY("Fantasia"),
    SCIENCE_FICTION("Ficção Científica"),
    ROMANCE("Romance"),
    HORROR("Terror"),
    DRAMA("Drama"),
    MYSTERY("Mistério/Policial"),
    ADVENTURE("Aventura"),
    DYSTOPIA("Distopia"),
    BIOGRAPHY("Biografia/Autobiografia"),
    CHILDREN_YA("Infantojuvenil");

    private final String description;

    GenreEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

    

