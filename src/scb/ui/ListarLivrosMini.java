package scb.ui;


import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scb.Cadastro;
import scb.CadastroTableModel;
import scb.Livro;
import scb.LivroTableModel;
import scb.SCBFacade;
import scb.SCBFacadeException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erickson
 */

public class ListarLivrosMini extends javax.swing.JInternalFrame {
         
    public ListarLivrosMini() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        facade = SCBFacade.getInstance();
        tableModel = new LivroTableModel();
        tabelaLivros.setModel(tableModel);
        novoEmprestimo = NovoEmprestimo.getInstance();
        pesquisarLivro();        
    }
    
 
    public void pesquisarLivro(){
        try {
            livros = facade.getLivro("%"+c_Pesquisar.getText()+"%");  
            tableModel.addListaDeLivros(livros);
        } catch (SCBFacadeException ex) {
            Logger.getLogger(ListarLivrosMini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_Fechar = new javax.swing.JButton();
        l_Titulo = new javax.swing.JLabel();
        c_Pesquisar = new javax.swing.JTextField();
        b_Pesquisar = new javax.swing.JButton();
        sp_Cadastros = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        d_Text1 = new javax.swing.JLabel();
        b_Selecionar = new javax.swing.JButton();

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
        l_Titulo.setText("Livros");

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

        tabelaLivros.getTableHeader().setResizingAllowed(false);
        sp_Cadastros.setViewportView(tabelaLivros);

        d_Text1.setText("Pesquise pelo título ou registro:");

        b_Selecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/tick.png"))); // NOI18N
        b_Selecionar.setText("Selecionar");
        b_Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_Text1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(c_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Pesquisar))
                    .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(b_Selecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_Fechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(l_Titulo)
                .addGap(18, 18, 18)
                .addComponent(d_Text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_Pesquisar)
                    .addComponent(c_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(b_Selecionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Fechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-358)/2, (screenSize.height-407)/2, 358, 407);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        dispose();
        novoEmprestimo.setVisible(true);
    }//GEN-LAST:event_b_FecharActionPerformed

    private void b_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarActionPerformed
        // TODO add your handling code here:    
            pesquisarLivro();
           

    }//GEN-LAST:event_b_PesquisarActionPerformed

    private void c_PesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_PesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             pesquisarLivro();

        }
    }//GEN-LAST:event_c_PesquisarKeyPressed

    private void b_SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SelecionarActionPerformed
        // TODO add your handling code here:
        if (tabelaLivros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o livro.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }else{
            l = tableModel.getLivro(tabelaLivros.getSelectedRow());
            novoEmprestimo.setCamposLivro(l);
            this.dispose();
            novoEmprestimo.setVisible(true);
            
            
        }
    }//GEN-LAST:event_b_SelecionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Fechar;
    private javax.swing.JButton b_Pesquisar;
    private javax.swing.JButton b_Selecionar;
    private javax.swing.JTextField c_Pesquisar;
    private javax.swing.JLabel d_Text1;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JScrollPane sp_Cadastros;
    private javax.swing.JTable tabelaLivros;
    // End of variables declaration//GEN-END:variables
private SCBFacade facade;
private Livro l;
private List<Livro> livros;
private LivroTableModel tableModel; 
private NovoEmprestimo novoEmprestimo;


}
