package scb.ui;


import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scb.Cadastro;
import scb.CadastroTableModel;
import scb.SCBFacade;
import scb.SCBFacadeException;
import scb.Util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erickson
 */

public class ListarCadastros extends javax.swing.JInternalFrame {
         
    private ListarCadastros() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        facade = SCBFacade.getInstance();
        tableModel = new CadastroTableModel();
        tabelaCadastros.setModel(tableModel);
        pesquisarCadastro();        
    }
    
    public static ListarCadastros getInstance(){
        if(singleton == null){
            singleton = new ListarCadastros();
        }
        return singleton;
    }
    
    public static ListarCadastros newInstance(){
        singleton = new ListarCadastros();
        return singleton;
    }
    
    public void atualizarTabela(Cadastro c){
        tableModel.setValueAt(c, tabelaCadastros.getSelectedRow());
    }
    
    public Cadastro getSelecionado(){
        return tableModel.getCadastro(tabelaCadastros.getSelectedRow());
    }
 
    public void pesquisarCadastro(){
        try {
            cadastros = facade.getCadastro("%"+c_Pesquisar.getText()+"%");  
            tableModel.addListaDeCadastros(cadastros);
        } catch (SCBFacadeException ex) {
            Logger.getLogger(ListarCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
   
    public void removerCadastroTabela(){
        tableModel.removeCadastro(tabelaCadastros.getSelectedRow());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_Fechar = new javax.swing.JButton();
        l_Titulo = new javax.swing.JLabel();
        c_Pesquisar = new javax.swing.JTextField();
        b_Pesquisar = new javax.swing.JButton();
        b_Editar = new javax.swing.JButton();
        b_Excluir = new javax.swing.JButton();
        b_Visualizar = new javax.swing.JButton();
        sp_Cadastros = new javax.swing.JScrollPane();
        tabelaCadastros = new javax.swing.JTable();
        d_Text1 = new javax.swing.JLabel();

        setBorder(null);

        b_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Fechar.setText("Fechar");
        b_Fechar.setToolTipText("");
        b_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_FecharActionPerformed(evt);
            }
        });

        l_Titulo.setForeground(new java.awt.Color(102, 102, 102));
        l_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Titulo.setText("Cadastros");

        c_Pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_PesquisarKeyPressed(evt);
            }
        });

        b_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/zoom.png"))); // NOI18N
        b_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_PesquisarActionPerformed(evt);
            }
        });

        b_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_edit.png"))); // NOI18N
        b_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_EditarActionPerformed(evt);
            }
        });

        b_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_delete.png"))); // NOI18N
        b_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ExcluirActionPerformed(evt);
            }
        });

        b_Visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page.png"))); // NOI18N
        b_Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_VisualizarActionPerformed(evt);
            }
        });

        tabelaCadastros.getTableHeader().setResizingAllowed(false);
        sp_Cadastros.setViewportView(tabelaCadastros);

        d_Text1.setText("Pesquise pelo nome ou matricula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(b_Visualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_Excluir)
                                    .addComponent(b_Editar)))))
                    .addComponent(d_Text1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(c_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Pesquisar)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_Fechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_Editar, b_Excluir, b_Visualizar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(l_Titulo)
                .addGap(30, 30, 30)
                .addComponent(d_Text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_Pesquisar))
                        .addGap(18, 18, 18)
                        .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_Visualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Excluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(b_Fechar))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-553)/2, (screenSize.height-382)/2, 553, 382);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        Main.limparCampos(evt);
        dispose();
        Main.setMenu(true);
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void b_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarActionPerformed
        // TODO add your handling code here:    
            pesquisarCadastro();

    }//GEN-LAST:event_b_PesquisarActionPerformed

    private void b_VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_VisualizarActionPerformed
        // TODO add your handling code here:
        if (tabelaCadastros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o cadastro a ser visualizado.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            exibirCadastro = new ExibirCadastro(getSelecionado());

            Main.desktop.remove(exibirCadastro);
            Main.desktop.add(exibirCadastro);
            this.dispose();
            exibirCadastro.show();
        }
    }//GEN-LAST:event_b_VisualizarActionPerformed

    private void b_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ExcluirActionPerformed
        // TODO add your handling code here:
          if (tabelaCadastros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o cadastro a ser excluído.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int choose = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esse cadastro?", "Excluir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(choose == 0){
                new File(Util.dirImageLoad("cadastres", getSelecionado().getMatricula())).delete();                
                try {
                    facade.excluirCadastro(getSelecionado().getId());
                    removerCadastroTabela();
                } catch (SCBFacadeException ex) {
                    Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
          }    
        }
    }//GEN-LAST:event_b_ExcluirActionPerformed

    private void b_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_EditarActionPerformed
        // TODO add your handling code here:
        if (tabelaCadastros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o cadastro a ser editado.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            editarCadastro = new EditarCadastro(getSelecionado());
            
            Main.desktop.remove(editarCadastro);
            Main.desktop.add(editarCadastro);
            this.dispose();
            editarCadastro.show();                   
        
        }
    }//GEN-LAST:event_b_EditarActionPerformed

    private void c_PesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_PesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             pesquisarCadastro();
        }
    }//GEN-LAST:event_c_PesquisarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Editar;
    private javax.swing.JButton b_Excluir;
    private javax.swing.JButton b_Fechar;
    private javax.swing.JButton b_Pesquisar;
    private javax.swing.JButton b_Visualizar;
    private javax.swing.JTextField c_Pesquisar;
    private javax.swing.JLabel d_Text1;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JScrollPane sp_Cadastros;
    private javax.swing.JTable tabelaCadastros;
    // End of variables declaration//GEN-END:variables
private SCBFacade facade;
private List<Cadastro> cadastros;
private EditarCadastro editarCadastro;
private ExibirCadastro exibirCadastro;
private CadastroTableModel tableModel; 
private static ListarCadastros singleton;

}
