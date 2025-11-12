package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.RegistroMovimentacao;

public interface MovimentacaoService extends Remote {
    List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException;
    boolean registrarMovimentacao(RegistroMovimentacao registro) throws RemoteException;
    List<RegistroMovimentacao> listarMovimentacoesPorProduto(int produtoId) throws RemoteException;
}