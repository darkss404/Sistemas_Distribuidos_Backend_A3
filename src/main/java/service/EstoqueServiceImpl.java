package service;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import dao.RegistroMovimentacaoDAO;
import modelo.Categoria;
import modelo.Produto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistroMovimentacao;

/**
 * Implementação do serviço remoto de estoque que integra as funcionalidades de
 * produtos, categorias e movimentações.
 *
 * Esta classe é responsável por gerenciar as operações do sistema de estoque
 * através do RMI (Remote Method Invocation), servindo como ponte entre o
 * cliente e os DAOs responsáveis pela persistência no banco de dados.
 *
 * Responsabilidades:
 * Gerenciar produtos (CRUD e movimentações de entrada/saída).
 * Gerenciar categorias de produtos.
 * Registrar e listar movimentações de estoque.
 *
 *
 * Implementa as interfaces:
 * {@link ProdutoService}, {@link CategoriaService}, {@link MovimentacaoService}
 * e {@link EstoqueService}.
 *
 * @author Hector
 * @version 1.0
 * @see ProdutoDAO
 * @see CategoriaDAO
 * @see RegistroMovimentacaoDAO
 */
public class EstoqueServiceImpl extends UnicastRemoteObject implements EstoqueService, ProdutoService, CategoriaService, MovimentacaoService {

    /**
     * DAO responsável pela manipulação dos dados de produtos.
     */
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    /**
     * DAO responsável pela manipulação dos dados de categorias.
     */
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    /**
     * DAO responsável pelo registro e consulta de movimentações.
     */
    private final RegistroMovimentacaoDAO registroDAO = new RegistroMovimentacaoDAO();

    /**
     * Construtor padrão que inicializa o serviço remoto de estoque.
     *
     * @throws RemoteException se ocorrer um erro ao exportar o objeto remoto.
     */
    public EstoqueServiceImpl() throws RemoteException {
        super();
    }

// ==================== IMPLEMENTAÇÃO DE ProdutoService ====================
    /**
     * {@inheritDoc}
     */
    @Override
    public void salvarProduto(Produto produto) throws RemoteException {
        try {
            boolean sucesso = produtoDAO.CadastrarProduto(produto);
            if (!sucesso) {
                throw new RemoteException("Erro ao cadastrar produto no banco.");
            }
        } catch (Exception e) {
            throw new RemoteException("Falha ao salvar produto.", e);
        }
    }

    // MÉTODO CORRIGIDO - MANTIDO O NOME ORIGINAL
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean DeletarProdutoID(int idProduto) throws RemoteException {
        try {
            return produtoDAO.DeletarProdutoID(idProduto);
        } catch (Exception e) {
            throw new RemoteException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Produto> listarProdutos() throws RemoteException {
        try {
            ArrayList<Produto> lista = produtoDAO.getMinhaListaProdutos();
            return lista != null ? lista : new ArrayList<>();
        } catch (Exception e) {
            throw new RemoteException("Erro ao listar produtos.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Produto buscarProdutoPorId(int id) throws RemoteException {
        try {
            return produtoDAO.ProcurarProdutoID(id);
        } catch (Exception e) {
            throw new RemoteException("Erro ao buscar produto por ID.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Produto buscarProdutoPorNome(String nome) throws RemoteException {
        try {
            return produtoDAO.ProcurarProdutoNome(nome);
        } catch (Exception e) {
            throw new RemoteException("Erro ao buscar produto por nome", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException {
        try {
            boolean sucesso = produtoDAO.RegistrarEntradaProduto(idProduto, quantidade, "Entrada via sistema");

            if (sucesso) {
                System.out.println("Entrada registrada com sucesso para produto ID: " + idProduto);
                return true;
            } else {
                System.out.println("Falha ao registrar entrada para produto ID: " + idProduto);
                return false;
            }

        } catch (Exception e) {
            throw new RemoteException("Erro ao registrar entrada: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException {
        try {
            boolean sucesso = produtoDAO.RegistrarSaidaProduto(idProduto, quantidade, "Saída via sistema");

            if (sucesso) {
                System.out.println("Saída registrada com sucesso para produto ID: " + idProduto);
                return true;
            } else {
                System.out.println("Falha ao registrar saída para produto ID: " + idProduto);
                return false;
            }

        } catch (Exception e) {
            throw new RemoteException("Erro ao registrar saída: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void salvarCategoria(Categoria categoria) throws RemoteException {
        try {
            categoriaDAO.salvar(categoria);
        } catch (SQLException e) {
            throw new RemoteException("Erro ao salvar categoria.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Categoria> listarCategorias() throws RemoteException {
        try {
            return categoriaDAO.listarCategorias();
        } catch (SQLException e) {
            throw new RemoteException("Erro ao listar categorias.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirCategoria(int id) throws RemoteException {
        try {
            categoriaDAO.excluir(id);
        } catch (Exception e) {
            throw new RemoteException("Erro ao excluir categoria.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException {
        try {
            return registroDAO.listarTodasMovimentacoes();
        } catch (Exception e) {
            throw new RemoteException("Erro ao listar movimentações: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registrarMovimentacao(RegistroMovimentacao registro) throws RemoteException {
        try {
            return registroDAO.registrarMovimentacao(registro);
        } catch (Exception e) {
            throw new RemoteException("Erro ao registrar movimentação: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RegistroMovimentacao> listarMovimentacoesPorProduto(int produtoId) throws RemoteException {
        try {
            return registroDAO.listarMovimentacoesPorProduto(produtoId);
        } catch (Exception e) {
            throw new RemoteException("Erro ao listar movimentações por produto: " + e.getMessage(), e);
        }
    }
}
