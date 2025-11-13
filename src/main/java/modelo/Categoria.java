package modelo;

import java.io.Serializable;

/**
 * Representa uma categoria de produtos no sistema de estoque.
 *
 * Cada categoria possui um identificador único, um nome, um tamanho e um tipo
 * de embalagem. Essa classe é serializável, o que permite que seus objetos
 * sejam salvos ou transmitidos.
 *
 * @author Hector
 * @version 1.0
 */
public class Categoria implements Serializable {

    /**
     * Identificador de versão da classe para serialização.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador único da categoria.
     */
    private int id;
    /**
     * Nome da categoria (ex: Bebidas, Laticínios, Limpeza).
     */
    private String nomeCategoria;
    /**
     * Tamanho padrão associado à categoria (ex: 500ml, 1kg).
     */
    private String tamanho;
    /**
     * Tipo de embalagem utilizado (ex: Garrafa, Caixa, Saco).
     */
    private String embalagem;

    /**
     * Construtor completo da classe.
     *
     * @param id identificador único da categoria.
     * @param nomeCategoria nome da categoria.
     * @param tamanho tamanho padrão dos produtos da categoria.
     * @param embalagem tipo de embalagem associada à categoria.
     */
    public Categoria(int id, String nomeCategoria, String tamanho, String embalagem) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    /**
     * Construtor alternativo usado quando o ID ainda não foi definido
     * (geralmente antes do cadastro no banco).
     *
     * @param nomeCategoria nome da categoria.
     * @param tamanho tamanho padrão dos produtos da categoria.
     * @param embalagem tipo de embalagem associada à categoria.
     */
    public Categoria(String nomeCategoria, String tamanho, String embalagem) {
        this(0, nomeCategoria, tamanho, embalagem);
    }

    /**
     * Retorna o identificador da categoria.
     *
     * @return o ID da categoria.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da categoria.
     *
     * @param id novo ID da categoria.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome da categoria.
     *
     * @return o nome da categoria.
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * Define o nome da categoria.
     *
     * @param nome novo nome da categoria.
     */
    public void setNomeCategoria(String nome) {
        this.nomeCategoria = nome;
    }

    @Override
    public String toString() {
        return nomeCategoria;
    }

    /**
     * Retorna o tamanho associado à categoria.
     *
     * @return o tamanho.
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho associado à categoria.
     *
     * @param tamanho novo tamanho.
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna o tipo de embalagem da categoria.
     *
     * @return a embalagem.
     */
    public String getEmbalagem() {
        return embalagem;
    }

    /**
     * Define o tipo de embalagem da categoria.
     *
     * @param embalagem nova embalagem.
     */
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
}
