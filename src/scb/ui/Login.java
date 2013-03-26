/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import scb.SCBFacade;
import scb.SCBFacadeException;
import scb.io.ConnectionFactory;

/**
 *
 * @author Erickson
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    
    public Login() {
        ConnectionFactory.checkDatabase();                 
        setUndecorated(true);
        initComponents();
        l_Logo.setSize(50, 30);
        facade = SCBFacade.getInstance();
        this.setLocation((width - this.getSize().width)/2, (height - this.getSize().height)/2);

    }
    
    
    private void verificarLogin(){
        enableCampos(false);
        l_Texto.setText("Verificando login...");
        try {
            if(facade.getUsuario(c_Usuario.getText()).isEmpty()){
                l_Texto.setText("Usuário inválido.");
                enableCampos(true);
            } else{
                if(facade.getUsuario(c_Usuario.getText()).get(0).getSenha().equals(String.valueOf(c_Senha.getPassword()))){
                    b_Fechar.setText("Cancelar.");
                    l_Texto.setText("Login efetuado com sucesso.");
                    iniciar();

                } else{
                    l_Texto.setText("Senha inválida.");
                    enableCampos(true);
                }


        }
        } catch (SCBFacadeException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void iniciar() {
        timer = new Timer(50, new ActionListener() {
            private int step = 0;
                     
            @Override
            public void actionPerformed(ActionEvent e) {
                if(step == 0){
                    l_Texto.setText("Carregando banco de dados...");
                }
                if(step == 25){
                    l_Texto.setText("Carregado com sucesso.");
                }                
                if(step == 35){
                    l_Texto.setText("Carregando bibliotecas...");
                }
                if(step == 60){
                    l_Texto.setText("Carregado com sucesso.");
                }  
                if(step == 70){
                    l_Texto.setText("Carregando UI...");
                }                
                if(step == 95){
                    l_Texto.setText("Carregado com sucesso.");
                }
                if(step == 105){
                    l_Texto.setText("Bem vindo, " + c_Usuario.getText());
                }                 
                step++;
                p_BarraProgresso.setValue(step);
                if(step == 140){
                    main = Main.getInstance();
                    main.setUsuario(c_Usuario.getText());
                    main.b_Usuario.setToolTipText(c_Usuario.getText());
                    dispose();
                    main.setVisible(true);
                    main.playAudio("login");
                }
            }
        });
        timer.start();
        
    }
    
    public void enableCampos(boolean b){
        c_Usuario.setEnabled(b);
        c_Senha.setEnabled(b);
        b_Login.setEnabled(b);
    }




    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLogo = new javax.swing.JPanel();
        l_Logo = new javax.swing.JLabel();
        p_BarraProgresso = new javax.swing.JProgressBar();
        l_Texto = new javax.swing.JLabel();
        b_Fechar = new javax.swing.JButton();
        c_Usuario = new javax.swing.JTextField();
        c_Senha = new javax.swing.JPasswordField();
        b_Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        l_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/images/logo.png"))); // NOI18N
        painelLogo.add(l_Logo);

        p_BarraProgresso.setBackground(new java.awt.Color(255, 255, 255));
        p_BarraProgresso.setForeground(new java.awt.Color(255, 255, 255));

        l_Texto.setForeground(new java.awt.Color(102, 102, 102));
        l_Texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Texto.setText("Bem vindo, faça o login para acessar.");

        b_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cancel.png"))); // NOI18N
        b_Fechar.setText("Fechar");
        b_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_FecharActionPerformed(evt);
            }
        });

        c_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c_Usuario.setAlignmentX(120.0F);
        c_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_UsuarioActionPerformed(evt);
            }
        });
        c_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_UsuarioKeyPressed(evt);
            }
        });

        c_Senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c_Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_SenhaKeyPressed(evt);
            }
        });

        b_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/door_in.png"))); // NOI18N
        b_Login.setText("Fazer login");
        b_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_LoginActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuário:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_BarraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(c_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(b_Login)
                .addGap(88, 88, 88)
                .addComponent(b_Fechar)
                .addGap(0, 97, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_Fechar, b_Login});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(c_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_Fechar)
                    .addComponent(b_Login))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_Texto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_BarraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        if(b_Fechar.getText().equalsIgnoreCase("Fechar")){
            System.exit(0);
        }
        else{
            timer.stop();
            p_BarraProgresso.setValue(0);
            l_Texto.setText("Login cancelado pelo usuário.");
            enableCampos(true);
            b_Fechar.setText("Fechar");         
            
            
        }
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void c_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_UsuarioActionPerformed

    private void c_SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_SenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             verificarLogin();
        }        
    }//GEN-LAST:event_c_SenhaKeyPressed

    private void c_UsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_UsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             verificarLogin();
        }           
    }//GEN-LAST:event_c_UsuarioKeyPressed

    private void b_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_LoginActionPerformed
        // TODO add your handling code here:
        verificarLogin();
    }//GEN-LAST:event_b_LoginActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Fechar;
    private javax.swing.JButton b_Login;
    private javax.swing.JPasswordField c_Senha;
    private javax.swing.JTextField c_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel l_Logo;
    private javax.swing.JLabel l_Texto;
    private javax.swing.JProgressBar p_BarraProgresso;
    private javax.swing.JPanel painelLogo;
    // End of variables declaration//GEN-END:variables
private Timer timer;   
private SCBFacade facade;
private Main main;
}