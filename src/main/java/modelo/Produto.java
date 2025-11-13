package modelo;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Representa um produto no sistema de estoque. Contém informações sobre
 * identificação, categoria, preço, quantidades e regras de controle de estoque.
 *
 * @author Hector
 * @version 1.0
 */
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único do produto.
     */
    private int id;
    /**
     * Nome do produto.
     */
    private String nome;
    /**
     * Unidade de medida (ex: kg, unidade, litro).
     */
    private String unidade;
    /**
     * Preço unitário do produto.
     */
    private double preco;
    /**
     * Quantidade atual em estoque.
     */
    private int quantidade;
    /**
     * Quantidade mínima permitida em estoque.
     */
    private int min;
    /**
     * Quantidade máxima permitida em estoque.
     */
    private int max;
    /**
     * Categoria à qual o produto pertence.
     */
    private String categoria;

    /**
     * Construtor padrão. Inicializa o produto com valores padrão.
     */
    public Produto() {
        this(0, "", "", 0.0, 0, 0, 1000, "");
    }

    /**
     * Construtor completo.
     *
     * @param id identificador do produto
     * @param nome nome do produto
     * @param unidade unidade de medida
     * @param preco preço do produto
     * @param quantidade quantidade atual em estoque
     * @param min quantidade mínima permitida
     * @param max quantidade máxima permitida
     * @param categoria categoria do produto
     */
    public Produto(int id, String nome, String unidade, double preco, int quantidade, int min, int max, String categoria) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
        this.quantidade = quantidade;
        this.min = min;
        this.max = max;
        this.categoria = categoria;
    }

    /**
     * @return o ID do produto
     */
    public int getId() {
        return id;
    }

    /**
     * @param id define o ID do produto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return o nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome define o nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return a unidade de medida do produto
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade define a unidade de medida
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return o preço do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco define o preço do produto
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return quantidade atual em estoque
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade define a quantidade atual em estoque
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return a quantidade mínima
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min define a quantidade mínima
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return a quantidade máxima
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max define a quantidade máxima
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return a categoria do produto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param nomeCategoria define a categoria do produto
     */
    public void setCategoria(String nomeCategoria) {
        this.categoria = nomeCategoria;
    }

    /**
     * Retorna o nome do produto como representação textual.
     *
     * @return nome do produto
     */
    @Override
    public String toString() {
        return this.nome;
    }

    /**
     * Verifica se a quantidade atual do produto está dentro dos limites.
     *
     * @return mensagem indicando se a quantidade está adequada, baixa ou alta
     */
    public String VerificacaoDeQuantidade() {
        if (this.getQuantidade() < this.getMin()) {
            return "A quantidade do produto: " + getNome() + " /está muito baixa, a quantidade minima é " + getMin() + " unidades";

        } else if (this.getQuantidade() > this.getMax()) {
            return "A quantidade do produto:" + getNome() + " /é muito alta, a quantidade máxima é " + getMax() + " unidades";
        } else {
            return "produto registrado com sucesso. A quantidade é " + getQuantidade() + " unidades";
        }
    }

    /**
     * Cadastra um produto com os parâmetros informados.
     *
     * @param id identificador do produto
     * @param nome nome do produto
     * @param unidade unidade de medida
     * @param quantidade quantidade atual
     * @param preco preço unitário
     * @param min quantidade mínima
     * @param max quantidade máxima
     * @param categoria categoria do produto
     */
    public void cadastrarProduto(int id, String nome, String unidade, int quantidade, double preco, int min, int max, String categoria) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.preco = preco;
        this.min = min;
        this.max = max;
        this.categoria = categoria;

        System.out.println("Produto cadastrado com sucesso: " + this.nome);
    }

    /**
     * Registra a entrada de produtos no estoque.
     *
     * @param quantidade quantidade de produtos adicionados
     */
    public void RegistrarEntrada(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
            System.out.println("Entrada registrada: +" + quantidade + "unidades para o produto " + this.nome);
            System.out.println(VerificacaoDeQuantidade());

        } else {
            System.out.println("Erro: A quantidade de entrada deve ser maior que zero");
        }
    }

    /**
     * Registra a saída de produtos do estoque.
     *
     * @param quantidade quantidade de produtos removidos
     */
    public void RegistrarSaida(int quantidade) {
        if (quantidade > 0) {
            if (this.quantidade >= quantidade) {
                this.quantidade -= quantidade;
                System.out.println("Saída Registrada: -" + quantidade + " unidades do produto " + this.nome);
                System.out.println(VerificacaoDeQuantidade());

            } else {
                System.out.println("Erro: Estoque insuficente para o produto" + this.nome);
            }
        } else {
            System.out.println("Erro: Aa quantidade de saída deve ser maior que zero.");
        }

    }
}
