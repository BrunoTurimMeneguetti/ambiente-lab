// Arquivo: LivroBiblioteca.java

import java.util.ArrayList;
import java.util.List;

public class LivroBiblioteca {

    // Classe Livro
    static class Livro {
        private String titulo;
        private String autor;
        private int anoPublicacao;

        public Livro(String titulo, String autor, int anoPublicacao) {
            this.titulo = titulo;
            this.autor = autor;
            setAnoPublicacao(anoPublicacao);
        }

        // Getters
        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        // Setters
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setAnoPublicacao(int anoPublicacao) {
            if (anoPublicacao > 0) {
                this.anoPublicacao = anoPublicacao;
            } else {
                System.out.println("Ano de publicação inválido! Deve ser maior que zero.");
            }
        }

        // Mostrar informações do livro
        public void mostrarInfo() {
            System.out.println("Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao);
        }
    }

    // Classe Biblioteca
    static class Biblioteca {
        private List<Livro> livros;
        private int capacidade;

        public Biblioteca(int capacidade) {
            setCapacidade(capacidade);
            this.livros = new ArrayList<>();
        }

        // Getter e Setter capacidade
        public int getCapacidade() {
            return capacidade;
        }

        public void setCapacidade(int capacidade) {
            if (capacidade > 0) {
                this.capacidade = capacidade;
            } else {
                System.out.println("Capacidade inválida! Deve ser maior que zero.");
                this.capacidade = 1;
            }
        }

        // Adicionar livro
        public void adicionarLivro(Livro livro) {
            if (livros.size() < capacidade) {
                livros.add(livro);
                System.out.println("Livro \"" + livro.getTitulo() + "\" adicionado com sucesso.");
            } else {
                System.out.println("Biblioteca cheia! Não é possível adicionar mais livros.");
            }
        }

        // Remover livro
        public void removerLivro(Livro livro) {
            if (livros.remove(livro)) {
                System.out.println("Livro \"" + livro.getTitulo() + "\" removido com sucesso.");
            } else {
                System.out.println("Livro não encontrado na biblioteca.");
            }
        }

        // Mostrar todos os livros
        public void mostrarLivros() {
            if (livros.isEmpty()) {
                System.out.println("A biblioteca está vazia.");
            } else {
                System.out.println("Livros na biblioteca:");
                for (Livro l : livros) {
                    l.mostrarInfo();
                }
            }
        }
    }

    // Programa principal (main)
    public static void main(String[] args) {
        Livro l1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Livro l2 = new Livro("1984", "George Orwell", 1949);
        Livro l3 = new Livro("Dom Casmurro", "Machado de Assis", 1899);

        Biblioteca biblioteca = new Biblioteca(2);

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3); // biblioteca cheia

        biblioteca.mostrarLivros();

        biblioteca.removerLivro(l1);

        biblioteca.mostrarLivros();
    }
}
