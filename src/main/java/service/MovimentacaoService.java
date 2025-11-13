package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.RegistroMovimentacao;

/**
 * Interface remota responsável pelos serviços relacionados às movimentações de
 * produtos no sistema de controle de estoque.
 *
 * 
 * Define os métodos que permitem registrar e consultar movimentações (entradas
 * e saídas) de produtos no estoque via RMI (Remote Method Invocation).
 *
 * Responsabilidades
 * 
 * Registrar novas movimentações de produtos (entradas ou saídas).
 * Listar todas as movimentações cadastradas.
 * Listar movimentações específicas de um produto.
 *
 * As classes que implementam esta interface devem lidar com operações remotas e
 * garantir a integridade dos dados durante as transações.
 *
 * @author Hector
 * @version 1.0
 * @see modelo.RegistroMovimentacao
 */
public interface MovimentacaoService extends Remote {

    /**
     * Lista todas as movimentações registradas no sistema de estoque.
     *
     * @return uma lista de objetos {@link RegistroMovimentacao} representando
     * todas as movimentações.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException;

    /**
     * Registra uma nova movimentação (entrada ou saída) de um produto no
     * estoque.
     *
     * @param registro objeto {@link RegistroMovimentacao} contendo os dados da
     * movimentação.
     * @return {@code true} se a movimentação for registrada com sucesso,
     * {@code false} caso contrário.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    boolean registrarMovimentacao(RegistroMovimentacao registro) throws RemoteException;

    /**
     * Lista todas as movimentações associadas a um produto específico.
     *
     * @param produtoId identificador único do produto.
     * @return uma lista de movimentações relacionadas ao produto informado.
     * @throws RemoteException se ocorrer um erro de comunicação RMI.
     */
    List<RegistroMovimentacao> listarMovimentacoesPorProduto(int produtoId) throws RemoteException;
}
