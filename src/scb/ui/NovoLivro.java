package scb.ui;


import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import scb.JImagePanel;
import scb.Livro;
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
public class NovoLivro extends javax.swing.JInternalFrame {
    
    public NovoLivro() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        facade = SCBFacade.getInstance();
        setFotoDefault();
        imgPanel.setPreferredSize(new Dimension(130, 140));
        p_Foto.add(imgPanel);         
    }
    
    public void setFotoDefault(){
        try {
            imgPanel = new JImagePanel(Util.getDirLiv());
        } catch (IOException ex) {
            Logger.getLogger(NovoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    public void salvarLivro(){
        Livro l = new Livro();
        l.setTitulo(c_Titulo.getText());
        l.setAutor(c_Autor.getText());
        l.setEdicao(c_Edicao.getText());
        l.setAno(c_Ano.getText());
        l.setEditora(c_Editora.getText());
        l.setInf(c_Inf.getText());
        l.setRegistro(c_Registro.getText());
        l.setData(c_Data.getDate());
        l.setBiblioteca(String.valueOf(cb_Biblioteca.getSelectedItem()));
        try {
            facade.salvarLivro(l);
            JOptionPane.showMessageDialog (null, "Livro cadastrado com sucesso.", "Operação concluída", JOptionPane.INFORMATION_MESSAGE);              
            
        } catch (SCBFacadeException ex) {
            JOptionPane.showMessageDialog (null, "Falha ao cadastrar livro.", "Operação concluída", JOptionPane.INFORMATION_MESSAGE);              
            
            Logger.getLogger(EditarCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        String out = Util.dirImageSave("books", l.getRegistro()); 
        Util.copyfile(imgPanel.getImage(), out);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        b_Cancelar = new javax.swing.JButton();
        p_DadosPessoais = new javax.swing.JPanel();
        d_Titulo = new javax.swing.JLabel();
        c_Titulo = new javax.swing.JTextField();
        d_Autor = new javax.swing.JLabel();
        c_Autor = new javax.swing.JTextField();
        d_Edicao = new javax.swing.JLabel();
        c_Edicao = new javax.swing.JTextField();
        d_InfAdicional = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        c_Inf = new javax.swing.JTextArea();
        d_Ano = new javax.swing.JLabel();
        c_Ano = new javax.swing.JTextField();
        d_Editora = new javax.swing.JLabel();
        c_Editora = new javax.swing.JTextField();
        p_DadosAcademicos = new javax.swing.JPanel();
        d_Registro = new javax.swing.JLabel();
        c_Registro = new javax.swing.JTextField();
        d_Data = new javax.swing.JLabel();
        d_Biblioteca = new javax.swing.JLabel();
        cb_Biblioteca = new javax.swing.JComboBox();
        c_Data = new com.toedter.calendar.JDateChooser();
        b_Salvar = new javax.swing.JButton();
        b_Limpar = new javax.swing.JButton();
        l_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        p_Foto = new javax.swing.JPanel();
        b_ProcurarFoto = new javax.swing.JButton();
        b_ExcluirFoto = new javax.swing.JButton();

        fileChooser.setApproveButtonToolTipText("");
        fileChooser.setBackground(java.awt.Color.white);
        fileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\Erickson\\Pictures"));
        fileChooser.setDialogTitle("Selecione a foto");
        fileChooser.setFileFilter(Util.getFilter());

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        b_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Cancelar.setText("Cancelar");
        b_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CancelarActionPerformed(evt);
            }
        });

        p_DadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Bibliográficos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_Titulo.setText("Título:");

        d_Autor.setText("Autor:");

        d_Edicao.setText("Edição:");

        d_InfAdicional.setText("Inf. Adicional:");

        c_Inf.setColumns(20);
        c_Inf.setRows(5);
        jScrollPane1.setViewportView(c_Inf);

        d_Ano.setText("Ano:");

        d_Editora.setText("Editora:");

        javax.swing.GroupLayout p_DadosPessoaisLayout = new javax.swing.GroupLayout(p_DadosPessoais);
        p_DadosPessoais.setLayout(p_DadosPessoaisLayout);
        p_DadosPessoaisLayout.setHorizontalGroup(
            p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_Autor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                                .addComponent(d_Titulo)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_DadosPessoaisLayout.createSequentialGroup()
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_Edicao)
                            .addComponent(d_Ano)
                            .addComponent(d_Editora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_Edicao)
                            .addComponent(c_Ano)
                            .addComponent(c_Editora, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_DadosPessoaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(d_InfAdicional)
                .addGap(112, 112, 112))
        );

        p_DadosPessoaisLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {c_Autor, c_Titulo});

        p_DadosPessoaisLayout.setVerticalGroup(
            p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Titulo)
                    .addComponent(c_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Autor)
                    .addComponent(c_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(d_InfAdicional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Edicao)
                            .addComponent(c_Edicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Ano)
                            .addComponent(c_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d_Editora)
                            .addComponent(c_Editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        p_DadosAcademicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_Registro.setText("Registro:");

        d_Data.setText("Data:");

        d_Biblioteca.setText("Biblioteca:");

        cb_Biblioteca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CCAE", "CAMPUS I", "Desing", "Ecologia", "Antropologia", "Matemática" }));

        c_Data.setDate(new Date());

        javax.swing.GroupLayout p_DadosAcademicosLayout = new javax.swing.GroupLayout(p_DadosAcademicos);
        p_DadosAcademicos.setLayout(p_DadosAcademicosLayout);
        p_DadosAcademicosLayout.setHorizontalGroup(
            p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                        .addComponent(d_Biblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_Biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                        .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_Registro)
                            .addComponent(d_Data))
                        .addGap(8, 8, 8)
                        .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        p_DadosAcademicosLayout.setVerticalGroup(
            p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Registro)
                    .addComponent(c_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(d_Data)
                    .addComponent(c_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Biblioteca)
                    .addComponent(cb_Biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        b_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/tick.png"))); // NOI18N
        b_Salvar.setText("Salvar");
        b_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SalvarActionPerformed(evt);
            }
        });

        b_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/textfield_delete.png"))); // NOI18N
        b_Limpar.setText("Limpar");
        b_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_LimparActionPerformed(evt);
            }
        });

        l_Titulo.setForeground(new java.awt.Color(102, 102, 102));
        l_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Titulo.setText("Cadastramento de livro");

        p_Foto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        b_ProcurarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/folder_explore.png"))); // NOI18N
        b_ProcurarFoto.setToolTipText("Procurar no computador");
        b_ProcurarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ProcurarFotoActionPerformed(evt);
            }
        });
        p_Foto.add(b_ProcurarFoto);

        b_ExcluirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/image_delete.png"))); // NOI18N
        b_ExcluirFoto.setToolTipText("Excluir");
        b_ExcluirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ExcluirFotoActionPerformed(evt);
            }
        });
        p_Foto.add(b_ExcluirFoto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(p_DadosAcademicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_DadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_Limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_Salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Cancelar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_Cancelar, b_Limpar, b_Salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_DadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_DadosAcademicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_Cancelar)
                    .addComponent(b_Salvar)
                    .addComponent(b_Limpar))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-515)/2, (screenSize.height-560)/2, 515, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void b_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CancelarActionPerformed
        // TODO add your handling code here:
        Main.setMenu(true);
        dispose();
    }//GEN-LAST:event_b_CancelarActionPerformed

    private void b_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_LimparActionPerformed
        // TODO add your handling code here:
        Main.limparCampos(evt);          
           
    }//GEN-LAST:event_b_LimparActionPerformed

    private void b_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SalvarActionPerformed
        salvarLivro();
        Main.setMenu(true);
        dispose();
        Main.limparCampos(evt);
        
        
    }//GEN-LAST:event_b_SalvarActionPerformed

    private void b_ProcurarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ProcurarFotoActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try {
                imgPanel.removeAll();
                imgPanel.setImage(arquivo);
                imgPanel.repaint();
            } catch (IOException ex) {
                Logger.getLogger(EditarCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b_ProcurarFotoActionPerformed

    private void b_ExcluirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ExcluirFotoActionPerformed
        try {
            // TODO add your handling code here:
            imgPanel.setImage(Util.getDirLiv());
            imgPanel.repaint();

        } catch (IOException ex) {
            Logger.getLogger(EditarCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b_ExcluirFotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Cancelar;
    private javax.swing.JButton b_ExcluirFoto;
    private javax.swing.JButton b_Limpar;
    private javax.swing.JButton b_ProcurarFoto;
    private javax.swing.JButton b_Salvar;
    private javax.swing.JTextField c_Ano;
    private javax.swing.JTextField c_Autor;
    private com.toedter.calendar.JDateChooser c_Data;
    private javax.swing.JTextField c_Edicao;
    private javax.swing.JTextField c_Editora;
    private javax.swing.JTextArea c_Inf;
    private javax.swing.JTextField c_Registro;
    private javax.swing.JTextField c_Titulo;
    private javax.swing.JComboBox cb_Biblioteca;
    private javax.swing.JLabel d_Ano;
    private javax.swing.JLabel d_Autor;
    private javax.swing.JLabel d_Biblioteca;
    private javax.swing.JLabel d_Data;
    private javax.swing.JLabel d_Edicao;
    private javax.swing.JLabel d_Editora;
    private javax.swing.JLabel d_InfAdicional;
    private javax.swing.JLabel d_Registro;
    private javax.swing.JLabel d_Titulo;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JPanel p_DadosAcademicos;
    private javax.swing.JPanel p_DadosPessoais;
    private javax.swing.JPanel p_Foto;
    // End of variables declaration//GEN-END:variables
    private SCBFacade facade;
    private JImagePanel imgPanel;
}
