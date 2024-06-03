package aula14;

import java.util.List;

public class LivroController {
    private LivroDAO livroDAO;

    public LivroController(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    public void adicionarLivro(Livro livro) throws DAOException {
        livroDAO.addLivro(livro);
    }

    public void removerLivro(int id) throws DAOException {
        livroDAO.removeLivro(id);
    }

    public Livro buscarLivro(int id) throws DAOException {
        return livroDAO.getLivro(id);
    }

    public List<Livro> listarLivros() throws DAOException {
        return livroDAO.getAllLivros();
    }
}

