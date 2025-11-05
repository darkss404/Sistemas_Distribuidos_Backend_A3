package visao;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Produto;
import javax.swing.JFrame;



public class FrmCadastrodeProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName());
    
    private FrmListadeProduto telaLista;
    
    public FrmCadastrodeProduto(JFrame telaAnterior) {
        initComponents();
        this.telaAnterior = telaAnterior;
        JCBCategoria.setEditable(false);
        carregarCategoriasDoBanco();
    }

// Para edição
    public FrmCadastrodeProduto(JFrame telaAnterior, Produto produto) {
        initComponents();
        this.telaAnterior = telaAnterior;
        this.produtoEmEdicao = produto;
        JCBCategoria.setEditable(false);
        carregarCategoriasDoBanco();

        JTFNome.setText(produto.getNome());
        JTFUnidade.setText(produto.getUnidade());
        JTFPreco.setText(String.valueOf(produto.getPreco()));
        JTFQuantidade.setText(String.valueOf(produto.getQuantidade()));
        JTFMin.setText(String.valueOf(produto.getMin()));
        JTFMax.setText(String.valueOf(produto.getMax()));
        JCBCategoria.setSelectedItem(produto.getCategoria());
        JBSalvar.setText("Atualizar");
    }
        
        
    
    private Produto produtoEmEdicao;
    
    private javax.swing.JFrame telaAnterior;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFPreco = new javax.swing.JTextField();
        JTFMax = new javax.swing.JTextField();
        JTFUnidade = new javax.swing.JTextField();
        JTFQuantidade = new javax.swing.JTextField();
        JTFMin = new javax.swing.JTextField();
        JBSalvar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        JCBCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nome.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Unidade");

        jLabel4.setText("Quantidade");

        jLabel5.setText("Categoria");

        jLabel6.setText("Minimo");

        jLabel7.setText("Maximo");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        JBSalvar.setText("Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        JBCancelar.setBackground(new java.awt.Color(220, 53, 69));
        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Alimentos", "Higiene", "Limpeza" }));
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(JBSalvar)
                        .addGap(39, 39, 39)
                        .addComponent(JBCancelar)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalvar)
                    .addComponent(JBCancelar))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalvarActionPerformed
        if (JTFNome.getText().isEmpty()
                || JTFUnidade.getText().isEmpty()
                || JTFPreco.getText().isEmpty()
                || JTFQuantidade.getText().isEmpty()
                || JTFMin.getText().isEmpty()
                || JTFMax.getText().isEmpty()
                || JCBCategoria.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this,
                    "Por favor, preencha todos os campos antes de salvar.",
                    "Campos obrigatórios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(JTFPreco.getText());
            int quantidade = Integer.parseInt(JTFQuantidade.getText());
            int min = Integer.parseInt(JTFMin.getText());
            int max = Integer.parseInt(JTFMax.getText());

            if (preco < 0 || quantidade < 0) {
                JOptionPane.showMessageDialog(this,
                        "Preço e quantidade não podem ser negativos.",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (min > max) {
                JOptionPane.showMessageDialog(this,
                        "O valor mínimo não pode ser maior que o máximo.",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nome = JTFNome.getText();
            String unidade = JTFUnidade.getText();
            String categoria = JCBCategoria.getSelectedItem().toString();

            ProdutoDAO dao = new ProdutoDAO();
            boolean sucesso;

            if (produtoEmEdicao == null) {
                Produto novoProduto = new Produto(0, nome, unidade, preco, quantidade, min, max, categoria);
                sucesso = dao.CadastrarProduto(novoProduto);
            } else {
                produtoEmEdicao.setNome(nome);
                produtoEmEdicao.setUnidade(unidade);
                produtoEmEdicao.setPreco(preco);
                produtoEmEdicao.setQuantidade(quantidade);
                produtoEmEdicao.setMin(min);
                produtoEmEdicao.setMax(max);
                produtoEmEdicao.setCategoria(categoria);
                sucesso = dao.AtualizarProduto(produtoEmEdicao);
            }

            if (sucesso) {
                JOptionPane.showMessageDialog(this,
                        produtoEmEdicao == null ? "Produto cadastrado com sucesso!" : "Produto atualizado com sucesso!");

                if (telaAnterior instanceof FrmListaDePreco precoTela) {
                    precoTela.carregarTabela(); 
                    precoTela.setVisible(true);
                } else if (telaAnterior instanceof FrmListadeProduto produtoTela) {
                    produtoTela.carregarTabelaProdutos(); 
                    produtoTela.setVisible(true);
                }
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this,
                        "Erro ao cadastrar produto.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro: Preço, Quantidade, Mínimo e Máximo devem conter apenas números válidos.",
                    "Erro de validação",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBSalvarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBCategoriaActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmCadastrodeProduto((javax.swing.JFrame) null, null).setVisible(true));
    }
    
    private void carregarCategoriasDoBanco() {
    try {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> lista = dao.listarCategorias();
        JCBCategoria.removeAllItems();
        for (Categoria c : lista) {
            JCBCategoria.addItem(c.getNomeCategoria());
        }

        if (produtoEmEdicao != null) {
            String cat = produtoEmEdicao.getCategoria();
            boolean existe = false;
            for (int i = 0; i < JCBCategoria.getItemCount(); i++) {
                if (JCBCategoria.getItemAt(i).equals(cat)) {
                    existe = true;
                    break;
                }
            }
            if (!existe && cat != null && !cat.isBlank()) {
                JCBCategoria.addItem(cat);
            }
            JCBCategoria.setSelectedItem(cat);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
    }
  }
  
    private void limparCampos() {
        JTFNome.setText("");
        JTFPreco.setText("");
        JTFUnidade.setText("");
        JTFQuantidade.setText("");
        JTFMin.setText("");
        JTFMax.setText("");
        JCBCategoria.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JTextField JTFMax;
    private javax.swing.JTextField JTFMin;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTextField JTFUnidade;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
