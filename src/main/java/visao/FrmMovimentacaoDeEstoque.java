
package visao;


import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;
import modelo.RegistroMovimentacao;
import dao.RegistroMovimentacaoDAO;
import java.time.LocalDate;


public class FrmMovimentacaoDeEstoque extends javax.swing.JFrame {

    private javax.swing.JFrame janelaAnterior;
   
    public FrmMovimentacaoDeEstoque(javax.swing.JFrame janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
        initComponents();
        carregarProdutosNoCombo();
        JTFData.setText(LocalDate.now().toString());
        JTFData.setEditable(false);
        javax.swing.ButtonGroup grupoTipoMovimentacao = new javax.swing.ButtonGroup();
        grupoTipoMovimentacao.add(JRBEntrada);
        grupoTipoMovimentacao.add(JRBSaida);
        atualizarTabelaMovimentacoes();
    }
    
    private void registrarMovimentacao(String tipo) {
        try {
            String nomeProduto = (String) JCBProduto.getSelectedItem();
            int quantidade = Integer.parseInt(JTFQuantidade.getText());

            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.ProcurarProdutoNome(nomeProduto);

            if (produto.getId() == 0) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
                return;
            }

            boolean sucesso = false;

            if (tipo.equals("Entrada")) {
                sucesso = produtoDAO.RegistrarEntradaProduto(produto.getId(), quantidade, "");
            } else if (tipo.equals("Saída")) {
                if (produto.getQuantidade() < quantidade) {
                    JOptionPane.showMessageDialog(this, "Estoque insuficiente para saída.");
                    return;
                }
                sucesso = produtoDAO.RegistrarSaidaProduto(produto.getId(), quantidade, "");
            }

            if (sucesso) {
                // Criação do registro de movimentação
                RegistroMovimentacao registro = new RegistroMovimentacao(
                        0, // id (auto-incremento no banco)
                        produto.getId(), // produto_id
                        tipo, // tipo_movimentacao
                        quantidade, // quantidade
                        "", // observacao (vazio)
                        LocalDate.now().toString() // data_movimentacao
                );

                RegistroMovimentacaoDAO registroDAO = new RegistroMovimentacaoDAO();
                System.out.println("Chamando o DAO para registrar movimentação...");
                registroDAO.registrarMovimentacao(registro);
                System.out.println("Movimentação enviada para o DAO");
                

                JOptionPane.showMessageDialog(this, tipo + " registrada com sucesso!");
                atualizarTabelaMovimentacoes();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao registrar a " + tipo.toLowerCase() + ".");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar movimentação: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void atualizarTabelaMovimentacoes() {
        
        try {
            RegistroMovimentacaoDAO dao = new RegistroMovimentacaoDAO();
            List<RegistroMovimentacao> lista = dao.listarTodasMovimentacoes();

            DefaultTableModel model = (DefaultTableModel) JTMovimentacao.getModel();
            model.setRowCount(0); // limpa a tabela

            ProdutoDAO produtoDAO = new ProdutoDAO();

            for (RegistroMovimentacao reg : lista) {
                Produto produto = produtoDAO.ProcurarProdutoID(reg.getProdutoId());
                String nomeProduto = (produto != null) ? produto.getNome() : "Produto não encontrado";
                int saldoAtual = (produto != null) ? produto.getQuantidade() : 0;
                String data = (reg.getDataMovimentacao() != null) ? reg.getDataMovimentacao() : "—";

                model.addRow(new Object[]{
                    data,
                    nomeProduto,
                    reg.getTipoMovimentacao(),
                    reg.getQuantidade(),
                    saldoAtual
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela de movimentações: " + e.getMessage());
            e.printStackTrace();
        }
    }
   
    private void carregarProdutosNoCombo() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarProdutoOrdenadoPorNome();

        JCBProduto.removeAllItems();
        for (Produto p : lista) {
            JCBProduto.addItem(p.getNome());
        }
    }
    private void limparCampos() {
        JTFQuantidade.setText("");
        JRBEntrada.setSelected(false);
        JRBSaida.setSelected(false);
        JCBProduto.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBProduto = new javax.swing.JComboBox<>();
        JRBEntrada = new javax.swing.JRadioButton();
        JRBSaida = new javax.swing.JRadioButton();
        JTFQuantidade = new javax.swing.JTextField();
        JTFData = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        JBRegistrar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTMovimentacao = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação de Estoque");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Movimentação de Estoque");

        jLabel2.setText("Produto:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Data:");

        JCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JRBEntrada.setText("Entrada");

        JRBSaida.setText("Saída");

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBSair.setBackground(new java.awt.Color(220, 53, 69));
        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        jScrollPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPane1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JTMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Produto", "Tipo", "Quantidade", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(JTMovimentacao);

        jLabel6.setText("Movimentações recentes: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRBEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRBSaida))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBRegistrar)
                .addGap(18, 18, 18)
                .addComponent(JBLimpar)
                .addGap(18, 18, 18)
                .addComponent(JBSair)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JRBEntrada)
                    .addComponent(JRBSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBRegistrar)
                    .addComponent(JBLimpar)
                    .addComponent(JBSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        this.dispose();
        janelaAnterior.setVisible(true);
    }//GEN-LAST:event_JBSairActionPerformed

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
       System.out.println("Botão Registrar clicado!");

        String tipo = JRBEntrada.isSelected() ? "Entrada" : JRBSaida.isSelected() ? "Saída" : "";
        if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione o tipo de movimentação.");
            return;
        }

        registrarMovimentacao(tipo); 
    }//GEN-LAST:event_JBRegistrarActionPerformed

    private void jScrollPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1AncestorAdded

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        JTFQuantidade.setText("");
        JRBEntrada.setSelected(false);
        JRBSaida.setSelected(false);
        JCBProduto.setSelectedIndex(0); 
    }//GEN-LAST:event_JBLimparActionPerformed


    
  
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentacaoDeEstoque(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBRegistrar;
    private javax.swing.JButton JBSair;
    private javax.swing.JComboBox<String> JCBProduto;
    private javax.swing.JRadioButton JRBEntrada;
    private javax.swing.JRadioButton JRBSaida;
    private javax.swing.JTextField JTFData;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTable JTMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
