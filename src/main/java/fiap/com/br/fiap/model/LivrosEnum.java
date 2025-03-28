package fiap.com.br.fiap.model;

import java.time.LocalDate;

public enum LivrosEnum {
    SENHOR_DOS_ANEIS(1L, "O Senhor dos Anéis", LocalDate.of(1954, 7, 29), "J.R.R. Tolkien", "Fantasia", "No pacífico Condado, a vida do hobbit Frodo Bolseiro muda para sempre ao herdar um anel de seu tio Bilbo. O que parecia um mero tesouro revela-se a chave para o poder sombrio de Sauron, o Senhor do Escuro, que busca escravizar a Terra-média. Com a terrível verdade revelada pelo mago Gandalf, Frodo e seus amigos hobbits embarcam em uma perigosa jornada para destruir o Um Anel nas chamas da Montanha da Perdição, a única esperança de deter Sauron.", "https://m.media-amazon.com/images/I/81SWBRKfExL._AC_UF1000,1000_QL80_.jpg"),
    HORA_DA_ESTRELA(2L, "A Hora da Estrela", LocalDate.of(1977, 10, 25), "Clarice Lispector", "Drama", "Macabéa, uma jovem nordestina órfã e ingênua, vive uma existência simples e sem grandes expectativas no Rio de Janeiro. Trabalhando como datilógrafa, ela se agarra a pequenas alegrias e ilusões para suportar a dura realidade. Narrada por um escritor angustiado, sua história revela a fragilidade e a solidão de uma vida invisível aos olhos do mundo.", "https://m.media-amazon.com/images/I/61TaHURu27L._AC_UF894,1000_QL80_.jpg"),
    VANTAGENS_SER_INVISIVEL(3L, "As Vantagens de Ser Invisível", LocalDate.of(1999, 2, 1), "Stephen Chbosky", "Drama", "Charlie, um adolescente introspectivo e sensível, escreve cartas anônimas para lidar com suas angústias e descobertas. Enquanto enfrenta os desafios do ensino médio, ele encontra amizade em Patrick e Sam, dois veteranos excêntricos que o introduzem a um mundo de música, festas e autoconhecimento. Entre traumas do passado e a busca por pertencimento, Charlie aprende que crescer é um processo tão doloroso quanto libertador.", "https://m.media-amazon.com/images/I/61WvSMKRBfL._AC_UF1000,1000_QL80_.jpg"),
    OS_DOIS_MORREM_FINAL(4L, "Os Dois Morrem no Final", LocalDate.of(2017, 9, 5), "Adam Silvera", "Ficção", "Em um futuro onde uma organização chamada Morte Súbita avisa as pessoas sobre sua morte iminente, Mateo e Rufus recebem a fatídica ligação: têm apenas 24 horas de vida. Unidos por um aplicativo que conecta pessoas destinadas a morrer, eles decidem viver um último dia extraordinário, desafiando medos, explorando a cidade e descobrindo que, mesmo no fim, ainda há espaço para o amor e a esperança.", "https://m.media-amazon.com/images/I/61QhNRjycfL._AC_UF1000,1000_QL80_.jpg"),
    ADMIRAVEL_MUNDO_NOVO(5L, "Admirável Mundo Novo", LocalDate.of(1932, 1, 1), "Aldous Huxley", "Ficção Científica", "Em uma sociedade futurista onde a liberdade foi substituída pelo controle absoluto, os cidadãos vivem sob a promessa de felicidade eterna, condicionados desde o nascimento para aceitar seus papéis sem questionamento. Bernard Marx, um homem inquieto com as normas sociais, embarca em uma jornada que desafia os princípios dessa utopia artificial. Mas será possível encontrar significado em um mundo onde tudo é pré-determinado e a emoção humana é apenas um resquício do passado?", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrN3OPcFnkvz2lef0B0hV6U9avfEw2lPXTIQ&s");

    private final Book livro;

    LivrosEnum(Long id, String nome, LocalDate data, String autor, String genero, String sinopse, String imagem) {
        this.livro = new Book(id, nome, data, autor, genero, sinopse, imagem);
    }

    public Book getLivro() {
        return livro;
    }
}
