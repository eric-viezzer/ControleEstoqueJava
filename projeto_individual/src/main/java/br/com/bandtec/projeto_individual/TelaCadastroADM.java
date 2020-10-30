/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.projeto_individual;

import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Aluno
 */
public class TelaCadastroADM extends javax.swing.JFrame {
        private JdbcTemplate jdbcTemplate;
    /**
     * Creates new form TelaCadastroADM
     */
    public TelaCadastroADM() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TFemailADM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFnomeADM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BTcadastrarADM = new javax.swing.JButton();
        TFsenhaADM = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 20, 50, 30);

        TFemailADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFemailADMActionPerformed(evt);
            }
        });
        jPanel1.add(TFemailADM);
        TFemailADM.setBounds(130, 60, 210, 30);

        jLabel2.setText("email:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 60, 50, 30);
        jPanel1.add(TFnomeADM);
        TFnomeADM.setBounds(130, 20, 210, 30);

        jLabel3.setText("senha:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 100, 50, 30);

        BTcadastrarADM.setText("Cadastrar");
        BTcadastrarADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcadastrarADMActionPerformed(evt);
            }
        });
        jPanel1.add(BTcadastrarADM);
        BTcadastrarADM.setBounds(160, 150, 128, 32);
        jPanel1.add(TFsenhaADM);
        TFsenhaADM.setBounds(130, 100, 210, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(443, 241));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TFemailADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFemailADMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFemailADMActionPerformed

    private void BTcadastrarADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcadastrarADMActionPerformed
        // TODO add your handling code here:
        conectarBanco();
        
        String nome = TFnomeADM.getText();
        String email = TFemailADM.getText();
        String senha = TFsenhaADM.getText();
        
       Integer a = jdbcTemplate.update(
        "insert into cadastroadm (nome,email,senha) values (?,?,?)",
                 nome, email, senha);
        
        if(email.isEmpty() || nome.isEmpty() || 
           senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos em branco!");
        }else if(a > 0){
            JOptionPane.showMessageDialog
                (null, "Cadastro realizado com sucesso ");
            new TelaCadastroADM().setVisible(false);
            dispose();
            
        }else{
            
        }
    }//GEN-LAST:event_BTcadastrarADMActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTcadastrarADM;
    private javax.swing.JTextField TFemailADM;
    private javax.swing.JTextField TFnomeADM;
    private javax.swing.JPasswordField TFsenhaADM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
