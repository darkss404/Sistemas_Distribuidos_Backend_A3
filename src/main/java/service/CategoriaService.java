package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Categoria;

/**
 * Interface de serviço remoto responsável pelas operações relacionadas à
 * entidade {@link Categoria}.
 *
 * <p>
 * Esta interface define os métodos que podem ser acessados remotamente via RMI
 * (Remote Method Invocation) para gerenciar categorias no sistema de controle
 * de estoque.</p>
 *
 * <p>
 * Todas as operações lançam {@link RemoteException} pois envolvem comunicação
 * remota entre cliente e servidor.</p>
 *
 * @author Hector
 * @version 1.0
 * @see modelo.Categoria
 */
public interface CategoriaService extends Remote {

    /**
     * Salva uma nova categoria no sistema.
     *
     * @param categoria objeto {@link Categoria} a ser salvo
     * @throws RemoteException se ocorrer um erro de comunicação remota
     */
    void salvarCategoria(Categoria categoria) throws RemoteException;

    /**
     * Retorna uma lista com todas as categorias cadastradas.
     *
     * @return lista de objetos {@link Categoria}
     * @throws RemoteException se ocorrer um erro de comunicação remota
     */
    List<Categoria> listarCategorias() throws RemoteException;

    /**
     * Exclui uma categoria existente com base no seu identificador.
     *
     * @param id identificador único da categoria a ser excluída
     * @throws RemoteException se ocorrer um erro de comunicação remota
     */
    void excluirCategoria(int id) throws RemoteException;
}
