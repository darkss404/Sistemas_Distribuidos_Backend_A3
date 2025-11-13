package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySQL. Esta
 * classe encapsula as informações necessárias para estabelecer uma conexão
 * JDBC, como o driver, servidor, banco de dados, usuário e senha. O método
 * principal {@link #conectar()} retorna um objeto {@link Connection} ativo, que
 * pode ser utilizado pelas classes DAO para executar comandos SQL.
 *
 * @author Hector
 * @version 1.0
 */
public class Conexao {

    /**
     * Nome do driver JDBC utilizado para conectar ao MySQL.
     */
    private final String DRIVER;
    /**
     * Endereço do servidor do banco de dados.
     */
    private final String SERVER;
    /**
     * Nome do banco de dados.
     */
    private final String DATABASE;
    /**
     * URL de conexão JDBC completa.
     */
    private final String URL;
    /**
     * Nome de usuário do banco de dados.
     */
    private final String USER;

    /**
     * Senha do banco de dados.
     */
    private final String PASSWORD;

    /**
     * Construtor que inicializa os parâmetros necessários para a conexão com o
     * banco de dados MySQL.
     */
    public Conexao() {
        this.DRIVER = "com.mysql.cj.jdbc.Driver";
        this.SERVER = "localhost";
        this.DATABASE = "estoque";
        this.URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC";
        this.USER = "root";
        this.PASSWORD = "TrabalhoA3";
    }

    /**
     * Estabelece a conexão com o banco de dados MySQL. Caso a conexão seja
     * bem-sucedida, é exibida uma mensagem no console indicando que o status é
     * "Conectado!".
     *
     * @return um objeto {@link Connection} ativo, ou {@code null} se ocorrer um
     * erro
     */
    public Connection conectar() {
        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Status: Conectado!");
            return connection;

        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado: " + e.getMessage());
            //System.exit(1);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            //System.exit(1);
        }
        return null;
    }
}
