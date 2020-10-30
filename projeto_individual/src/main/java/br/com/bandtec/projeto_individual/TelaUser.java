
package br.com.bandtec.projeto_individual;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class TelaUser extends javax.swing.JFrame {
         private JdbcTemplate jdbcTemplate;
    /**
     * Creates new form TelaAdmin
     */
    public TelaUser() {
        initComponents();
        timer1.start();
    }
void conectarBanco() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./bancoCad");
        dataSource.setUsername("sa");
        dataSource.setPassword(""); 
        
        jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        LBhorario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAresultado = new javax.swing.JTextArea();
        TFbusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BTbusca = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        BTlimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        LBhorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBhorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBhorario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(LBhorario);
        LBhorario.setBounds(340, 400, 350, 30);

        TAresultado.setColumns(20);
        TAresultado.setRows(5);
        jScrollPane1.setViewportView(TAresultado);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(340, 10, 350, 380);
        jPanel1.add(TFbusca);
        TFbusca.setBounds(70, 10, 260, 30);

        jLabel1.setText("Busca:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 60, 30);

        BTbusca.setText("Buscar");
        BTbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTbuscaActionPerformed(evt);
            }
        });
        jPanel1.add(BTbusca);
        BTbusca.setBounds(240, 70, 90, 32);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 110, 320, 2);

        BTlimpar.setText("Limpar ");
        BTlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTlimparActionPerformed(evt);
            }
        });
        jPanel1.add(BTlimpar);
        BTlimpar.setBounds(100, 400, 150, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bandtec/projeto_individual/logo.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 150, 200, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(715, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

     
    }//GEN-LAST:event_formWindowOpened

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        // TODO add your handling code here:
        DataAtual Dataatual = new DataAtual(new Date());
        LBhorario.setText(Dataatual.getDiaSemana()+", "+Dataatual.getDataHora());
    }//GEN-LAST:event_timer1OnTime

    private void BTbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTbuscaActionPerformed
        // TODO add your handling code here:
        conectarBanco();
        
        String nome = TFbusca.getText();
        
        List<Produto> consultaProduto = jdbcTemplate.query(
              "select * from produto where nome = ?",
                new BeanPropertyRowMapper(Produto.class),
                        nome);
        if(consultaProduto.isEmpty()){
            TAresultado.setText("Produto não encontrado no estoque");
        }else{
            Produto registro = consultaProduto.get(0);
            TAresultado.setText(
                    registro.getNome()+" | quantidade: "
                    +registro.getQuantidade()+" | preço: R$"+registro.getPreco()
            );
        }
    }//GEN-LAST:event_BTbuscaActionPerformed

    private void BTlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTlimparActionPerformed
        // TODO add your handling code here:
        TFbusca.setText("");
        TAresultado.setText("");
    }//GEN-LAST:event_BTlimparActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTbusca;
    private javax.swing.JButton BTlimpar;
    private javax.swing.JLabel LBhorario;
    private javax.swing.JTextArea TAresultado;
    private javax.swing.JTextField TFbusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
