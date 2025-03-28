// Caso a recomendação de livros não seja necessária, você pode remover a classe LivroUsuario por enquanto.
package fiap.com.br.fiap.model;

import java.util.Set;

import lombok.Data;
@Data
public class LivroUsuario {
    private Usuario usuario;
    private Set<LivrosEnum> livrosRecomendados;

    // Método para recomendar livros com base nos gêneros preferidos do usuário (removido por enquanto)
    public void recomendarLivros() {
        livrosRecomendados.clear();
        for (LivrosEnum livroEnum : LivrosEnum.values()) {
            if (usuario.getGenerosPreferidos().contains(livroEnum.getLivro().getGenero())) {
                livrosRecomendados.add(livroEnum);
            }
        }
    }

    // Método para exibir as recomendações (removido por enquanto)
    public void exibirRecomendacoes() {
        System.out.println("Recomendações para " + usuario.getNome() + ":");
        for (LivrosEnum livroEnum : livrosRecomendados) {
            System.out.println(livroEnum.getLivro());
        }
    }
}
