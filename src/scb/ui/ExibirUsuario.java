package scb.ui;


import scb.Usuario;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erickson
 */
public class ExibirUsuario extends javax.swing.JInternalFrame {
       
    public ExibirUsuario(Usuario u) {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        this.u = u;
        setCamposUsuario();
        offCampos();
    }
    
    public void setCamposUsuario(){
        c_Nome.setText(u.getNome());
        c_Email.setText(u.getEmail());
        c_Turno.setText(u.getTurno());
        c_Telefone.setText(u.getTelefone());
        c_Usuario.setText(u.getUsuario());
        c_Senha.setText(u.getSenha());
    }
    
    public void offCampos(){
        c_Nome.setEditable(false);
        c_Email.setEditable(false);
        c_Turno.setEditable(false);
        c_Telefone.setEditable(false);
        c_Usuario.setEditable(false);
        c_Senha.setEditable(false);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_Fechar = new javax.swing.JButton();
        p_Dados = new javax.swing.JPanel();
        d_Nome = new javax.swing.JLabel();
        c_Nome = new javax.swing.JTextField();
        d_Email = new javax.swing.JLabel();
        c_Email = new javax.swing.JTextField();
        d_Turno = new javax.swing.JLabel();
        d_Usuario = new javax.swing.JLabel();
        c_Usuario = new javax.swing.JTextField();
        d_Senha = new javax.swing.JLabel();
        d_Telefone = new javax.swing.JLabel();
        c_Telefone = new javax.swing.JTextField();
        c_Senha = new javax.swing.JPasswordField();
        c_Turno = new javax.swing.JTextField();
        l_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        b_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Fechar.setText("Fechar");
        b_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_FecharActionPerformed(evt);
            }
        });

        d_Nome.setText("Nome:");

        c_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_NomeFocusLost(evt);
            }
        });

        d_Email.setText("Email:");

        c_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_EmailActionPerformed(evt);
            }
        });
        c_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_EmailFocusLost(evt);
            }
        });

        d_Turno.setText("Turno:");

        d_Usuario.setText("Usuário:");

        c_Usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_UsuarioFocusLost(evt);
            }
        });

        d_Senha.setText("Senha:");

        d_Telefone.setText("Telefone:");

        javax.swing.GroupLayout p_DadosLayout = new javax.swing.GroupLayout(p_Dados);
        p_Dados.setLayout(p_DadosLayout);
        p_DadosLayout.setHorizontalGroup(
            p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addComponent(d_Nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Nome))
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addComponent(d_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Email))
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addComponent(d_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(d_Senha)
                        .addGap(4, 4, 4)
                        .addComponent(c_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addComponent(d_Turno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(d_Telefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Telefone)))
                .addContainerGap())
        );
        p_DadosLayout.setVerticalGroup(
            p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(d_Nome))
                    .addComponent(c_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(d_Email))
                    .addComponent(c_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Turno)
                        .addComponent(c_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Telefone)
                        .addComponent(c_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Senha)
                        .addComponent(c_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Usuario)
                        .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        l_Titulo.setForeground(new java.awt.Color(102, 102, 102));
        l_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Titulo.setText("Visualização de Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_Dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(b_Fechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Fechar)
                .addGap(31, 31, 31))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-398)/2, (screenSize.height-307)/2, 398, 307);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        dispose();
        Main.setMenu(true);
        Main.gerarJanelaListarUsuarios();
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void c_UsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_UsuarioFocusLost

    }//GEN-LAST:event_c_UsuarioFocusLost

    private void c_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_EmailFocusLost

    }//GEN-LAST:event_c_EmailFocusLost

    private void c_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_EmailActionPerformed

    private void c_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_NomeFocusLost

    }//GEN-LAST:event_c_NomeFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Fechar;
    private javax.swing.JTextField c_Email;
    private javax.swing.JTextField c_Nome;
    private javax.swing.JPasswordField c_Senha;
    private javax.swing.JTextField c_Telefone;
    private javax.swing.JTextField c_Turno;
    private javax.swing.JTextField c_Usuario;
    private javax.swing.JLabel d_Email;
    private javax.swing.JLabel d_Nome;
    private javax.swing.JLabel d_Senha;
    private javax.swing.JLabel d_Telefone;
    private javax.swing.JLabel d_Turno;
    private javax.swing.JLabel d_Usuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JPanel p_Dados;
    // End of variables declaration//GEN-END:variables
    private Usuario u;
}
