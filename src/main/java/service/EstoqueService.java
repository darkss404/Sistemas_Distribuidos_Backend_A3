package service;

import java.rmi.Remote;

public interface EstoqueService extends Remote, ProdutoService, CategoriaService, MovimentacaoService {

}