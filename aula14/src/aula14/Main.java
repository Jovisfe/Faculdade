package aula14;

public class Main {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAOImpl();
        LivroController livroController = new LivroController(livroDAO);
        BibliotecaView bibliotecaView = new BibliotecaView(livroController);
        bibliotecaView.exibirMenu();
    }
}
