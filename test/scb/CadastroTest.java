/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rivaldo Júnior
 */
public class CadastroTest {

    Cadastro instance = new Cadastro();
    public CadastroTest() {   
    }
   
    @Test
    public void testSetNome() {
        String nome = "Nome da pessoa";
        boolean result = instance.setNome(nome);
        assertTrue(result);
    }
    
    @Test
    public void testSetMatricula() {
        String matricula = "81111188";
        boolean result = instance.setMatricula(matricula);
        assertTrue(result);
    }

    @Test
    public void testSetCurso() {
        String curso = "SI";
        boolean result = instance.setCurso(curso);
        assertTrue(result);
    }

    @Test
    public void testSetCategoria() {
        String categoria = "Aluno";
        boolean result = instance.setCategoria(categoria);
        assertTrue(result);
    }

    
    @Test
    public void testSetTelefone() {
        String telefone = "88712218";
        boolean result = instance.setTelefone(telefone);
        assertTrue(result);
    }

    @Test
    public void testSetEmail() {
        String email = "rivaldo@hotmail.com";
        boolean result = instance.setEmail(email);
        assertTrue(result);
    }

    @Test
    public void testSetCidade() {
        String cidade = "Cidade";
        boolean result = instance.setCidade(cidade);
        assertTrue(result);
    }

    
    @Test
    public void testSetBairro() {
        String bairro = "Bairro";
        boolean result = instance.setBairro(bairro);
        assertTrue(result);
    }

    
    @Test
    public void testSetEndereco() {
        String endereco = "Endereco";
        boolean result = instance.setEndereco(endereco);
        assertTrue(result);
    }

    
    @Test
    public void testSetNumero() {
        String numero = "999";
        boolean result = instance.setNumero(numero);
        assertTrue(result);
    }

    
    @Test
    public void testSetComplemento() {
        String complemento = "complemento";
        boolean result = instance.setComplemento(complemento);
        assertTrue(result);
    }

    
    @Test
    public void testSetEstado() {
        String estado = "Estado";
        boolean result = instance.setEstado(estado);
        assertTrue(result);
    }

    @Test
    public void testSetCep() {
        String cep = "58295-000";
        boolean result = instance.setCep(cep);
        assertTrue(result);
    }  

    @Test
    public void testGetNome() {
        String expResult = "Nome da pessoa";
        instance.setNome(expResult);
        assertEquals(expResult,instance.getNome());
    }

    @Test
    public void testGetEndereco() {
        String expResult = "Endereco";
        instance.setEndereco("Endereco");
        String result = instance.getEndereco();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetNumero() {
        String expResult = "999";
        instance.setNumero("999");
        String result = instance.getNumero();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetComplemento() {
        String expResult = "complemento";
        instance.setComplemento("complemento");
        String result = instance.getComplemento();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetBairro() {
        String expResult = "Bairro";
        instance.setBairro("Bairro");
        String result = instance.getBairro();
        assertEquals(expResult, result);
    }

  
    @Test
    public void testGetCidade() {
        String expResult = "cidade";
        instance.setCidade("cidade");
        String result = instance.getCidade();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEstado() {
        String expResult = "estado";
        instance.setEstado("estado");
        String result = instance.getEstado();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCep() {
        String expResult = "00000-000";
        instance.setCep("00000-000");
        String result = instance.getCep();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetTelefone() {
        String expResult = "88712218";
        instance.setTelefone("88712218");
        String result = instance.getTelefone();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        String expResult = "email@hotmail.com";
        instance.setEmail("email@hotmail.com");
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetMatricula() {
        String expResult = "81111188";
        instance.setMatricula("81111188");
        String result = instance.getMatricula();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetCurso() {
        String expResult = "SI";
        instance.setCurso("SI");
        String result = instance.getCurso();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCategoria() {
        String expResult = "categoria";
        instance.setCategoria("categoria");
        String result = instance.getCategoria();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetId() {
        String expResult = "id";
        instance.setId("id");
        String result = instance.getId();
        assertEquals(expResult, result);
    }
   
}
