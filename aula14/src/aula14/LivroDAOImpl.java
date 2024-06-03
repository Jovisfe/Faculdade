package aula14;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {
    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addLivro(Livro livro) throws DAOException {
        String sql = "INSERT INTO livros (id, titulo, autor) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            throw new DAOException("Erro ao adicionar livro", e);
        }
    }

    @Override
    public void removeLivro(int id) throws DAOException {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Livro com ID " + id + " não encontrado para remoção.");
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao remover livro", e);
        }
    }

    @Override
    public Livro getLivro(int id) throws DAOException {
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                } else {
                    throw new DAOException("Livro com ID " + id + " não encontrado.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar livro", e);
        }
    }

    @Override
    public List<Livro> getAllLivros() throws DAOException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                livros.add(livro);
            }
            return livros;
        } catch (SQLException e) {
            throw new DAOException("Erro ao listar livros", e);
        }
    }
}

