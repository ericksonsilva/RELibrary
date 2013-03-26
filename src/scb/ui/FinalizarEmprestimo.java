package scb.ui;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JOptionPane;
import scb.Emprestimo;
import scb.EmprestimoTableModel;
import scb.JImagePanel;
import scb.Logger;
import scb.SCBFacade;
import scb.SCBFacadeException;
import scb.Util;
import static scb.ui.Main.desktop;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erickson
 */

public class FinalizarEmprestimo extends javax.swing.JInternalFrame {

    public FinalizarEmprestimo() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        initComponents();
        this.setLocation(Util.gerarPosicao(this.getSize()));        
        
        setFotoDefault();
        p_Dados.setVisible(false);
        offCampos();
        facade = SCBFacade.getInstance();
        logger = scb.Logger.getInstance();
        tableModel = new EmprestimoTableModel();
        tabelaEmprestimos.setModel(tableModel);
        pesquisarEmprestimo();
    }
    
  
    public void setFotoDefault(){
        try {
            imgPanel = new JImagePanel(Util.getDirCad());
            imgPanel.setPreferredSize(new Dimension(130, 140));
            p_Foto.add(imgPanel);            
        } catch (IOException ex) {
            logger.log(ex);
        }
    }    
    

    public void offCampos(){
        c_Nome.setEnabled(false);
        c_Matricula.setEnabled(false);
        c_Registro.setEnabled(false);
        c_Titulo.setEnabled(false);
    }
    
    public void setCampos(Emprestimo e){
        p_Dados.setVisible(true);
        c_Nome.setText(e.getNomeCadastro());
        c_Matricula.setText(e.getMatriculaCadastro());
        c_Registro.setText(e.getRegistroLivro());
        c_Titulo.setText(e.getTituloLivro());
        if (!(new File(Util.dirImageLoad("cadastres", e.getMatriculaCadastro()))).exists()) {
                setJImagePanel(Util.getDirCad());
        }else{
            setJImagePanel(Util.dirImageLoad("cadastres", e.getMatriculaCadastro()));
        }
        
    }
    
    public void setJImagePanel(String caminho){
        try { 
            imgPanel.setImage(caminho);
            imgPanel.repaint();            
        } catch (IOException ex) {
            logger.log(ex.getMessage(), ex);
        }
            
    }    
    
    public void atualizarTabela(Emprestimo e){
        tableModel.setValueAt(e, tabelaEmprestimos.getSelectedRow());
    }

    public void pesquisarEmprestimo(){
        try {
            emprestimos = facade.getEmprestimo("%"+c_Pesquisar.getText()+"%");
            emprestimos = Util.EmprestimosNaoFinalizados(emprestimos);
            tableModel.addListaDeEmprestimos(emprestimos);           
        } catch (SCBFacadeException ex) {
            logger.log(ex);
            }
    }


    public void removerEmprestimoTabela(){
        tableModel.removeEmprestimo(tabelaEmprestimos.getSelectedRow());
    }
    
    public Emprestimo getSelecionado(){
        return tableModel.getEmprestimo(tabelaEmprestimos.getSelectedRow());
    }
    
 
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        b_Fechar = new javax.swing.JButton();
        l_Titulo = new javax.swing.JLabel();
        c_Pesquisar = new javax.swing.JTextField();
        b_Pesquisar = new javax.swing.JButton();
        sp_Cadastros = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        d_Text1 = new javax.swing.JLabel();
        b_FinalizarEmprestimo = new javax.swing.JButton();
        p_Dados = new javax.swing.JPanel();
        d_Matricula = new javax.swing.JLabel();
        d_Nome = new javax.swing.JLabel();
        d_Registro = new javax.swing.JLabel();
        d_Titulo = new javax.swing.JLabel();
        c_Matricula = new javax.swing.JTextField();
        c_Nome = new javax.swing.JTextField();
        c_Registro = new javax.swing.JTextField();
        c_Titulo = new javax.swing.JTextField();
        p_Foto = new javax.swing.JPanel();

        setBorder(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        l_Titulo.setText("Finalizar empréstimos");

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

        tabelaEmprestimos.getTableHeader().setResizingAllowed(false);
        tabelaEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmprestimosMouseClicked(evt);
            }
        });
        sp_Cadastros.setViewportView(tabelaEmprestimos);

        d_Text1.setText("Pesquise pela matricula ou ID:");

        b_FinalizarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cancel.png"))); // NOI18N
        b_FinalizarEmprestimo.setText("Finalizar Empréstimo");
        b_FinalizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_FinalizarEmprestimoActionPerformed(evt);
            }
        });

        p_Dados.setBorder(new javax.swing.border.MatteBorder(null));

        d_Matricula.setText("Matrícula:");

        d_Nome.setText("Nome:");

        d_Registro.setText("Registro:");

        d_Titulo.setText("Título:");

        javax.swing.GroupLayout p_DadosLayout = new javax.swing.GroupLayout(p_Dados);
        p_Dados.setLayout(p_DadosLayout);
        p_DadosLayout.setHorizontalGroup(
            p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(p_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_DadosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(d_Titulo))
                            .addGroup(p_DadosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(d_Registro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_Registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_DadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_Matricula)
                            .addComponent(d_Nome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        p_DadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {c_Nome, c_Registro, c_Titulo});

        p_DadosLayout.setVerticalGroup(
            p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosLayout.createSequentialGroup()
                        .addComponent(p_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_DadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Matricula)
                            .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Nome)
                            .addComponent(c_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d_Registro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Titulo)
                            .addComponent(c_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_Fechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(c_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d_Text1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_Dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_FinalizarEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_Titulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(d_Text1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_Pesquisar)
                            .addComponent(b_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_Cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_FinalizarEmprestimo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Fechar)
                .addContainerGap())
        );

        setBounds(200, 200, 598, 329);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        Main.limparCampos(evt);
        dispose();
        Main.setMenu(true);
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void b_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarActionPerformed
        // TODO add your handling code here:    
            pesquisarEmprestimo();

    }//GEN-LAST:event_b_PesquisarActionPerformed

    private void c_PesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_PesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
             pesquisarEmprestimo();
  
        }
    }//GEN-LAST:event_c_PesquisarKeyPressed

    private void tabelaEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmprestimosMouseClicked
        // TODO add your handling code here:
        Emprestimo e = getSelecionado();
        setCampos(e);
        
        
        
    }//GEN-LAST:event_tabelaEmprestimosMouseClicked

    private void b_FinalizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FinalizarEmprestimoActionPerformed
        // TODO add your handling code here:
            int choose = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja finalizar esse empréstimo?", "Excluir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(choose == 0){
            Emprestimo e = getSelecionado();
            e.setEntrega(true);
            try {
                facade.editarEmprestimo(e);
            } catch (SCBFacadeException ex) {
                JOptionPane.showMessageDialog (null, ex.getMessage(), "Erro ao encerrar empréstimo", JOptionPane.INFORMATION_MESSAGE);            

            }
            p_Dados.setVisible(false);
            tableModel.removeEmprestimo(tabelaEmprestimos.getSelectedRow());
            }
    }//GEN-LAST:event_b_FinalizarEmprestimoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Fechar;
    private javax.swing.JButton b_FinalizarEmprestimo;
    private javax.swing.JButton b_Pesquisar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField c_Matricula;
    private javax.swing.JTextField c_Nome;
    private javax.swing.JTextField c_Pesquisar;
    private javax.swing.JTextField c_Registro;
    private javax.swing.JTextField c_Titulo;
    private javax.swing.JLabel d_Matricula;
    private javax.swing.JLabel d_Nome;
    private javax.swing.JLabel d_Registro;
    private javax.swing.JLabel d_Text1;
    private javax.swing.JLabel d_Titulo;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JPanel p_Dados;
    private javax.swing.JPanel p_Foto;
    private javax.swing.JScrollPane sp_Cadastros;
    private javax.swing.JTable tabelaEmprestimos;
    // End of variables declaration//GEN-END:variables
private SCBFacade facade;
private List<Emprestimo> emprestimos;
private ExibirEmprestimo exibirEmprestimo;
private EmprestimoTableModel tableModel; 
private JImagePanel imgPanel;
private Logger logger;

    private void setJImagePanel(InputStream dirCad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
