package scb.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scb.Cadastro;
import scb.Emprestimo;
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
public class NovoEmprestimo extends javax.swing.JInternalFrame {

    private NovoEmprestimo() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        this.setLocation(Util.gerarPosicao(this.getSize()));        
        facade = SCBFacade.getInstance();
        offCampos();
    }
    
    public static NovoEmprestimo getInstance(){
        if(singleton == null){
            singleton = new NovoEmprestimo();
        }
        return singleton;
    }
    
    public void offCampos(){
        c_Nome.setEnabled(false);
        c_Categoria.setEnabled(false);
        c_Titulo.setEnabled(false);
        c_Autor.setEnabled(false);
    }
        
    public void salvarEmprestimo(){
        Emprestimo e = new Emprestimo();
        e.setMatriculaCadastro(c_Matricula.getText());
        e.setNomeCadastro(c_Nome.getText());
        e.setCategoriaCadastro(c_Categoria.getText());
        e.setRegistroLivro(c_Registro.getText());
        e.setTituloLivro(c_Titulo.getText());
        e.setAutorLivro(c_Autor.getText());
        e.setDataEmprestimo(c_DataEmprestimo.getDate());
        e.setDataDevolucao(c_DataDevolucao.getDate());
        e.setUsuarioResponsavel(Main.getUsuario());   
        if(verify(e)){
            saveEmprestimo(e);
        }else{
            int choose = JOptionPane.showConfirmDialog(null, "Esse cadastro possui 3 empréstimos em aberto. \nDeseja continuar mesmo assim?", "Aviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
             if(choose == 0){
                 saveEmprestimo(e);
                 JOptionPane.showMessageDialog (null, "Empréstimo realizado com sucesso.", "Operação concluída", JOptionPane.INFORMATION_MESSAGE);  
             }
        
        }


     
    }
    
    public void saveEmprestimo(Emprestimo e){
        try {
            facade.salvarEmprestimo(e);
        } catch (SCBFacadeException ex) {
           JOptionPane.showMessageDialog (null, "Falha ao cadastrar empréstimo.", "Operação concluída", JOptionPane.INFORMATION_MESSAGE);              

            Logger.getLogger(NovoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verify(Emprestimo e){ 
        try {
            emprestimos = facade.getEmprestimo(e.getMatriculaCadastro());
        } catch (SCBFacadeException ex) {
            Logger.getLogger(NovoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int verifica = 0;
        for(Emprestimo emprestimo: emprestimos){
            if(emprestimo.getMatriculaCadastro().equals(e.getMatriculaCadastro())){
                if(!emprestimo.getEntrega()){
                    verifica += 1;
                }
                if(verifica == 3){
                    return false;
                }
            }
           else{
                return false;
           }    
        }
        return true;

}


    
    public void setCamposCadastro(Cadastro c){
        c_Nome.setText(c.getNome());
        c_Matricula.setText(c.getMatricula());
        c_Categoria.setText(c.getCategoria());
    }
    
    public void setCamposLivro(Livro l){
        c_Registro.setText(l.getRegistro());
        c_Titulo.setText(l.getTitulo());
        c_Autor.setText(l.getAutor());
    }
    
    public void pesquisarCadastro(){
         List<Cadastro> cadastro = new ArrayList<>();
        try {
            cadastro = facade.getCadastro(c_Matricula.getText());
        } catch (SCBFacadeException ex) {
            Logger.getLogger(NovoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(c_Matricula.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Digite o número da matrícula.");  
        }
        else if(cadastro.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há cadastro com os dados informados."); 
            c_Matricula.setText("");
            c_Nome.setText("");
            c_Categoria.setText("");

        }
        else{
            setCamposCadastro(cadastro.get(0));
        }
    }

    public void pesquisarLivro(){
         List<Livro> livro = new ArrayList<>();
        try {
            livro = facade.getLivro(c_Registro.getText());
        } catch (SCBFacadeException ex) {
            Logger.getLogger(NovoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(c_Registro.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Digite o número do registro.");  
        }
        else if(livro.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há livro com os dados informados.");  
            c_Registro.setText("");
            c_Titulo.setText("");
            c_Autor.setText("");

        }
        else{
            setCamposLivro(livro.get(0));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_Salvar = new javax.swing.JButton();
        b_Cancelar = new javax.swing.JButton();
        l_Titulo = new javax.swing.JLabel();
        p_Cadastro = new javax.swing.JPanel();
        c_Matricula = new javax.swing.JTextField();
        d_Matricula = new javax.swing.JLabel();
        b_PesquisarCadastro = new javax.swing.JButton();
        b_ListarCadastros = new javax.swing.JButton();
        c_Nome = new javax.swing.JTextField();
        c_Categoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p_Livro = new javax.swing.JPanel();
        d_Registro = new javax.swing.JLabel();
        c_Registro = new javax.swing.JTextField();
        b_PesquisarLivro = new javax.swing.JButton();
        b_ListarLivros = new javax.swing.JButton();
        c_Titulo = new javax.swing.JTextField();
        c_Autor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p_Emprestimo = new javax.swing.JPanel();
        d_DataEmprestimo = new javax.swing.JLabel();
        d_DataDevolucao = new javax.swing.JLabel();
        c_DataDevolucao = new com.toedter.calendar.JDateChooser();
        c_DataEmprestimo = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        b_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/tick.png"))); // NOI18N
        b_Salvar.setText("Salvar");
        b_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SalvarActionPerformed(evt);
            }
        });

        b_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Cancelar.setText("Cancelar");
        b_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CancelarActionPerformed(evt);
            }
        });

        l_Titulo.setForeground(new java.awt.Color(102, 102, 102));
        l_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Titulo.setText("Realização de empréstimo");

        p_Cadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Cadastrais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        c_Matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        d_Matricula.setText("Matrícula:");

        b_PesquisarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_white_magnify.png"))); // NOI18N
        b_PesquisarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_PesquisarCadastroActionPerformed(evt);
            }
        });

        b_ListarCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_white_stack.png"))); // NOI18N
        b_ListarCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ListarCadastrosActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Categoria:");

        javax.swing.GroupLayout p_CadastroLayout = new javax.swing.GroupLayout(p_Cadastro);
        p_Cadastro.setLayout(p_CadastroLayout);
        p_CadastroLayout.setHorizontalGroup(
            p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_CadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(c_Categoria))
                .addContainerGap())
            .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_CadastroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(d_Matricula)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(b_PesquisarCadastro)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(b_ListarCadastros)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );
        p_CadastroLayout.setVerticalGroup(
            p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_CadastroLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
            .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_CadastroLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(p_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Matricula)
                        .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_PesquisarCadastro)
                        .addComponent(b_ListarCadastros))
                    .addContainerGap(63, Short.MAX_VALUE)))
        );

        p_Livro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_Registro.setText("Registro:");

        c_Registro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_PesquisarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_white_magnify.png"))); // NOI18N
        b_PesquisarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_PesquisarLivroActionPerformed(evt);
            }
        });

        b_ListarLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/page_white_stack.png"))); // NOI18N
        b_ListarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ListarLivrosActionPerformed(evt);
            }
        });

        jLabel3.setText("Título:");

        jLabel4.setText("Autor:");

        javax.swing.GroupLayout p_LivroLayout = new javax.swing.GroupLayout(p_Livro);
        p_Livro.setLayout(p_LivroLayout);
        p_LivroLayout.setHorizontalGroup(
            p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_LivroLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(b_PesquisarLivro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_ListarLivros)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_LivroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_Autor)
                    .addComponent(c_Titulo))
                .addContainerGap())
            .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_LivroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(d_Registro)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(c_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(301, Short.MAX_VALUE)))
        );
        p_LivroLayout.setVerticalGroup(
            p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_LivroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_ListarLivros)
                    .addComponent(b_PesquisarLivro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Autor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_LivroLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(p_LivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d_Registro)
                        .addComponent(c_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        p_Emprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do empréstimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_DataEmprestimo.setText("Data do empréstimo:");

        d_DataDevolucao.setText("Data da devolução:");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 20);
        c_DataDevolucao.setDate(c.getTime());

        c_DataEmprestimo.setDate(new Date());

        javax.swing.GroupLayout p_EmprestimoLayout = new javax.swing.GroupLayout(p_Emprestimo);
        p_Emprestimo.setLayout(p_EmprestimoLayout);
        p_EmprestimoLayout.setHorizontalGroup(
            p_EmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_EmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(d_DataEmprestimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_DataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(d_DataDevolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        p_EmprestimoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {c_DataDevolucao, c_DataEmprestimo});

        p_EmprestimoLayout.setVerticalGroup(
            p_EmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_EmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_EmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_DataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p_EmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(d_DataDevolucao)
                        .addComponent(d_DataEmprestimo)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(p_Livro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p_Emprestimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p_Cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(l_Titulo)
                .addGap(18, 18, 18)
                .addComponent(p_Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_Livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p_Emprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_Cancelar)
                    .addComponent(b_Salvar))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(515, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void b_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CancelarActionPerformed
        // TODO add your handling code here:
        Main.limparCampos(evt);
        dispose();
        Main.setMenu(true);
    }//GEN-LAST:event_b_CancelarActionPerformed

    private void b_PesquisarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarCadastroActionPerformed
       pesquisarCadastro();
    }//GEN-LAST:event_b_PesquisarCadastroActionPerformed

    private void b_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SalvarActionPerformed
        // TODO add your handling code here:
        salvarEmprestimo();
        Main.limparCampos(evt);
        dispose();
        Main.setMenu(true);
    }//GEN-LAST:event_b_SalvarActionPerformed

    private void b_PesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PesquisarLivroActionPerformed
        // TODO add your handling code here:
        pesquisarLivro();
    }//GEN-LAST:event_b_PesquisarLivroActionPerformed

    private void b_ListarCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ListarCadastrosActionPerformed
        // TODO add your handling code here
           listarCadastros = new ListarCadastrosMini();
           Main.desktop.remove(listarCadastros);
           Main.desktop.add(listarCadastros);
           this.setVisible(false);
           listarCadastros.show();
    }//GEN-LAST:event_b_ListarCadastrosActionPerformed

    private void b_ListarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ListarLivrosActionPerformed
        // TODO add your handling code here:
           listarLivros = new ListarLivrosMini();
           Main.desktop.remove(listarLivros);
           Main.desktop.add(listarLivros);
           this.setVisible(false);           
           listarLivros.show();
    }//GEN-LAST:event_b_ListarLivrosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Cancelar;
    private javax.swing.JButton b_ListarCadastros;
    private javax.swing.JButton b_ListarLivros;
    private javax.swing.JButton b_PesquisarCadastro;
    private javax.swing.JButton b_PesquisarLivro;
    private javax.swing.JButton b_Salvar;
    private javax.swing.JTextField c_Autor;
    private static javax.swing.JTextField c_Categoria;
    private com.toedter.calendar.JDateChooser c_DataDevolucao;
    private com.toedter.calendar.JDateChooser c_DataEmprestimo;
    private static javax.swing.JTextField c_Matricula;
    private static javax.swing.JTextField c_Nome;
    private javax.swing.JTextField c_Registro;
    private javax.swing.JTextField c_Titulo;
    private javax.swing.JLabel d_DataDevolucao;
    private javax.swing.JLabel d_DataEmprestimo;
    private javax.swing.JLabel d_Matricula;
    private javax.swing.JLabel d_Registro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JPanel p_Cadastro;
    private javax.swing.JPanel p_Emprestimo;
    private javax.swing.JPanel p_Livro;
    // End of variables declaration//GEN-END:variables
    private SCBFacade facade;
    private ListarCadastrosMini listarCadastros;
    private ListarLivrosMini listarLivros;
    private static NovoEmprestimo singleton;
    private List<Emprestimo> emprestimos;


}
