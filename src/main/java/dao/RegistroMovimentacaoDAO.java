package dao;

import modelo.RegistroMovimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar as operações de banco de dados relacionadas
 * à tabela {@code registro_movimentacao}.
 *
 * Ela permite registrar novas movimentações de entrada e saída de produtos,
 * além de listar movimentações existentes.
 */
public class RegistroMovimentacaoDAO {

    /**
     * Registra uma nova movimentação no banco de dados (entrada ou saída).
     *
     * @param registro objeto {@link RegistroMovimentacao} contendo os dados da
     * movimentação.
     * @return {@code true} se a movimentação for registrada com sucesso,
     * {@code false} caso contrário.
     */
    public boolean registrarMovimentacao(RegistroMovimentacao registro) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO registro_movimentacao (produto_id, tipo_movimentacao, quantidade, observacao, data_movimentacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.conectar(); PreparedStatement st = conn.prepareStatement(sql)) {

            // Usar a data do registro em vez de sempre a data atual
            LocalDate dataMovimentacao = registro.getDataMovimentacao() != null
                    ? LocalDate.parse(registro.getDataMovimentacao()) : LocalDate.now();

            System.out.println("Inserindo movimentação no banco...");
            System.out.println("Produto ID: " + registro.getProdutoId());
            System.out.println("Tipo: " + registro.getTipoMovimentacao());
            System.out.println("Quantidade: " + registro.getQuantidade());
            System.out.println("Data: " + dataMovimentacao);

            st.setInt(1, registro.getProdutoId());
            st.setString(2, registro.getTipoMovimentacao());
            st.setInt(3, registro.getQuantidade());
            st.setString(4, registro.getObservacao());
            st.setDate(5, java.sql.Date.valueOf(dataMovimentacao));

            int rowsAffected = st.executeUpdate();
            conn.commit(); // Adicionar commit explícito

            System.out.println("Registro inserido com sucesso. Linhas afetadas: " + rowsAffected);
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao registrar movimentação no banco de dados: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lista todas as movimentações registradas no banco de dados, ordenadas por
     * data e ID.
     *
     * @return uma lista de objetos {@link RegistroMovimentacao} representando
     * todas as movimentações.
     */
    public List<RegistroMovimentacao> listarTodasMovimentacoes() {
        List<RegistroMovimentacao> listaMovimentacoes = new ArrayList<>();
        Conexao conexao = new Conexao();
        String sql = "SELECT id, produto_id, tipo_movimentacao, quantidade, observacao, data_movimentacao FROM registro_movimentacao ORDER BY data_movimentacao DESC, id DESC";

        try (Connection conn = conexao.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int produtoId = rs.getInt("produto_id");
                String tipoMovimentacao = rs.getString("tipo_movimentacao");
                int quantidade = rs.getInt("quantidade");
                String observacao = rs.getString("observacao");
                java.sql.Date sqlDate = rs.getDate("data_movimentacao");
                String dataMovimentacao = sqlDate != null ? sqlDate.toLocalDate().toString() : LocalDate.now().toString();

                RegistroMovimentacao registro = new RegistroMovimentacao(
                        id, produtoId, tipoMovimentacao, quantidade, observacao, dataMovimentacao
                );
                listaMovimentacoes.add(registro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar movimentações: " + e.getMessage());
            e.printStackTrace();
        }
        return listaMovimentacoes;
    }

    /**
     * Lista todas as movimentações relacionadas a um produto específico.
     *
     * @param produtoId o identificador do produto.
     * @return uma lista de {@link RegistroMovimentacao} associadas ao produto
     * informado.
     */
    public List<RegistroMovimentacao> listarMovimentacoesPorProduto(int produtoId) {
        List<RegistroMovimentacao> listaMovimentacoes = new ArrayList<>();
        Conexao conexao = new Conexao();
        String sql = "SELECT id, produto_id, tipo_movimentacao, quantidade, observacao, data_movimentacao FROM registro_movimentacao WHERE produto_id = ? ORDER BY data_movimentacao DESC, id DESC";

        try (Connection conn = conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String tipoMovimentacao = rs.getString("tipo_movimentacao");
                    int quantidade = rs.getInt("quantidade");
                    String observacao = rs.getString("observacao");
                    java.sql.Date sqlDate = rs.getDate("data_movimentacao");
                    String dataMovimentacao = sqlDate != null ? sqlDate.toLocalDate().toString() : LocalDate.now().toString();

                    RegistroMovimentacao registro = new RegistroMovimentacao(id, produtoId, tipoMovimentacao, quantidade, observacao, dataMovimentacao);
                    listaMovimentacoes.add(registro);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar movimentações por produto: " + e.getMessage());
            e.printStackTrace();
        }
        return listaMovimentacoes;
    }
}
