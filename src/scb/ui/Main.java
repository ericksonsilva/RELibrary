package scb.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Erickson Silva e Rivaldo Júnior
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); 

    private static Main singleton = new Main();
    
    private Main() {
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        initComponents();
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/scb/data/images/icon.png"));  
        this.setIconImage(imagemTitulo);         
        background.setSize(width, height);
        background.setLocation(0, 0 );
        logomarca.setSize(150, 120);
        logomarca.setLocation(width-155,height-160);
        b_Usuario.setLocation(width-170,5);
        b_Logoff.setLocation(width-80,5);
        b_Sair.setLocation(width-80,35);
        ufpb.setSize(75,102);
        ufpb.setLocation(130,height-180);
        texto1.setLocation(10,height-70);
        texto2.setLocation(10,height-55);
        
                
    }
    
    public static Main getInstance(){
        return singleton;
    }
   
    public static Main newInstance(){
        return singleton = new Main();
    }    
    
    
    public static void setMenu(boolean v){
        m_Cadastros.setVisible(v);
        m_Livros.setVisible(v);
        m_Emprestimos.setVisible(v);
        m_Usuarios.setVisible(v);
        m_Null.setVisible(!v);
    }
    
    public static void gerarJanelaListarCadastrados(){
        listarCadastrados = ListarCadastros.newInstance();
        desktop.remove(listarCadastrados);
        desktop.add(listarCadastrados);
        setMenu(false);
        listarCadastrados.show();
    }
 
     public static void gerarJanelaListarLivros(){  
        listarLivros = ListarLivros.newInstance();
        desktop.remove(listarLivros);
        desktop.add(listarLivros);
        setMenu(false);
        listarLivros.show();
    }
     
     public static void gerarJanelaListarEmprestimos(){  
        listarEmprestimos = ListarEmprestimos.newInstance();
        desktop.remove(listarEmprestimos);
        desktop.add(listarEmprestimos);
        setMenu(false);
        listarEmprestimos.show();
    }     
    
     public static void gerarJanelaListarUsuarios(){  
        listarUsuarios= ListarUsuarios.newInstance();
        desktop.remove(listarUsuarios);
        desktop.add(listarUsuarios);
        setMenu(false);
        listarUsuarios.show();
    } 
     

     
    public static void limparCamposAux(Container container) {        
            Component components[] = container.getComponents();       
            for (Component component : components) {           
                    if (component instanceof JFormattedTextField) {              					
                        JFormattedTextField field = (JFormattedTextField) component;              		
                        field.setValue(null);           
                    } else if (component instanceof JTextField) {              
                        JTextField field = (JTextField) component;              			
                        field.setText("");           
                    } else if (component instanceof JTextArea) {              
                        JTextArea area = (JTextArea) component;              			
                        area.setText("");  
                    } else if (component instanceof JComboBox) {
                        JComboBox box = (JComboBox) component;
                        box.setSelectedItem("");
                    } else if (component instanceof Container) {              			
                        limparCamposAux((Container) component);           
                    } 
            }     
    }  
    public static void limparCampos(java.awt.event.ActionEvent evt){
        Object source = evt.getSource();           
        if (source instanceof JComponent) {              
            JComponent component = (JComponent) source;              
            Container form = component.getTopLevelAncestor();              	
            limparCamposAux(form);           
        }
    }
    
    public void playAudio(String name){
    try {  
        String root = System.getProperty("user.dir");
        File soundFile = new File(root + "/src/scb/data/audio/"+name+".wav");  
        AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile.getAbsoluteFile());  
        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());  
        Clip clip = (Clip) AudioSystem.getLine(info);  
        clip.open(sound);  
        clip.start();  
    } catch (Exception e) { 
        System.out.println("erro");
         
}         
 
    }    
    

    public static String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        b_Usuario.setText(usuario);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        b_Usuario = new javax.swing.JButton();
        b_Logoff = new javax.swing.JButton();
        ufpb = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        b_Sair = new javax.swing.JButton();
        logomarca = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        m_Menu = new javax.swing.JMenuBar();
        m_Cadastros = new javax.swing.JMenu();
        c_Cadastrar = new javax.swing.JMenuItem();
        c_Listar = new javax.swing.JMenuItem();
        m_Livros = new javax.swing.JMenu();
        l_Cadastrar = new javax.swing.JMenuItem();
        l_Listar = new javax.swing.JMenuItem();
        m_Emprestimos = new javax.swing.JMenu();
        e_Realizar = new javax.swing.JMenuItem();
        e_Listar = new javax.swing.JMenuItem();
        e_Finalizar = new javax.swing.JMenuItem();
        m_Usuarios = new javax.swing.JMenu();
        u_Novo = new javax.swing.JMenuItem();
        u_Listar = new javax.swing.JMenuItem();
        m_Null = new javax.swing.JMenu();
        m_Relatorio = new javax.swing.JMenu();
        r_Relatorio = new javax.swing.JMenuItem();

        setTitle("RE Library - Sistema de Controle Bibliotecário");

        desktop.setBackground(new java.awt.Color(105, 105, 105));
        desktop.setRequestFocusEnabled(false);

        b_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        b_Usuario.setText("Usuário não identificado");
        b_Usuario.setEnabled(false);
        b_Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_Usuario.setBounds(10, 100, 73, 23);
        desktop.add(b_Usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        b_Logoff.setBackground(new java.awt.Color(255, 255, 255));
        b_Logoff.setText("Logoff");
        b_Logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_LogoffActionPerformed(evt);
            }
        });
        b_Logoff.setBounds(10, 70, 73, 23);
        desktop.add(b_Logoff, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ufpb.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        ufpb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ufpb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/images/ufpb.png"))); // NOI18N
        ufpb.setBounds(20, 780, 120, 110);
        desktop.add(ufpb, javax.swing.JLayeredPane.DEFAULT_LAYER);

        texto2.setForeground(new java.awt.Color(255, 255, 255));
        texto2.setText("Elaborado como projeto para a disciplina : POO - Rodrigo Rebouças.");
        texto2.setBounds(310, 900, 326, 14);
        desktop.add(texto2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        texto1.setForeground(new java.awt.Color(255, 255, 255));
        texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto1.setText("Aplicativo desenvolvido por Erickson Silva e Rivaldo Barbosa.");
        texto1.setBounds(310, 880, 320, 14);
        desktop.add(texto1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        b_Sair.setBackground(new java.awt.Color(255, 255, 255));
        b_Sair.setText("Sair");
        b_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SairActionPerformed(evt);
            }
        });
        b_Sair.setBounds(10, 40, 73, 23);
        desktop.add(b_Sair, javax.swing.JLayeredPane.DEFAULT_LAYER);

        logomarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/images/logo.png"))); // NOI18N
        logomarca.setBounds(0, 0, 34, 14);
        desktop.add(logomarca, javax.swing.JLayeredPane.DEFAULT_LAYER);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/images/background.jpg"))); // NOI18N
        background.setBounds(0, 0, 2560, 1600);
        desktop.add(background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        m_Menu.setBackground(new java.awt.Color(255, 255, 255));

        m_Cadastros.setText("Cadastros");
        m_Cadastros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        m_Cadastros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        c_Cadastrar.setText("Novo cadastro");
        c_Cadastrar.setToolTipText("");
        c_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        c_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_CadastrarActionPerformed(evt);
            }
        });
        m_Cadastros.add(c_Cadastrar);

        c_Listar.setText("Listar cadastros");
        c_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_ListarActionPerformed(evt);
            }
        });
        m_Cadastros.add(c_Listar);

        m_Menu.add(m_Cadastros);

        m_Livros.setText("Livros");

        l_Cadastrar.setText("Cadastrar livro");
        l_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_CadastrarActionPerformed(evt);
            }
        });
        m_Livros.add(l_Cadastrar);

        l_Listar.setText("Exibir livros");
        l_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_ListarActionPerformed(evt);
            }
        });
        m_Livros.add(l_Listar);

        m_Menu.add(m_Livros);

        m_Emprestimos.setText("Empréstimos");

        e_Realizar.setText("Realizar");
        e_Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_RealizarActionPerformed(evt);
            }
        });
        m_Emprestimos.add(e_Realizar);

        e_Listar.setText("Visualizar");
        e_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_ListarActionPerformed(evt);
            }
        });
        m_Emprestimos.add(e_Listar);

        e_Finalizar.setText("Finalizar");
        e_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_FinalizarActionPerformed(evt);
            }
        });
        m_Emprestimos.add(e_Finalizar);

        m_Menu.add(m_Emprestimos);

        m_Usuarios.setText("Usuários");

        u_Novo.setText("Novo usuário");
        u_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_NovoActionPerformed(evt);
            }
        });
        m_Usuarios.add(u_Novo);

        u_Listar.setText("Listar usuários");
        u_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_ListarActionPerformed(evt);
            }
        });
        m_Usuarios.add(u_Listar);

        m_Menu.add(m_Usuarios);

        m_Null.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_NullActionPerformed(evt);
            }
        });
        m_Menu.add(m_Null);

        m_Relatorio.setText("Relatório");
        m_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_RelatorioActionPerformed(evt);
            }
        });

        r_Relatorio.setText("Exibir relatório");
        r_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_RelatorioActionPerformed(evt);
            }
        });
        m_Relatorio.add(r_Relatorio);

        m_Menu.add(m_Relatorio);

        setJMenuBar(m_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 2695, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 2156, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void e_RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_RealizarActionPerformed
        // TODO add your handling code here:
        if(novoEmprestimo == null){
            novoEmprestimo = NovoEmprestimo.getInstance();
        }
        desktop.remove(novoEmprestimo);
        desktop.add(novoEmprestimo);
        setMenu(false);
        novoEmprestimo.show();
    }//GEN-LAST:event_e_RealizarActionPerformed

    private void l_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_CadastrarActionPerformed
        // TODO add your handling code here:
      
            cadastrarLivro = new NovoLivro();          
     
        desktop.remove(cadastrarLivro);
        desktop.add(cadastrarLivro);
        setMenu(false);
        cadastrarLivro.show();
        
    }//GEN-LAST:event_l_CadastrarActionPerformed

    private void c_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_CadastrarActionPerformed
            // TODO add your handling code here:
           cadastrarCadastro = new NovoCadastro();          
        
        desktop.remove(cadastrarCadastro);
        desktop.add(cadastrarCadastro);
        setMenu(false);
        cadastrarCadastro.show();
        
    }//GEN-LAST:event_c_CadastrarActionPerformed

    private void c_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_ListarActionPerformed
         gerarJanelaListarCadastrados();

    }//GEN-LAST:event_c_ListarActionPerformed

    private void l_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_ListarActionPerformed
        // TODO add your handling code here:
       gerarJanelaListarLivros();
    }//GEN-LAST:event_l_ListarActionPerformed

    private void e_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_ListarActionPerformed
        gerarJanelaListarEmprestimos();
    }//GEN-LAST:event_e_ListarActionPerformed

    private void b_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SairActionPerformed
        // TODO add your handling code here:
        playAudio("exit"); 
        System.exit(0);
    }//GEN-LAST:event_b_SairActionPerformed

    private void b_LogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_LogoffActionPerformed
        // TODO add your handling code here:
        this.dispose();
        playAudio("logoff");
        login = new Login();
        login.setVisible(true);
        
      
    }//GEN-LAST:event_b_LogoffActionPerformed

    private void u_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_ListarActionPerformed
        // TODO add your handling code here:
         if(!(b_Usuario.getText().equalsIgnoreCase("admin")) || usuario == null){
            loginListarUsuarios = new LoginListarUsuarios();             
            desktop.remove(loginListarUsuarios);
            desktop.add(loginListarUsuarios);
            setMenu(false);
            loginListarUsuarios.show();
        }else{
            gerarJanelaListarUsuarios();
        }
    }//GEN-LAST:event_u_ListarActionPerformed

    private void u_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_NovoActionPerformed
        // TODO add your handling code here:
        if(!(b_Usuario.getText().equalsIgnoreCase("admin")) || usuario == null){
            loginNovoUsuario = new LoginNovoUsuario();             
            desktop.remove(loginNovoUsuario);
            desktop.add(loginNovoUsuario);
            setMenu(false);
            loginNovoUsuario.show();
        }else{
            cadastrarUsuario = new NovoUsuario();
            Main.desktop.remove(cadastrarUsuario);
            Main.desktop.add(cadastrarUsuario);
            setMenu(false);
            cadastrarUsuario.show();  
        }
    }//GEN-LAST:event_u_NovoActionPerformed

    private void m_NullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_NullActionPerformed

    }//GEN-LAST:event_m_NullActionPerformed

    private void e_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_FinalizarActionPerformed
        finalizarEmprestimos = new FinalizarEmprestimo();
        desktop.remove(finalizarEmprestimos);
        desktop.add(finalizarEmprestimos);
        setMenu(false);
        finalizarEmprestimos.show();
    }//GEN-LAST:event_e_FinalizarActionPerformed

    private void m_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_RelatorioActionPerformed

    }//GEN-LAST:event_m_RelatorioActionPerformed

    private void r_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_RelatorioActionPerformed
        // TODO add your handling code here:
        relatorio = new Relatorio();
        desktop.remove(relatorio);
        desktop.add(relatorio);
        setMenu(false);
        relatorio.show();        
    }//GEN-LAST:event_r_RelatorioActionPerformed

    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Logoff;
    private javax.swing.JButton b_Sair;
    public javax.swing.JButton b_Usuario;
    private javax.swing.JLabel background;
    private javax.swing.JMenuItem c_Cadastrar;
    private javax.swing.JMenuItem c_Listar;
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem e_Finalizar;
    private javax.swing.JMenuItem e_Listar;
    private javax.swing.JMenuItem e_Realizar;
    private javax.swing.JMenuItem l_Cadastrar;
    private javax.swing.JMenuItem l_Listar;
    private javax.swing.JLabel logomarca;
    private static javax.swing.JMenu m_Cadastros;
    private static javax.swing.JMenu m_Emprestimos;
    private static javax.swing.JMenu m_Livros;
    private static javax.swing.JMenuBar m_Menu;
    private static javax.swing.JMenu m_Null;
    private javax.swing.JMenu m_Relatorio;
    private static javax.swing.JMenu m_Usuarios;
    private javax.swing.JMenuItem r_Relatorio;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JMenuItem u_Listar;
    private javax.swing.JMenuItem u_Novo;
    private javax.swing.JLabel ufpb;
    // End of variables declaration//GEN-END:variables
    private NovoCadastro cadastrarCadastro;
    private NovoLivro cadastrarLivro;
    private NovoUsuario cadastrarUsuario;    
    private static NovoEmprestimo novoEmprestimo;
    private static ListarUsuarios listarUsuarios;
    private FinalizarEmprestimo finalizarEmprestimos;
    private static ListarEmprestimos listarEmprestimos;
    private static ListarCadastros listarCadastrados;
    private static ListarLivros listarLivros;
    private static String usuario;
    private LoginNovoUsuario loginNovoUsuario;
    private LoginListarUsuarios loginListarUsuarios;
    private Login login;
    private Relatorio relatorio;

}

