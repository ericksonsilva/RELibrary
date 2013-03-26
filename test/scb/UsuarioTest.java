/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rivaldo Júnior
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNome() {
        Usuario instance = new Usuario();
        String expResult = "Nome";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testGetEmail() {
        Usuario instance = new Usuario();
        String expResult = "email@hotmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTelefone() {
         Usuario instance = new Usuario();
        String expResult = "88712218";
        instance.setTelefone(expResult);
        String result = instance.getTelefone();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTurno() {
         Usuario instance = new Usuario();
        String expResult = "Integral";
        instance.setTurno(expResult);
        String result = instance.getTurno();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetUsuario() {
         Usuario instance = new Usuario();
        String expResult = "Usuario";
        instance.setUsuario(expResult);
        String result = instance.getUsuario();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSenha() {
         Usuario instance = new Usuario();
        String expResult = "senha123";
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }
}
