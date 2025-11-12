package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Produto;

public interface ProdutoService extends Remote {
    void salvarProduto(Produto produto) throws RemoteException;
    boolean DeletarProdutoID(int id) throws RemoteException;
    List<Produto> listarProdutos() throws RemoteException;
    Produto buscarProdutoPorId(int id) throws RemoteException;
    Produto buscarProdutoPorNome(String nome) throws RemoteException;
    boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException;
    boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException;
}