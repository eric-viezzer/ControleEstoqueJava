
package br.com.bandtec.projeto_individual;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class TelaAdmin extends javax.swing.JFrame {
         private JdbcTemplate jdbcTemplate;
    /**
     * Creates new form TelaAdmin
     */
    public TelaAdmin() {
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFnomeProduto = new javax.swing.JTextField();
        TFquantidadeProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TFprecoProduto = new javax.swing.JTextField();
        BTlimpar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
        BTbusca.setBounds(240, 70, 90, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cadastrar itens ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 130, 100, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 110, 320, 10);

        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 200, 50, 30);

        jLabel4.setText("Quantidade");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 250, 80, 30);
        jPanel1.add(TFnomeProduto);
        TFnomeProduto.setBounds(90, 200, 230, 30);
        jPanel1.add(TFquantidadeProduto);
        TFquantidadeProduto.setBounds(90, 250, 230, 30);

        jLabel6.setText("Preço");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 300, 50, 30);
        jPanel1.add(TFprecoProduto);
        TFprecoProduto.setBounds(90, 300, 230, 30);

        BTlimpar.setText("Limpar ");
        BTlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTlimparActionPerformed(evt);
            }
        });
        jPanel1.add(BTlimpar);
        BTlimpar.setBounds(110, 400, 140, 23);

        jButton3.setText("Cadastrar ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 370, 140, 23);

        jButton4.setText("Cadastrar ADM ");
        jPanel1.add(jButton4);
        jButton4.setBounds(190, 370, 140, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(715, 472));
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
                new BeanPropertyRowMapper(User.class),
                        nome);
        if(consultaProduto.isEmpty()){
            TAresultado.setText("Produto não encontrado no estoque");
        }else{
            Produto registro = consultaProduto.get(0);
            TAresultado.setText(
                    registro.getNome()+
                    " | "
                    +registro.getQuantidade()+
                    " | "
                    +registro.getPreco()
            );
        }
    }//GEN-LAST:event_BTbuscaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        conectarBanco();
        
        String nomeProduto = TFnomeProduto.getText();
        String quantidadeProduto = TFquantidadeProduto.getText();
        String precoProduto = TFprecoProduto.getText();
        
        Integer a = jdbcTemplate.update(
        "insert into produto (nome,quantidade,preco) values (?,?,?)",
                 nomeProduto , quantidadeProduto,precoProduto);
       Integer abc = a + 1;
        if(nomeProduto.isEmpty() || quantidadeProduto.isEmpty() || 
                precoProduto.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }else if(abc > a){
             JOptionPane.showMessageDialog
                (null, "Cadastro realizado com sucesso ");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BTlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTlimparActionPerformed
        // TODO add your handling code here:
        TFnomeProduto.setText("");
        TFprecoProduto.setText("");
        TFquantidadeProduto.setText("");
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
            java.util.logging.Logger.getLogger(TelaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTbusca;
    private javax.swing.JButton BTlimpar;
    private javax.swing.JLabel LBhorario;
    private javax.swing.JTextArea TAresultado;
    private javax.swing.JTextField TFbusca;
    private javax.swing.JTextField TFnomeProduto;
    private javax.swing.JTextField TFprecoProduto;
    private javax.swing.JTextField TFquantidadeProduto;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
