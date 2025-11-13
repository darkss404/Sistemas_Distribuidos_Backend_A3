package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Produto;

/**
 * Interface remota responsável pelos serviços de manipulação de produtos no
 * sistema de gestão de estoque.
 *
 * Define as operações que podem ser realizadas remotamente via RMI, incluindo o
 * cadastro, exclusão, consulta e movimentação (entrada/saída) de produtos.
 *
 * Responsabilidades
 * 
 * Cadastrar novos produtos no sistema.
 * Excluir produtos existentes.
 * Listar e buscar produtos por nome ou ID.
 * Registrar entradas e saídas de estoque.
 *
 *
 * 
 * As classes que implementarem esta interface deverão lidar com a comunicação
 * remota e as operações de persistência no banco de dados.
 *
 * @author Hector
 * @version 1.0
 * @see modelo.Produto
 * @see service.EstoqueService
 */
public interface ProdutoService extends Remote {

    /**
     * Cadastra ou atualiza um produto no sistema de estoque.
     *
     * @param produto o objeto {@link Produto} a ser salvo.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    void salvarProduto(Produto produto) throws RemoteException;

    /**
     * Exclui um produto com base no seu identificador.
     *
     * @param id o ID do produto a ser removido.
     * @return {@code true} se o produto for excluído com sucesso, {@code false}
     * caso contrário.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    boolean DeletarProdutoID(int id) throws RemoteException;

    /**
     * Retorna uma lista com todos os produtos cadastrados no sistema.
     *
     * @return uma lista de objetos {@link Produto}.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    List<Produto> listarProdutos() throws RemoteException;

    /**
     * Busca um produto específico pelo seu identificador único.
     *
     * @param id o ID do produto.
     * @return o objeto {@link Produto} correspondente, ou {@code null} se não
     * encontrado.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    Produto buscarProdutoPorId(int id) throws RemoteException;

    /**
     * Busca um produto pelo nome.
     *
     * @param nome o nome do produto a ser buscado.
     * @return o objeto {@link Produto} correspondente, ou {@code null} se não
     * encontrado.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    Produto buscarProdutoPorNome(String nome) throws RemoteException;

    /**
     * Registra uma entrada de produtos no estoque (aumenta a quantidade
     * disponível).
     *
     * @param idProduto o ID do produto que receberá a entrada.
     * @param quantidade a quantidade a ser adicionada.
     * @return {@code true} se a entrada for registrada com sucesso,
     * {@code false} caso contrário.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException;

    /**
     * Registra uma saída de produtos do estoque (reduz a quantidade
     * disponível).
     *
     * @param idProduto o ID do produto que terá a saída registrada.
     * @param quantidade a quantidade a ser removida.
     * @return {@code true} se a saída for registrada com sucesso, {@code false}
     * caso contrário.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException;
}
