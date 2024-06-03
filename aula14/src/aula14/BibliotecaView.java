package aula14;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    private LivroController livroController;
    private Scanner scanner;

    public BibliotecaView(LivroController livroController) {
        this.livroController = livroController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar um livro");
            System.out.println("2. Remover um livro");
            System.out.println("3. Buscar um livro");
            System.out.println("4. Listar todos os livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarLivro();
                        break;
                    case 2:
                        removerLivro();
                        break;
                    case 3:
                        buscarLivro();
                        break;
                    case 4:
                        listarLivros();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.next();
                opcao = 0;
            } catch (DAOException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 5);
    }

    private void adicionarLivro() throws DAOException {
        System.out.print("Digite o ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(id, titulo, autor);
        livroController.adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    private void removerLivro() throws DAOException {
        System.out.print("Digite o ID do livro a ser removido: ");
        int id = scanner.nextInt();
        livroController.removerLivro(id);
        System.out.println("Livro removido com sucesso.");
    }

    private void buscarLivro() throws DAOException {
        System.out.print("Digite o ID do livro a ser buscado: ");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivro(id);
        System.out.println("Livro encontrado: " + livro);
    }

    private void listarLivros() throws DAOException {
        List<Livro> livros = livroController.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            System.out.println("Livros cadastrados:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }
}