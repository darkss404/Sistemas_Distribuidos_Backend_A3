package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Produto;
import modelo.Categoria;
import modelo.RegistroMovimentacao;

public interface EstoqueService extends Remote {

    void salvarProduto(Produto produto) throws RemoteException;

    boolean DeletarProdutoID(int id) throws RemoteException;
    List<Produto> listarProdutos() throws RemoteException;

    void salvarCategoria(Categoria categoria) throws RemoteException;
    List<Categoria> listarCategorias() throws RemoteException;

    void excluirCategoria(int id) throws RemoteException;

    Produto buscarProdutoPorId(int id) throws RemoteException;

    Produto buscarProdutoPorNome(String nome) throws RemoteException;

    boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException;

    boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException;
    List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException;
}
