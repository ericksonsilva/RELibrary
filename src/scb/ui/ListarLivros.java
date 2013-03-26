package scb.ui;


import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scb.Livro;
import scb.LivroTableModel;
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
public class ListarLivros extends javax.swing.JInternalFrame {
    
    private ListarLivros(){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        facade = SCBFacade.getInstance();
        tableModel = new LivroTableModel();
        tabelaLivros.setModel(tableModel);
        pesquisarLivro(); 
    }

    public static ListarLivros getInstance(){
        if(singleton == null){
            singleton = new ListarLivros();
        }
        return singleton;
    }    

    public static ListarLivros newInstance(){
        singleton = new ListarLivros();
        return singleton;
    }    

    public void atualizarTabela(Livro l){
        tableModel.setValueAt(l, tabelaLivros.getSelectedRow());
    }
 
    public void pesquisarLivro(){
        try {
            livros = facade.getLivro("%"+c_Pesquisar.getText()+"%");  
            tableModel.addListaDeLivros(livros);
        } catch (SCBFacadeException ex) {
            Logger.getLogger(ListarCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
   
    public void removerLivroTabela(){
        tableModel.removeLivro(tabelaLivros.getSelectedRow());
    }
    
    public Livro getSelecionado(){
        return tableModel.getLivro(tabelaLivros.getSelectedRow());
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
        l_Titulo = new javax.swing.JLabel();
        c_Pesquisar = new javax.swing.JTextField();
        b_Pesquisar = new javax.swing.JButton();
        b_Editar = new javax.swing.JButton();
        b_Excluir = new javax.swing.JButton();
        b_Visualizar = new javax.swing.JButton();
        sp_Livros = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        d_Text1 = new javax.swing.JLabel();

        setBorder(null);

        b_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Fechar.setText("Fechar");
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

        b_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/magnifier.png"))); // NOI18N
        b_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_PesquisarActionPerformed(evt);
            }
        });

        b_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/book_edit.png"))); // NOI18N
        b_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_EditarActionPerformed(evt);
            }
        });

        b_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/book_delete.png"))); // NOI18N
        b_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ExcluirActionPerformed(evt);
            }
        });

        b_Visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/book.png"))); // NOI18N
        b_Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_VisualizarActionPerformed(evt);
            }
        });

        tabelaLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLivros.getTableHeader().setResizingAllowed(false);
        sp_Livros.setViewportView(tabelaLivros);

        d_Text1.setText("Pesquise pelo título ou registro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sp_Livros, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(40, Short.MAX_VALUE))
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
                        .addComponent(sp_Livros, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_Visualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Excluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(b_Fechar))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-555)/2, (screenSize.height-383)/2, 555, 383);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        Main.limparCampos(evt);
        dispose();
        Main.setMenu(true);
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void b_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarActionPerformed
        pesquisarLivro();

    }//GEN-LAST:event_b_PesquisarActionPerformed

    private void b_VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_VisualizarActionPerformed
        if (tabelaLivros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o livro a ser visualizado.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            exibirLivro = new ExibirLivro(getSelecionado());

            Main.desktop.remove(exibirLivro);
            Main.desktop.add(exibirLivro);
            this.dispose();
            exibirLivro.show();
        }
    }//GEN-LAST:event_b_VisualizarActionPerformed

    private void b_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ExcluirActionPerformed
        // TODO add your handling code here:
          if (tabelaLivros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o livro a ser excluído.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int choose = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esse livro?", "Excluir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(choose == 0){
                new File(Util.dirImageLoad("books", getSelecionado().getRegistro())).delete();                
                try {
                    facade.excluirLivro(getSelecionado().getId());
                    removerLivroTabela();

                } catch (SCBFacadeException ex) {
                    Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
          }    
        }
    }//GEN-LAST:event_b_ExcluirActionPerformed

    private void b_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_EditarActionPerformed
        if (tabelaLivros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escolha o livro a ser editado.", "Erro de seleção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            editarLivro = new EditarLivro(getSelecionado());
            
            Main.desktop.remove(editarLivro);
            Main.desktop.add(editarLivro);
            this.dispose();
            editarLivro.show();                   
        
        }
    }//GEN-LAST:event_b_EditarActionPerformed

    private void c_PesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_PesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             pesquisarLivro();
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
    private javax.swing.JScrollPane sp_Livros;
    private javax.swing.JTable tabelaLivros;
    // End of variables declaration//GEN-END:variables
private SCBFacade facade;
private List<Livro> livros;
private EditarLivro editarLivro;
private ExibirLivro exibirLivro;
private LivroTableModel tableModel; 
private static ListarLivros singleton;
}
