package visao;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;



public class FrmProdutoAbaixoDoMin extends javax.swing.JFrame {

    private JComboBox<String> comboCategoria;
    private JButton btnBuscar, btnFechar;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private javax.swing.JFrame janelaAnterior;
   
    public FrmProdutoAbaixoDoMin(javax.swing.JFrame janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
        initComponents();
        modeloTabela = (DefaultTableModel) JTProdutoAbaixo.getModel();
        btnBuscar = JBBuscar;
        tabela = JTProdutoAbaixo;
        carregarCategorias();
        buscarProdutos();
        JTProdutoAbaixo.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                try {
                    int quantidade = Integer.parseInt(table.getValueAt(row, 2).toString());
                    int minimo = Integer.parseInt(table.getValueAt(row, 3).toString());
                    int maximo = Integer.parseInt(table.getValueAt(row, 4).toString());

                    if (quantidade < minimo) {
                        c.setBackground(new java.awt.Color(255, 102, 102)); // vermelho claro
                    } else if (quantidade > maximo) {
                        c.setBackground(new java.awt.Color(255, 178, 102)); // laranja
                    }
                } catch (Exception e) {
                    c.setBackground(java.awt.Color.WHITE); // fallback
                }

                if (isSelected) {
                    c.setBackground(c.getBackground().darker());
                }

                return c;
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        }
    });
}
    

    private void carregarCategorias() {
        ProdutoDAO dao = new ProdutoDAO();
        List<String> categorias = dao.buscarCategorias();
        JCBFiltro.removeAllItems();
        JCBFiltro.addItem("Todas");
        for (String cat : categorias) {
            JCBFiltro.addItem(cat);
        }
    }
    
    private void buscarProdutos() {
        String categoria = (String) JCBFiltro.getSelectedItem();
        ProdutoDAO dao = new ProdutoDAO();
        try {
            List<Produto> lista;
            if ("Todas".equals(categoria)) {
                lista = dao.getMinhaListaProdutos(); 
            } else {
                lista = dao.buscarPorCategoria(categoria); 
            }

            DefaultTableModel modelo = (DefaultTableModel) JTProdutoAbaixo.getModel();
            modelo.setRowCount(0);

            for (Produto p : lista) {
                if (p.getQuantidade() < p.getMin() || p.getQuantidade() > p.getMax()) {
                    modelo.addRow(new Object[]{
                        p.getId(), p.getNome(), p.getQuantidade(), p.getMin(), p.getMax()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + e.getMessage());
        }
    }
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        JCBFiltro = new javax.swing.JComboBox<>();
        JBBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTProdutoAbaixo = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        JBFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Produtos Abaixo do Mínimo/Máximo");

        jLabel2.setText("Filtro por Categoria:");

        JCBFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JBBuscar.setText("Buscar");
        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        JTProdutoAbaixo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Mínimo", "Máximo"
            }
        ));
        jScrollPane1.setViewportView(JTProdutoAbaixo);

        jScrollPane2.setViewportView(jScrollPane1);

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(JBBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(JBFechar)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(JBFechar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed
       buscarProdutos();
    }//GEN-LAST:event_JBBuscarActionPerformed

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        this.dispose();
        janelaAnterior.setVisible(true);
    }//GEN-LAST:event_JBFecharActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutoAbaixoDoMin(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JComboBox<String> JCBFiltro;
    private javax.swing.JTable JTProdutoAbaixo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
