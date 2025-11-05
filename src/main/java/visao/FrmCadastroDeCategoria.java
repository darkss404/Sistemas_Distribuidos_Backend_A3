package visao;

import dao.CategoriaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Categoria;


public class FrmCadastroDeCategoria extends javax.swing.JFrame {

    private JFrame janelaAnterior;
    private int idCategoria = 0;


    public FrmCadastroDeCategoria() {
        initComponents();
    }


    public FrmCadastroDeCategoria(JFrame janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
        initComponents();
    }


    public FrmCadastroDeCategoria(JFrame janelaAnterior, Categoria categoria) {
        this.janelaAnterior = janelaAnterior;
        initComponents();
        JTFNomeCategoria.setText(categoria.getNomeCategoria());
        JCBTamanho.setSelectedItem(categoria.getTamanho());
        JCBEmbalagem.setSelectedItem(categoria.getEmbalagem());
        this.idCategoria = categoria.getId();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFNomeCategoria = new javax.swing.JTextField();
        JCBTamanho = new javax.swing.JComboBox<>();
        JCBEmbalagem = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        JBSalvar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Categoria");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nome da Categoria:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tamanho:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Embalagem:");

        JTFNomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeCategoriaActionPerformed(evt);
            }
        });

        JCBTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));
        JCBTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTamanhoActionPerformed(evt);
            }
        });

        JCBEmbalagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lata", "Vidro", "Plástico", " " }));

        JBSalvar.setText("💾 Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        JBLimpar.setText("🗑️ Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBCancelar.setText("✖ Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(JBSalvar)
                .addGap(83, 83, 83)
                .addComponent(JBLimpar)
                .addGap(74, 74, 74)
                .addComponent(JBCancelar)
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCBTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JCBEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalvar)
                    .addComponent(JBLimpar)
                    .addComponent(JBCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeCategoriaActionPerformed

    private void JCBTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBTamanhoActionPerformed
    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalvarActionPerformed

        try {
            String nome = JTFNomeCategoria.getText().trim();
            String tamanho = JCBTamanho.getSelectedItem().toString();
            String embalagem = JCBEmbalagem.getSelectedItem().toString();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o nome da categoria.");
                return;
            }

            Categoria categoria = new Categoria(nome, tamanho, embalagem); 
            CategoriaDAO dao = new CategoriaDAO();
            
            if (idCategoria == 0) {
                dao.salvar(categoria); 
                JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");
            } else {
                categoria.setId(idCategoria); 
                dao.atualizar(categoria);
                JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!");
            }

            JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");

            if (janelaAnterior instanceof FrmListadeCategoria) {
                ((FrmListadeCategoria) janelaAnterior).carregarTabela();
                janelaAnterior.setVisible(true);
            }

            this.dispose(); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBSalvarActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        JTFNomeCategoria.setText("");          
        JCBTamanho.setSelectedIndex(0);        
        JCBEmbalagem.setSelectedIndex(0);      

        JTFNomeCategoria.requestFocus();       
    }//GEN-LAST:event_JBLimparActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        if (janelaAnterior != null) {
            janelaAnterior.setVisible(true); 
        }
        this.dispose(); 
    }//GEN-LAST:event_JBCancelarActionPerformed

  
    public static void main(String args[]) {
       

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroDeCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JComboBox<String> JCBEmbalagem;
    private javax.swing.JComboBox<String> JCBTamanho;
    private javax.swing.JTextField JTFNomeCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
