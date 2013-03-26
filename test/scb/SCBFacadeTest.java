/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rivaldo Júnior
 */
public class SCBFacadeTest {
    
    public SCBFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    @Test
    public void testSalvarCadastro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Cadastro c = new Cadastro();
        c.setMatricula("81111188");
        try{
            facade.salvarCadastro(c);
        }catch(SCBFacadeException e){
            assertEquals(e.getMessage(), "Matricula já cadastrada no sistema.");
            
        }
        c.setMatricula("82222288");
        try{
            facade.salvarCadastro(c);
            List<Cadastro> cadastros = new ArrayList<Cadastro>();
            cadastros = facade.getCadastro("82222288");
            assertEquals("82222288" , cadastros.get(0).getMatricula());
        }catch(SCBFacadeException e){            
            fail("O teste falhou!");
        }
        facade.excluirCadastro("82222288");
    }

    @Test
    public void testGetCadastro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        Cadastro c = new Cadastro();
        facade.salvarCadastro(c);
        c.setMatricula("81111188");
        cadastros = facade.getCadastro("81111188");
        assertEquals("81111188",cadastros.get(0).getMatricula());
        
        cadastros = facade.getCadastro("999999999");
        assertTrue(cadastros.isEmpty());   
        
    }


    @Test
    public void testExcluirCadastro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Cadastro c = new Cadastro();
        c.setMatricula("66666666");
        facade.salvarCadastro(c);
        
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        cadastros = facade.getCadastro("66666666");
        
        assertEquals("66666666",cadastros.get(0).getMatricula());
        facade.excluirCadastro("66666666");
        cadastros = facade.getCadastro("66666666");
        assertTrue(cadastros.isEmpty());  
        
    }

    @Test
    public void testEditarCadastro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Cadastro c = new Cadastro();
        c.setMatricula("11111111");
        c.setBairro("Centro");
        facade.salvarCadastro(c);
        
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        cadastros = facade.getCadastro("11111111");
        
        assertEquals("Centro",cadastros.get(0).getBairro());
        c.setBairro("Bairro");
        facade.editarCadastro(c);
        cadastros = facade.getCadastro("11111111");
        facade.excluirCadastro("11111111");
        assertEquals("Bairro",cadastros.get(0).getBairro());  
    }

    @Test
    public void testSalvarLivro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Livro l = new Livro();
        l.setRegistro("1234");
        try{
            facade.salvarLivro(l);          
        }catch(SCBFacadeException e){
              fail("O teste falhou!");
        }
        facade.excluirLivro("1234");
    }

    @Test
    public void testGetLivro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        List<Livro> livros = new ArrayList<Livro>();
        Livro l = new Livro();
        l.setRegistro("12345");
        facade.salvarLivro(l);
        livros = facade.getLivro("12345");
        assertEquals("12345",livros.get(0).getRegistro());
        
        livros = facade.getLivro("999999999");
        assertTrue(livros.isEmpty());
        facade.excluirLivro("12345");
    }

    
    @Test
    public void testExcluirLivro() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        List<Livro> livros = new ArrayList<Livro>();
        Livro l = new Livro();
        l.setRegistro("12345");
        facade.salvarLivro(l);
         livros = facade.getLivro("12345");
        assertFalse(livros.isEmpty());
        facade.excluirLivro("12345");
        livros = facade.getLivro("12345");
        assertTrue(livros.isEmpty());
    }

    
    @Test
    public void testSalvarEmprestimo() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setMatriculaCadastro("81111188");
        emprestimo.setEntrega(false);
        emprestimo.setDataDevolucao(new Date());
        
        try{
            facade.salvarEmprestimo(emprestimo);
        }catch(SCBFacadeException e){
            fail("O teste falhou!");
        }
        
    }


    @Test
    public void testSalvarUsuario() throws Exception {
        SCBFacade facade = SCBFacade.getInstance();
        Usuario usuario = new Usuario();
        usuario.setNome("emo");
        usuario.setUsuario("emo");
        
        try{
            facade.salvarUsuario(usuario);
        }catch(SCBFacadeException e){
            fail("O teste falhou!");
        }
        facade.excluirUsuario("emo");
    }

    @Test
    public void testGetUsuario() throws Exception {
        
        SCBFacade facade = SCBFacade.getInstance();
        Usuario usuario = new Usuario();
        usuario.setNome("emo");
        usuario.setUsuario("emo");
        facade.salvarUsuario(usuario);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = facade.getUsuario("emo");
        assertEquals("emo",usuarios.get(0).getNome());
        facade.excluirUsuario("emo");
        usuarios = facade.getUsuario("emo");
        assertTrue(usuarios.isEmpty());
       
    }
    
}
