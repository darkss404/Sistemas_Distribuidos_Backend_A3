package dao;

import modelo.Produto;
import modelo.RegistroMovimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de acesso ao banco de dados
 * relacionadas à entidade {@link Produto}.
 * Esta classe implementa os métodos CRUD (Create, Read, Update e Delete) e
 * também funções de busca, filtragem e registro de movimentações de entrada e
 * saída de produtos.
 * @author Hector
 * @version 1.0
 */
public class ProdutoDAO {

    /**
     * Lista temporária de produtos utilizada para armazenar resultados de
     * consultas.
     */
    ArrayList<Produto> minhaLista = new ArrayList();

    /**
     * Cadastra um novo produto no banco de dados.
     *
     * @param produto objeto {@link Produto} a ser cadastrado
     * @return {@code true} se o produto foi cadastrado com sucesso,
     * {@code false} caso contrário
     */
    public boolean CadastrarProduto(Produto produto) {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.conectar()) {
            String sql = "INSERT INTO produto (nome, unidade,quantidade, preco, min, max, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, produto.getNome());
            st.setString(2, produto.getUnidade());
            st.setInt(3, produto.getQuantidade());
            st.setDouble(4, produto.getPreco());
            st.setInt(5, produto.getMin());
            st.setInt(6, produto.getMax());
            st.setString(7, produto.getCategoria());

            st.execute();
            st.close();

            System.out.println("Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id identificador único do produto
     * @return o objeto {@link Produto} encontrado, ou um produto vazio se não
     * existir
     */
    public Produto ProcurarProdutoID(int id) {
        Conexao conexao = new Conexao();
        Produto produto = new Produto();
        try (Connection conn = conexao.conectar()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM produto WHERE id = " + id);

            if (res.next()) {
                produto.setId(res.getInt("id"));
                produto.setNome(res.getString("nome"));
                produto.setUnidade(res.getString("unidade"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));
                produto.setMin(res.getInt("min"));
                produto.setMax(res.getInt("max"));
                produto.setCategoria(res.getString("categoria"));
            }

            res.close();
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }

        return produto;
    }

    /**
     * Busca um produto pelo nome.
     *
     * @param nome nome exato do produto
     * @return o objeto {@link Produto} encontrado, ou um produto vazio se não
     * existir
     */
    public Produto ProcurarProdutoNome(String nome) {
        Conexao conexao = new Conexao();
        Produto produto = new Produto();
        try (Connection conn = conexao.conectar()) {
            String sql = "SELECT * FROM produto WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                produto.setId(res.getInt("id"));
                produto.setNome(res.getString("nome"));
                produto.setUnidade(res.getString("unidade"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));
                produto.setMin(res.getInt("min"));
                produto.setMax(res.getInt("max"));
                produto.setCategoria(res.getString("categoria"));
            }

            res.close();
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }

        return produto;
    }

    /**
     * Atualiza os dados de um produto existente.
     *
     * @param produto objeto {@link Produto} com os dados atualizados
     * @return {@code true} se a atualização foi bem-sucedida, {@code false}
     * caso contrário
     */
    public boolean AtualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome=?, unidade=?, quantidade=?, preco=?, min=?, max=?, categoria=? WHERE id=?";
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getUnidade());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getMin());
            stmt.setInt(6, produto.getMax());
            stmt.setString(7, produto.getCategoria());
            stmt.setInt(8, produto.getId());
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto atualizado com sucesso!");
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Exclui um produto com base em seu ID.
     *
     * @param id identificador único do produto
     * @return {@code true} se a exclusão foi bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean DeletarProdutoID(int id) {
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM produto WHERE id = " + id);
            stmt.close();

            System.out.println("Produto deletado com sucesso!");
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Retorna uma lista com todos os produtos cadastrados.
     *
     * @return lista de objetos {@link Produto}
     */
    public ArrayList<Produto> getMinhaListaProdutos() {
        minhaLista.clear();
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM produto");

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String unidade = res.getString("unidade");
                int quantidade = res.getInt("quantidade");
                double preco = res.getDouble("preco");
                int min = res.getInt("min");
                int max = res.getInt("max");
                String categoria = res.getString("categoria");

                Produto produto = new Produto(id, nome, unidade, preco, quantidade, min, max, categoria);
                minhaLista.add(produto);
            }

            res.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    /**
     * Retorna o maior ID de produto registrado no banco de dados.
     *
     * @return o maior valor de ID encontrado
     */
    public int MaiorID() {
        Conexao conexao = new Conexao();
        int MaiorID = 0;

        try (Connection conn = conexao.conectar()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id from produto");
            res.next();
            MaiorID = res.getInt("id");
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return MaiorID;
    }

    /**
     * Retorna todas as categorias distintas cadastradas nos produtos.
     *
     * @return lista de nomes de categorias
     */
    public ArrayList<String> buscarCategorias() {
        ArrayList<String> lista = new ArrayList<>();
        Conexao conexao = new Conexao();

        String sql = "SELECT DISTINCT categoria FROM produto ORDER BY categoria";

        try (Connection conn = conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("categoria"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar categorias: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Busca produtos pertencentes a uma categoria específica.
     *
     * @param categoria nome da categoria
     * @return lista de produtos da categoria informada
     * @throws SQLException se ocorrer erro na execução da consulta
     */
    public List<Produto> buscarPorCategoria(String categoria) throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE categoria = ?";

        try (Connection conn = new Conexao().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("unidade"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getInt("min"),
                        rs.getInt("max"),
                        rs.getString("categoria")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    /**
     * Busca produtos cujo nome contenha o texto informado.
     *
     * @param nome parte do nome a ser pesquisada
     * @return lista de produtos encontrados
     * @throws SQLException se ocorrer erro na execução da consulta
     */
    public List<Produto> buscarPorNome(String nome) throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        try (Connection conn = new Conexao().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("unidade"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getInt("min"),
                        rs.getInt("max"),
                        rs.getString("categoria")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    /**
     * Busca produtos pelo nome e categoria simultaneamente.
     *
     * @param nome parte do nome do produto
     * @param categoria categoria do produto
     * @return lista de produtos que correspondem aos filtros
     * @throws SQLException se ocorrer erro na execução da consulta
     */
    public List<Produto> buscarPorNomeECategoria(String nome, String categoria) throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE nome LIKE ? AND categoria = ?";
        try (Connection conn = new Conexao().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("unidade"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getInt("min"),
                        rs.getInt("max"),
                        rs.getString("categoria")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    /**
     * Registra a entrada de um produto no estoque e grava a movimentação no
     * banco de dados.
     *
     * @param produtoId ID do produto
     * @param quantidadeEntrada quantidade adicionada
     * @param observacao observação opcional da movimentação
     * @return {@code true} se a operação foi bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean RegistrarEntradaProduto(int produtoId, int quantidadeEntrada, String observacao) {
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            conn.setAutoCommit(false); // Iniciar transação

            // 1. Atualizar quantidade do produto
            String sqlUpdateProduto = "UPDATE produto SET quantidade = quantidade + ? WHERE id = ?";
            try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdateProduto)) {
                stmtUpdate.setInt(1, quantidadeEntrada);
                stmtUpdate.setInt(2, produtoId);
                int linhasAfetadas = stmtUpdate.executeUpdate();

                if (linhasAfetadas == 0) {
                    conn.rollback();
                    return false;
                }
            }

            // 2. Registrar na tabela de movimentação
            String sqlInsertMovimentacao = "INSERT INTO registro_movimentacao (produto_id, tipo_movimentacao, quantidade, observacao, data_movimentacao) VALUES (?, 'Entrada', ?, ?, CURDATE())";
            try (PreparedStatement stmtMovimentacao = conn.prepareStatement(sqlInsertMovimentacao)) {
                stmtMovimentacao.setInt(1, produtoId);
                stmtMovimentacao.setInt(2, quantidadeEntrada);
                stmtMovimentacao.setString(3, observacao);
                stmtMovimentacao.executeUpdate();
            }

            conn.commit(); // Confirmar transação
            System.out.println("Entrada registrada com sucesso para produto ID: " + produtoId);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao registrar entrada: " + e.getMessage());
            return false;
        }
    }

    /**
     * Registra a saída de um produto do estoque e grava a movimentação no banco
     * de dados.
     *
     * @param produtoId ID do produto
     * @param quantidadeSaida quantidade removida
     * @param observacao observação opcional da movimentação
     * @return {@code true} se a operação foi bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean RegistrarSaidaProduto(int produtoId, int quantidadeSaida, String observacao) {
        Conexao conexao = new Conexao();
        Produto produto = ProcurarProdutoID(produtoId);

        if (produto.getId() == 0) {
            System.out.println("Produto não encontrado: ID " + produtoId);
            return false;
        }

        if (produto.getQuantidade() < quantidadeSaida) {
            System.out.println("Quantidade insuficiente para produto: " + produto.getNome());
            return false;
        }

        try (Connection conn = conexao.conectar()) {
            conn.setAutoCommit(false); // Iniciar transação

            // 1. Atualizar quantidade do produto
            String sqlUpdateProduto = "UPDATE produto SET quantidade = quantidade - ? WHERE id = ?";
            try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdateProduto)) {
                stmtUpdate.setInt(1, quantidadeSaida);
                stmtUpdate.setInt(2, produtoId);
                int linhasAfetadas = stmtUpdate.executeUpdate();

                if (linhasAfetadas == 0) {
                    conn.rollback();
                    return false;
                }
            }

            // 2. Registrar na tabela de movimentação
            String sqlInsertMovimentacao = "INSERT INTO registro_movimentacao (produto_id, tipo_movimentacao, quantidade, observacao, data_movimentacao) VALUES (?, 'Saída', ?, ?, CURDATE())";
            try (PreparedStatement stmtMovimentacao = conn.prepareStatement(sqlInsertMovimentacao)) {
                stmtMovimentacao.setInt(1, produtoId);
                stmtMovimentacao.setInt(2, quantidadeSaida);
                stmtMovimentacao.setString(3, observacao);
                stmtMovimentacao.executeUpdate();
            }

            conn.commit(); // Confirmar transação
            System.out.println("Saída registrada com sucesso para produto ID: " + produtoId);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao registrar saída: " + e.getMessage());
            return false;
        }
    }
}
