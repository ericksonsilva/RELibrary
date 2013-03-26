/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rivaldo Júnior
 */
public class LivroTest {
    
    public LivroTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetSimpleDate() {
        Livro instance = new Livro();
        Date date = new Date();
        Util.dateToString(date);
        instance.setData(date);
        assertEquals(Util.dateToString(date), instance.getSimpleDate());
    }

    @Test
    public void testGetTitulo() {
        Livro instance = new Livro();
        String expResult = "Livro";
        boolean validar = instance.setTitulo(expResult);
        String result = instance.getTitulo();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAutor() {
        Livro instance = new Livro();
        String expResult = "Alguém";
        boolean validar = instance.setAutor(expResult);
        String result = instance.getAutor();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEdicao() {
        Livro instance = new Livro();
        String expResult = "Edição";
        boolean validar = instance.setEdicao(expResult);
        String result = instance.getEdicao();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAno() {
        Livro instance = new Livro();
        String expResult = "2013";
        boolean validar = instance.setAno(expResult);
        String result = instance.getAno();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEditora() {
        Livro instance = new Livro();
        String expResult = "Editora";
        boolean validar = instance.setEditora(expResult);
        String result = instance.getEditora();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetInf() {
        Livro instance = new Livro();
        String expResult = "Informação do livro";
        boolean validar = instance.setInf(expResult);
        String result = instance.getInf();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRegistro() {
        Livro instance = new Livro();
        String expResult = "123456";
        boolean validar = instance.setRegistro(expResult);
        String result = instance.getRegistro();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBiblioteca() {
        Livro instance = new Livro();
        String expResult = "CCAE";
        boolean validar = instance.setBiblioteca(expResult);
        String result = instance.getBiblioteca();
        assertTrue(validar);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetData() {
        Livro instance = new Livro();
        Date date = new Date();
        instance.setData(date);
        assertEquals(date, instance.getData());
    }
}
