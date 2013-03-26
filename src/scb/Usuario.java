/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

/**
 *
 * @author Erickson
 */
public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String turno;
    private String usuario;
    private String senha;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    int compareTo(Usuario u2) {
        return this.getNome().compareTo(u2.getNome());
    }  
    
    
}    