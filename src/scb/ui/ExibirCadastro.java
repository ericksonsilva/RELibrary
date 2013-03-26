package scb.ui;


import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import scb.Cadastro;
import scb.JImagePanel;
import scb.Util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erickson
 */
public class ExibirCadastro extends javax.swing.JInternalFrame {
    
    public ExibirCadastro(Cadastro c) {
            ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
            initComponents();
            this.c = c;
            offCampos();
            setCamposCadastro();
    }
    
      public void offCampos(){
            c_Nome.setEditable(false);
            c_Endereco.setEditable(false);
            c_NumeroCasa.setEditable(false);
            c_Complemento.setEditable(false);
            c_Bairro.setEditable(false);
            c_Cidade.setEditable(false);
            cb_Estado.setEnabled(false);
            c_CEP.setEditable(false);
            c_Telefone.setEditable(false);
            c_Email.setEditable(false);
            c_Matricula.setEditable(false);
            cb_Curso.setEnabled(false);
            cb_Categoria.setEnabled(false);

        }
    
    public void setCamposCadastro(){
        c_Nome.setText(c.getNome());
        c_Endereco.setText(c.getEndereco());
        c_NumeroCasa.setText(c.getNumero());
        c_Complemento.setText(c.getComplemento());
        c_Bairro.setText(c.getBairro());
        c_Cidade.setText(c.getCidade());
        cb_Estado.setSelectedItem(c.getEstado());
        c_CEP.setText(c.getCep());
        c_Telefone.setText(c.getTelefone());
        c_Email.setText(c.getEmail());
        c_Matricula.setText(c.getMatricula());
        cb_Curso.setSelectedItem(c.getCurso());
        cb_Categoria.setSelectedItem(c.getCategoria());
        if (!(new File(Util.dirImageLoad("cadastres", c.getMatricula()))).exists()) {
                setJImagePanel(Util.getDirCad());
        }else{
            setJImagePanel(Util.dirImageLoad("cadastres", c.getMatricula()));
        }   
    }
    
    public void setJImagePanel(String caminho){
        try { 
            imgPanel = new JImagePanel(caminho);
        } catch (IOException ex) {
            logger.log(ex.getMessage(), ex);
        }
            imgPanel.setPreferredSize(new Dimension(130, 140));
            p_Foto.add(imgPanel);
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
        p_DadosPessoais = new javax.swing.JPanel();
        d_NumeroCasa = new javax.swing.JLabel();
        d_Nome = new javax.swing.JLabel();
        c_Nome = new javax.swing.JTextField();
        d_Endereco = new javax.swing.JLabel();
        c_Endereco = new javax.swing.JTextField();
        c_NumeroCasa = new javax.swing.JTextField();
        d_Complemento = new javax.swing.JLabel();
        d_Cidade = new javax.swing.JLabel();
        d_Estado = new javax.swing.JLabel();
        d_Bairro = new javax.swing.JLabel();
        d_CEP = new javax.swing.JLabel();
        d_Telefone = new javax.swing.JLabel();
        c_Telefone = new javax.swing.JTextField();
        d_Email = new javax.swing.JLabel();
        c_Email = new javax.swing.JTextField();
        c_Complemento = new javax.swing.JTextField();
        c_Cidade = new javax.swing.JTextField();
        c_Bairro = new javax.swing.JTextField();
        c_CEP = new javax.swing.JTextField();
        cb_Estado = new javax.swing.JComboBox();
        p_DadosAcademicos = new javax.swing.JPanel();
        d_Categoria1 = new javax.swing.JLabel();
        cb_Categoria = new javax.swing.JComboBox();
        d_Matricula = new javax.swing.JLabel();
        c_Matricula = new javax.swing.JTextField();
        d_Curso = new javax.swing.JLabel();
        cb_Curso = new javax.swing.JComboBox();
        l_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        p_Foto = new javax.swing.JPanel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        b_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scb/data/icons/cross.png"))); // NOI18N
        b_Fechar.setText("Fechar");
        b_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_FecharActionPerformed(evt);
            }
        });

        p_DadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_NumeroCasa.setText("nº:");

        d_Nome.setText("Nome:");

        d_Endereco.setText("Endereço:");

        d_Complemento.setText("Complemento:");

        d_Cidade.setText("Cidade:");

        d_Estado.setText("Estado:");

        d_Bairro.setText("Bairro:");

        d_CEP.setText("CEP:");

        d_Telefone.setText("Telefone:");

        d_Email.setText("Email:");

        cb_Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));

        javax.swing.GroupLayout p_DadosPessoaisLayout = new javax.swing.GroupLayout(p_DadosPessoais);
        p_DadosPessoais.setLayout(p_DadosPessoaisLayout);
        p_DadosPessoaisLayout.setHorizontalGroup(
            p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                        .addComponent(d_Nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Nome))
                    .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                        .addComponent(d_Telefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(d_Email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_DadosPessoaisLayout.createSequentialGroup()
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_DadosPessoaisLayout.createSequentialGroup()
                                .addComponent(d_Complemento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(d_Bairro))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_DadosPessoaisLayout.createSequentialGroup()
                                .addComponent(d_Cidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(d_Estado)
                                .addGap(4, 4, 4)
                                .addComponent(cb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Bairro))
                            .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(d_CEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_CEP))))
                    .addGroup(p_DadosPessoaisLayout.createSequentialGroup()
                        .addComponent(d_Endereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(d_NumeroCasa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_NumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_DadosPessoaisLayout.setVerticalGroup(
            p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_DadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Nome)
                    .addComponent(c_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Endereco)
                    .addComponent(c_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_NumeroCasa)
                    .addComponent(c_NumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Complemento)
                    .addComponent(d_Bairro)
                    .addComponent(c_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Cidade)
                    .addComponent(d_Estado)
                    .addComponent(d_CEP)
                    .addComponent(c_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Telefone)
                    .addComponent(c_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_Email)
                    .addComponent(c_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        p_DadosAcademicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Acadêmicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        d_Categoria1.setText("Categoria:");

        cb_Categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Aluno", "Professor", "Funcionário" }));
        cb_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CategoriaActionPerformed(evt);
            }
        });

        d_Matricula.setText("Matrícula:");

        d_Curso.setText("Curso:");

        cb_Curso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "SI", "LCC", "Design", "Ecologia", "Antropologia", "Matemática" }));

        javax.swing.GroupLayout p_DadosAcademicosLayout = new javax.swing.GroupLayout(p_DadosAcademicos);
        p_DadosAcademicos.setLayout(p_DadosAcademicosLayout);
        p_DadosAcademicosLayout.setHorizontalGroup(
            p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                        .addComponent(d_Matricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                        .addComponent(d_Categoria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                        .addComponent(d_Curso)
                        .addGap(8, 8, 8)
                        .addComponent(cb_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        p_DadosAcademicosLayout.setVerticalGroup(
            p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_DadosAcademicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Categoria1)
                    .addComponent(cb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Matricula)
                    .addComponent(c_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_DadosAcademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_Curso)
                    .addComponent(cb_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        l_Titulo.setForeground(new java.awt.Color(102, 102, 102));
        l_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_Titulo.setText("Cadastramento de contas");

        p_Foto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_DadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p_DadosAcademicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_Fechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_DadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_DadosAcademicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Fechar)
                .addGap(26, 26, 26))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-471)/2, (screenSize.height-500)/2, 471, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void b_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_FecharActionPerformed
        // TODO add your handling code here:
        Main.setMenu(true);
        dispose();
        Main.gerarJanelaListarCadastrados();
        
    }//GEN-LAST:event_b_FecharActionPerformed

    private void cb_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CategoriaActionPerformed
        // TODO add your handling code here:
        if(cb_Categoria.getSelectedItem() != "Aluno"){
            cb_Curso.setVisible(false);
            d_Curso.setVisible(false);
            d_Matricula.setText("SIAPE:");
        }else{
            cb_Curso.setVisible(true);
            d_Curso.setVisible(true);
            d_Matricula.setText("Matrícula:");
        }
    }//GEN-LAST:event_cb_CategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Fechar;
    private javax.swing.JTextField c_Bairro;
    private javax.swing.JTextField c_CEP;
    private javax.swing.JTextField c_Cidade;
    private javax.swing.JTextField c_Complemento;
    private javax.swing.JTextField c_Email;
    private javax.swing.JTextField c_Endereco;
    private javax.swing.JTextField c_Matricula;
    private javax.swing.JTextField c_Nome;
    private javax.swing.JTextField c_NumeroCasa;
    private javax.swing.JTextField c_Telefone;
    private javax.swing.JComboBox cb_Categoria;
    private javax.swing.JComboBox cb_Curso;
    private javax.swing.JComboBox cb_Estado;
    private javax.swing.JLabel d_Bairro;
    private javax.swing.JLabel d_CEP;
    private javax.swing.JLabel d_Categoria1;
    private javax.swing.JLabel d_Cidade;
    private javax.swing.JLabel d_Complemento;
    private javax.swing.JLabel d_Curso;
    private javax.swing.JLabel d_Email;
    private javax.swing.JLabel d_Endereco;
    private javax.swing.JLabel d_Estado;
    private javax.swing.JLabel d_Matricula;
    private javax.swing.JLabel d_Nome;
    private javax.swing.JLabel d_NumeroCasa;
    private javax.swing.JLabel d_Telefone;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l_Titulo;
    private javax.swing.JPanel p_DadosAcademicos;
    private javax.swing.JPanel p_DadosPessoais;
    private javax.swing.JPanel p_Foto;
    // End of variables declaration//GEN-END:variables
    private Cadastro c;
    private JImagePanel imgPanel;
    private scb.Logger logger;

    private void setJImagePanel(InputStream dirCad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}