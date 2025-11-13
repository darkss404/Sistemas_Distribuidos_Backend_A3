
package modelo;

import java.io.Serializable;
/**
 * Representa um registro de movimentação de estoque.
 * Cada movimentação corresponde a uma entrada ou saída de produtos, 
 * armazenando informações sobre o tipo, quantidade, data e observações.
 * Esta classe é utilizada para manter o histórico de movimentações
 * de produtos, facilitando o controle e auditoria do estoque.
 * 
 * @author Hector
 * @version 1.0
 */
public class RegistroMovimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
     /** Identificador único do registro de movimentação. */
    private int id;
    /** Identificador do produto relacionado à movimentação. */
    private int produtoId;
    /** Tipo da movimentação (ex: "entrada" ou "saída"). */
    private String tipoMovimentacao;
     /** Quantidade de itens movimentados. */
    private int quantidade;
    /** Observação adicional sobre a movimentação. */
    private String observacao;
    /** Data em que a movimentação foi realizada. */
    private String dataMovimentacao;
    /**
     * Construtor padrão.
     * Inicializa um objeto vazio de {@code RegistroMovimentacao}.
     */
    public RegistroMovimentacao() {
    }
     /**
     * Construtor completo.
     * 
     * @param id identificador do registro
     * @param produtoId identificador do produto movimentado
     * @param tipoMovimentacao tipo da movimentação (entrada ou saída)
     * @param quantidade quantidade movimentada
     * @param observacao observação adicional
     * @param dataMovimentacao data da movimentação
     */
    public RegistroMovimentacao(int id, int produtoId, String tipoMovimentacao, int quantidade, String observacao, String dataMovimentacao) {
        this.id = id;
        this.produtoId = produtoId;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataMovimentacao = dataMovimentacao;
    }
 /** @return o ID do registro */
    public int getId() {
        return id;
    }
 /** @param id define o ID do registro */
    public void setId(int id) {
        this.id = id;
    }
/** @return o ID do produto movimentado */
    public int getProdutoId() {
        return produtoId;
    }
/** @param produtoId define o ID do produto movimentado */
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
 /** @return o tipo da movimentação (entrada ou saída) */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
  /** @param tipoMovimentacao define o tipo da movimentação (entrada ou saída) */
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
/** @return a quantidade movimentada */
    public int getQuantidade() {
        return quantidade;
    }
/** @param quantidade define a quantidade movimentada */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 /** @return observação da movimentação */
    public String getObservacao() {
        return observacao;
    }
/** @param observacao define observações adicionais */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
     /** @return data em que a movimentação foi realizada */
    public String getDataMovimentacao() {
    return dataMovimentacao;
}
/** @param dataMovimentacao define a data da movimentação */
public void setDataMovimentacao(String dataMovimentacao) {
    this.dataMovimentacao = dataMovimentacao;
}
    /**
     * Retorna uma representação textual do registro de movimentação.
     * 
     * @return string contendo os principais dados da movimentação
     */
    @Override
    public String toString(){
        return "RegistroMovimentacao{"+
                "id ="+id+
                ",produto id ="+ produtoId+
                ",tipoMovimentacao="+ tipoMovimentacao +'\''+
                "quantidade ="+quantidade+
                "observacao="+observacao+ '\''+
                ", dataMovimentacao='" + dataMovimentacao + '\'' +
            '}';
    }
    
}
