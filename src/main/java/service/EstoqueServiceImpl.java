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

public class EstoqueServiceImpl extends UnicastRemoteObject implements EstoqueService {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final RegistroMovimentacaoDAO registroDAO = new RegistroMovimentacaoDAO();

    public EstoqueServiceImpl() throws RemoteException {
        super();
    }

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

    @Override
    public boolean DeletarProdutoID(int idProduto) throws RemoteException {
        try {
            return produtoDAO.DeletarProdutoID(idProduto);
        } catch (Exception e) {
            throw new RemoteException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Produto> listarProdutos() throws RemoteException {
        try {
            ArrayList<Produto> lista = produtoDAO.getMinhaListaProdutos();
            return lista != null ? lista : new ArrayList<>();
        } catch (Exception e) {
            throw new RemoteException("Erro ao listar produtos.", e);
        }
    }

    @Override
    public Produto buscarProdutoPorId(int id) throws RemoteException {
        try {
            return produtoDAO.ProcurarProdutoID(id);
        } catch (Exception e) {
            throw new RemoteException("Erro ao buscar produto por ID.", e);
        }
    }

    @Override
    public Produto buscarProdutoPorNome(String nome) throws RemoteException {
        try {
            return produtoDAO.ProcurarProdutoNome(nome);
        } catch (Exception e) {
            throw new RemoteException("Erro ao buscar produto por nome", e);
        }
    }

    @Override
    public boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException {
        try {
            // Usar o método corrigido do ProdutoDAO que registra na tabela de movimentação
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

    @Override
    public boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException {
        try {
            // Usar o método corrigido do ProdutoDAO que registra na tabela de movimentação
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

    @Override
    public void salvarCategoria(Categoria categoria) throws RemoteException {
        try {
            categoriaDAO.salvar(categoria);
        } catch (SQLException e) {
            throw new RemoteException("Erro ao salvar categoria.", e);
        }
    }

    @Override
    public List<Categoria> listarCategorias() throws RemoteException {
        try {
            return categoriaDAO.listarCategorias();
        } catch (SQLException e) {
            throw new RemoteException("Erro ao listar categorias.", e);
        }
    }

    @Override
    public void excluirCategoria(int id) throws RemoteException {
        try {
            categoriaDAO.excluir(id);
        } catch (Exception e) {
            throw new RemoteException("Erro ao excluir categoria.", e);
        }
    }

    @Override
    public List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException {
        try {
            return registroDAO.listarTodasMovimentacoes();
        } catch (Exception e) {
            throw new RemoteException("Erro ao listar movimentações: " + e.getMessage(), e);
        }
    }
}