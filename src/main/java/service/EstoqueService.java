package service;

import java.rmi.Remote;
/**
 * Interface remota principal do sistema de estoque.
 *
 * Esta interface atua como um ponto de acesso unificado para os serviços de
 * {@link ProdutoService}, {@link CategoriaService} e
 * {@link MovimentacaoService}. Ela é utilizada para permitir que o cliente RMI
 * acesse todas as operações do sistema por meio de um único objeto remoto.
 *
 * Como estende {@link Remote}, todos os métodos definidos nas interfaces
 * herdadas podem ser invocados remotamente.
 *
 * @author Hector
 * @version 1.0
 * @see ProdutoService
 * @see CategoriaService
 * @see MovimentacaoService
 */
public interface EstoqueService extends Remote, ProdutoService, CategoriaService, MovimentacaoService {

}