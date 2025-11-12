package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Categoria;

public interface CategoriaService extends Remote {
    void salvarCategoria(Categoria categoria) throws RemoteException;
    List<Categoria> listarCategorias() throws RemoteException;
    void excluirCategoria(int id) throws RemoteException;
}