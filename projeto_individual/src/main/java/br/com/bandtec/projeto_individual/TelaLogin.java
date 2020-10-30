/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.projeto_individual;

import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Pichau
 */
public class TelaLogin extends javax.swing.JFrame {
    
        TelaUser telauser = new TelaUser();
        private JdbcTemplate jdbcTemplate;
        
        
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfLogin = new javax.swing.JTextField();
        CKBadmin = new javax.swing.JCheckBox();
        TFsenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 250, 100, 32);

        jLabel4.setText("Ainda não possui cadastro?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(200, 220, 160, 16);

        jLabel1.setFont(new java.awt.Font("Liquidism part 2", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 60);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(160, 50, 220, 50);

        jLabel2.setText("SENHA:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 150, 50, 30);

        jLabel3.setText("LOGIN:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 100, 50, 30);
        jPanel1.add(TfLogin);
        TfLogin.setBounds(170, 100, 200, 30);

        CKBadmin.setBackground(new java.awt.Color(204, 204, 255));
        CKBadmin.setText("admin");
        jPanel1.add(CKBadmin);
        CKBadmin.setBounds(240, 190, 80, 24);
        jPanel1.add(TFsenha);
        TFsenha.setBounds(170, 150, 200, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 540, 300);

        setSize(new java.awt.Dimension(549, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        conectarBanco();
        
        String email = TfLogin.getText();
        String senha = TFsenha.getText();
        
        List<User> consultaUser = jdbcTemplate.query(
              "select * from cadastro where email = ? and senha = ?",
                new BeanPropertyRowMapper(User.class),
                        email, senha);
        List<UserADM> consultaAdmin = jdbcTemplate.query(
              "select * from cadastroADM where email = ? and senha = ?",
              new BeanPropertyRowMapper(UserADM.class),
                     email, senha);
        
        if(!CKBadmin.isSelected()){
        if(consultaUser.isEmpty()){
            JOptionPane.showMessageDialog
        (null, "Usuario nao existe");
        }else{
            User registro = consultaUser.get(0);
                JOptionPane.showMessageDialog
                (null, "Bem vindo! "+registro.getNome());
                
                telauser.setVisible(true);
                new TelaLogin().setVisible(false);
                dispose();
            }
        }else{
        if (consultaAdmin.isEmpty()){
            JOptionPane.showMessageDialog
        (null, "Administrador nao encontrado");
        }else{
            UserADM registro = consultaAdmin.get(0);
            JOptionPane.showMessageDialog
                (null, "Bem vindo administrador,  "+registro.getNome()+ "!");
            new TelaAdmin().setVisible(true);
            new TelaLogin().setVisible(false);
            dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new TelaCadastro().setVisible(true);
        new TelaLogin().setVisible(false);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CKBadmin;
    private javax.swing.JPasswordField TFsenha;
    private javax.swing.JTextField TfLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
