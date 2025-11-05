package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Produto;
import modelo.Categoria;

public interface EstoqueService extends Remote {
    void salvarProduto(Produto produto) throws RemoteException;
    List<Produto> listarProdutos() throws RemoteException;

    void salvarCategoria(Categoria categoria) throws RemoteException;
    List<Categoria> listarCategorias() throws RemoteException;
}
