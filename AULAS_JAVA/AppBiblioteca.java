import java.util.ArrayList;
import java.util.List;

class Livro {
    //atributos
    private String autor;
    private String titulo;
    private String isbn;
    private boolean emprestado;

    //construtor da classe
    public Livro(String autor, String titulo, String isbn){
        this.autor = autor;
        this.titulo = titulo;
        this. isbn = isbn;
        this.emprestado = false; //livro é criado disponível
    }

    //método para emprestar
    public boolean emprestar(){
        if(!emprestado){
            emprestado = true;
            return true; //emprestimo realizado
        }else{
            return false; // livro não disponível
        }    
    }

    // Método para devolver o livro
    public void devolver() {
        emprestado = false;
    }

    // Método para verificar o status do livro
    public boolean isEmprestado() {
        return emprestado;
    }

    // Método para exibir informações do livro
    public String toString() {
        return titulo + 
                " - " + 
                autor + 
        " (ISBN: " + isbn + ") | " + 
        (emprestado ? "Emprestado" : "Disponível");
    }
    
}

// Classe que representa um Usuário da biblioteca
class Usuario {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados;
    // Construtor
    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }
    /* *************************************************** */
    // Método para emprestar um livro ao usuário
    public boolean emprestarLivro(Livro livro) {
        if(livro.emprestar()){
            livrosEmprestados.add(livro);
            System.out.println("Emprestou o livro: " + livro);
            return true;
        }else{
            System.out.println("O livro " + livro + "não está disponivel");
            return false;
        }
    }
    // Método para devolver um livro
    public boolean devolverLivro(Livro livro) {
        if(livrosEmprestados.contains(livro)){
            livro.devolver();
            livrosEmprestados.remove(livro);
            System.out.println(nome + "devolveu o livro");
            return true;
        }else{
            System.out.println(nome + "não tem o livro emprestado");
            return false;
        }
        
    }
    // Método para listar os livros emprestados
    public void listarLivrosEmprestados() {
        if(livrosEmprestados.isEmpty()){
            System.out.println("não possui livros emprestado");
        }else{
            System.out.println("LISTA DE LIVROS EMPRESTADOS");
            for(Livro livro : livrosEmprestados){
                System.out.println(" - " + livro);
            }
        } 
    }
}

// Classe principal para testar o sistema
public class AppBiblioteca {
    public static void mais(String[] args){
        Livro livro1 = new Livro("George Orwell", "1984", "123-123");
        Livro livro2 = new Livro("J.R.R Tolkien", "Senhor dos Anéis", "4444-123");
        Livro livro3 = new Livro("George R.R. Martin", "Game of Thrones", "7777-123");
        Usuario usuario1 = new Usuario("Alice",1);
        Usuario usuario2 = new Usuario("Bruno",2);
        usuario1.emprestarLivro(livro1);
        usuario2.emprestarLivro(livro3);
        usuario1.emprestarLivro(livro2);
        usuario1.listarLivrosEmprestados();
        usuario2.listarLivrosEmprestados();
        usuario1.devolverLivro(livro2);
        usuario1.listarLivrosEmprestados();
    }
}
    /* *************************************************** */
