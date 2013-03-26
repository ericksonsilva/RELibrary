/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Erickson
 */
public class Livro {
    private String titulo;
    private String autor;
    private String edicao;
    private String ano;
    private String editora;
    private String inf;
    private String registro;
    private String biblioteca;
    private Date data;
    private String id;
    
    
    
    public Livro(){
        this.data = new Date();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    	public String getSimpleDate() {
            return Util.dateToString(this.data);
	}

        public void setSimpleDate(String date) throws ParseException{
            this.setData(Util.stringToDate(date));
	}
      
    int compareTo(Livro l2) {
        return this.getTitulo().compareTo(l2.getTitulo());
    }    

	
    
        

	
}
