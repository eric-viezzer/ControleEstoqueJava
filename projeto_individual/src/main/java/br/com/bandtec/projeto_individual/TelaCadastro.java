/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.projeto_individual;

import javax.swing.JOptionPane;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



/**
 *
 * @author Pichau
 */
public class TelaCadastro extends javax.swing.JFrame {
    private JdbcTemplate jdbcTemplate;

    public TelaCadastro() {
        initComponents();
    }
    
        void CadastrarBanco(){
        BasicDataSource dataSource = new BasicDataSource();
        // Indicando a classe do Driver de banco
        dataSource.setDriverClassName("org.h2.Driver");
        // Indicando a URL do banco
        dataSource.setUrl("jdbc:h2:file:./bancoCad");
        // Indicando o usuário e senha de acesso
        dataSource.setUsername("sa");
        dataSource.setPassword(""); 
        
         jdbcTemplate = new JdbcTemplate(dataSource);
        }
       
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TfnomeCad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TfEmailCad = new javax.swing.JTextField();
        Tfsenha1Cad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Liquidism part 2", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 60);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(160, 50, 220, 50);

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 110, 50, 30);

        TfnomeCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfnomeCadActionPerformed(evt);
            }
        });
        jPanel1.add(TfnomeCad);
        TfnomeCad.setBounds(160, 110, 230, 30);

        jLabel3.setText("email:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 150, 50, 30);
        jPanel1.add(TfEmailCad);
        TfEmailCad.setBounds(160, 150, 230, 30);
        jPanel1.add(Tfsenha1Cad);
        Tfsenha1Cad.setBounds(160, 190, 230, 30);

        jLabel4.setText("senha:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 190, 50, 30);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(220, 260, 100, 23);

        jButton2.setText("<--");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 260, 70, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 300);

        setSize(new java.awt.Dimension(548, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CadastrarBanco();
         
        String nome = TfnomeCad.getText();
        String email = TfEmailCad.getText();
        String senha = Tfsenha1Cad.getText();
        
       Integer a = jdbcTemplate.update(
        "insert into cadastro (nome,email,senha) values (?,?,?)",
                 nome, email, senha);
        
        if(email.isEmpty() || nome.isEmpty() || 
           senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos em branco!");
        }else if(a > 0){
            
            JOptionPane.showMessageDialog
                (null, "Cadastro realizado com sucesso ");
        }else{
            
        }
               
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TfnomeCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfnomeCadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfnomeCadActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new TelaCadastro().setVisible(false);
        new TelaLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TfEmailCad;
    private javax.swing.JTextField TfnomeCad;
    private javax.swing.JTextField Tfsenha1Cad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
