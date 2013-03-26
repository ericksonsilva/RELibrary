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
public class EmprestimoTest {
    
    public EmprestimoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetSimpleDateEmprestimo() {
        Emprestimo instance = new Emprestimo();
        Date date = new Date();
        Util.dateToString(date);
        instance.setDataEmprestimo(date);
        assertEquals(Util.dateToString(date), Util.dateToString(instance.getDataEmprestimo()));
    }

    @Test
    public void testGetSimpleDateDevolucao() {
        Emprestimo instance = new Emprestimo();
        Date date = new Date();
        Util.dateToString(date);
        instance.setDataDevolucao(date);
        assertEquals(Util.dateToString(date), Util.dateToString(instance.getDataDevolucao()));
    }

    @Test
    public void testGetMatriculaCadastro() {
        Emprestimo instance = new Emprestimo();
        String expResult = "81111188";
        instance.setMatriculaCadastro(expResult);
        String result = instance.getMatriculaCadastro();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetNomeCadastro() {
        Emprestimo instance = new Emprestimo();
        String expResult = "Rivaldo";
        instance.setNomeCadastro(expResult);
        String result = instance.getNomeCadastro();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetCategoriaCadastro() {
        Emprestimo instance = new Emprestimo();
        String expResult = "Aluno";
        instance.setCategoriaCadastro(expResult);
        String result = instance.getCategoriaCadastro();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetTituloLivro() {
        Emprestimo instance = new Emprestimo();
        String expResult = "POO";
        instance.setTituloLivro(expResult);
        String result = instance.getTituloLivro();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetAutorLivro() {
        Emprestimo instance = new Emprestimo();
        String expResult = "Rodrigo";
        instance.setAutorLivro(expResult);
        String result = instance.getAutorLivro();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetDataEmprestimo() {
        Emprestimo instance = new Emprestimo();
        Date date = new Date();
        instance.setDataEmprestimo(date);
        assertEquals(date, instance.getDataEmprestimo());
    }

   

    @Test
    public void testGetDataDevolucao() {
        Emprestimo instance = new Emprestimo();
        Date date = new Date();
        instance.setDataDevolucao(date);
        assertEquals(date, instance.getDataDevolucao());
    }


    @Test
    public void testIsEntrega() {
        Emprestimo instance = new Emprestimo();
        assertFalse(instance.isEntrega());
    }

   
    @Test
    public void testGetUsuarioResponsavel() {
        Emprestimo instance = new Emprestimo();
        String expResult = "Alguém";
        instance.setUsuarioResponsavel(expResult);
        String result = instance.getUsuarioResponsavel();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetMulta() {
        float juros = 2.0F;
        Emprestimo instance = new Emprestimo();
        float expResult = 0.0F;
        instance.setDataDevolucao(new Date());
        float result = instance.getMulta(juros);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetId() {
        Emprestimo instance = new Emprestimo();
        String expResult = "123";
        instance.setId(expResult);
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    
}
