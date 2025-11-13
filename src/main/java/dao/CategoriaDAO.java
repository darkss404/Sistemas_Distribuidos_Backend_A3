package dao;

import modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de acesso ao banco de dados
 * relacionadas à entidade {@link Categoria}.
 *
 * Esta classe implementa os métodos CRUD (Create, Read, Update e Delete) para
 * manipular registros da tabela {@code categoria}.
 *
 * @author Hector
 * @version 1.0
 */
public class CategoriaDAO {

    /**
     * Estabelece conexão com o banco de dados.
     */
    private Connection connection;

    /**
     * Construtor da classe. Estabelece a conexão com o banco de dados por meio
     * da classe {@link Conexao}.
     *
     * @throws RuntimeException se não for possível conectar ao banco de dados
     */
    public CategoriaDAO() {
        Conexao conexao = new Conexao();
        this.connection = conexao.conectar();

        if (this.connection == null) {
            throw new RuntimeException("Erro ao conectar com o banco de dados");
        }
    }

    /**
     * Insere uma nova categoria no banco de dados.
     *
     * @param categoria objeto {@link Categoria} a ser salvo
     * @throws SQLException se ocorrer um erro durante a execução do SQL
     */
    public void salvar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";
        try (
                Connection conn = new Conexao().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());

            stmt.executeUpdate();
        }
    }

    /**
     * Retorna uma lista com todas as categorias cadastradas no banco de dados.
     *
     * @return uma {@link List} contendo todas as categorias
     * @throws SQLException se ocorrer um erro durante a consulta
     */
    public List<Categoria> listarCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (
                Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria(
                        rs.getInt("idcategoria"),
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                categorias.add(c);
            }
        }

        return categorias;
    }

    /**
     * Atualiza os dados de uma categoria existente no banco de dados.
     *
     * @param categoria objeto {@link Categoria} com os novos dados
     * @throws SQLException se ocorrer um erro durante a atualização
     */
    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE idcategoria = ?";

        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());
            stmt.setInt(4, categoria.getId());
            stmt.executeUpdate();
        }
    }

    /**
     * Exclui uma categoria do banco de dados com base em seu ID.
     *
     * @param id identificador único da categoria a ser excluída
     * @throws SQLException se ocorrer um erro durante a exclusão
     */
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE idcategoria = ?";

        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
