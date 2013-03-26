/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Erickson
 */
public class Emprestimo {

    private String matriculaCadastro;
    private String nomeCadastro;
    private String categoriaCadastro;
    private String registroLivro;
    private String tituloLivro;
    private String autorLivro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean entrega;
    private String usuarioResponsavel;
    private String id;



    public Emprestimo(){
            this.dataEmprestimo = new Date();
    }
    
    public String getSimpleDateEmprestimo() {
        return Util.dateToString(this.dataEmprestimo);
    }

    public String getSimpleDateDevolucao() {
        return Util.dateToString(this.dataDevolucao);
    }

    public String getMatriculaCadastro() {
        return matriculaCadastro;
    }
    
    public void setSimpleDataSaida(String date) throws ParseException{
        this.setDataEmprestimo(Util.stringToDate(date));
    }

    public void setSimpleDataRetorno(String date) throws ParseException{
        this.dataDevolucao = Util.stringToDate(date);
    }

    public void setMatriculaCadastro(String matriculaCadastro) {
        this.matriculaCadastro = matriculaCadastro;
    }

    public String getNomeCadastro() {
        return nomeCadastro;
    }

    public void setNomeCadastro(String nomeCadastro) {
        this.nomeCadastro = nomeCadastro;
    }

    public String getCategoriaCadastro() {
        return categoriaCadastro;
    }

    public void setCategoriaCadastro(String categoriaCadastro) {
        this.categoriaCadastro = categoriaCadastro;
    }

    public String getRegistroLivro() {
        return registroLivro;
    }

    public void setRegistroLivro(String registroLivro) {
        this.registroLivro = registroLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }
    
    public boolean getEntrega(){
        return entrega;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }
    
    
        
    public float getMulta(float juros) {
        if(this.entrega){
            return 0;
        }
        Date data = new Date();
        long dias = (data.getTime() - this.dataDevolucao.getTime()) / (1000 * 60 * 60 * 24);
        if(dias <= 0){
            return 0; 
        }
        return (float) (juros * dias);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    int compareTo(Emprestimo e2) {
        return this.getId().compareTo(e2.getId());
    }
    
    
		
}