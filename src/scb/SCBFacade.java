/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scb.io.SCBPersistenciaException;
import scb.io.SCBPersistenciaSQL;

/**
 *
 * @author Erickson
 */
public class SCBFacade {
    
    private static SCBFacade facade = new SCBFacade();
    private SCBPersistenciaSQL  persistencia;
    Util util;
    
    private SCBFacade(){
        persistencia = new SCBPersistenciaSQL();
        util = new Util();
    }
    
    public static SCBFacade getInstance(){
        return facade;
    }
    
    public void salvarCadastro(Cadastro c) throws SCBFacadeException{
        try{    
           util.verificarCadastro(c);
           persistencia.salvarCadastro(c);            
        }catch (SCBPersistenciaException ex){
            throw new SCBFacadeException("Falha na gravação, tente novamente.");
        }
    }
    
    public List<Cadastro> getCadastro(String info) throws SCBFacadeException{
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        try {
            cadastros = persistencia.getCadastro(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
        return cadastros;
    }
    
    public List<Cadastro> getTodosCadastros() throws SCBFacadeException{
       List<Cadastro> cadastros = new ArrayList<Cadastro>();
        try {
            cadastros = persistencia.getTodosCadastros();
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
       return cadastros;
   
    }
    
    public void excluirCadastro(String info) throws SCBFacadeException{
        try {
            persistencia.excluirCadastro(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha exclusão de dados, tente novamente.");
        }
    }
    
    public void editarCadastro(Cadastro c) throws SCBFacadeException{
        try {
            persistencia.editarCadastro(c);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na edição de dados, tente novamente.");

        }
    }
    
    
    public void salvarLivro(Livro l) throws SCBFacadeException{
        try{
            util.verificarLivro(l);
           persistencia.salvarLivro(l);
        }catch (SCBPersistenciaException ex){
            throw new SCBFacadeException("Falha na gravação, tente novamente.");        
        }
    }
        
    public List<Livro> getLivro(String info) throws SCBFacadeException{
        List<Livro> livros = new ArrayList<Livro>();
        try {
            livros = persistencia.getLivro(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
        return livros;
    }
    
    public List<Livro> getTodosLivros() throws SCBFacadeException{
       List<Livro> livros = new ArrayList<Livro>();
        try {
            livros = persistencia.getTodosLivros();
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
       return livros;
   
    }
    
    public void excluirLivro(String info) throws SCBFacadeException{
        try {
            persistencia.excluirLivro(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na exclusão de dados, tente novamente.");
        }
    }
    
    public void editarLivro(Livro l) throws SCBFacadeException{
        try {
            persistencia.editarLivro(l);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na edição de dados, tente novamente.");

        }
    }
    
    public void salvarEmprestimo(Emprestimo e) throws SCBFacadeException{
        try{
            util.verificarEmprestimo(e);
            persistencia.salvarEmprestimo(e);
        } catch (SCBPersistenciaException ex){
              throw new SCBFacadeException("Falha na gravação, tente novamente.");
        }
    }
    
    public List<Emprestimo> getEmprestimo(String info) throws SCBFacadeException{
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        try {
            emprestimos = persistencia.getEmprestimo(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
        return emprestimos;
    }
    
    public List<Emprestimo> getTodosEmprestimos() throws SCBFacadeException{
       List<Emprestimo> emprestimos;
        try {
            emprestimos = persistencia.getTodosEmprestimos();
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
       return emprestimos;
    }
    
    public void excluirEmprestimo(String info) throws SCBFacadeException{
        try {
            persistencia.excluirEmprestimo(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha exclusão de dados, tente novamente.");
        }
    }
    
    public void editarEmprestimo(Emprestimo e) throws SCBFacadeException{
        try {
            persistencia.editarEmprestimo(e);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na edição de dados, tente novamente.");

        }
    }    
    
        public void salvarUsuario(Usuario u) throws SCBFacadeException{
        try{    
            util.verificarUsuario(u);
            persistencia.salvarUsuario(u);
            
        }catch (SCBPersistenciaException ex){
            throw new SCBFacadeException("Falha na gravação, tente novamente.");
        }
    }
    
    public List<Usuario> getUsuario(String info) throws SCBFacadeException{
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            usuarios = persistencia.getUsuario(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
        return usuarios;
    }
    
    public List<Usuario> getTodosUsuarios() throws SCBFacadeException{
       List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            usuarios = persistencia.getTodosUsuarios();
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na recuperação de dados, tente novamente.");
        }
       return usuarios;
   
    }
    
    public void excluirUsuario(String info) throws SCBFacadeException{
        try {
            persistencia.excluirUsuario(info);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha exclusão de dados, tente novamente.");
        }
    }
    
    public void editarUsuario(Usuario u) throws SCBFacadeException{
        try {
            persistencia.editarUsuario(u);
        } catch (SCBPersistenciaException ex) {
            throw new SCBFacadeException("Falha na edição de dados, tente novamente.");

        }
    }
   
       
}
