/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.io;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erickson
 */
public class ConnectionFactory {
    private static final int BUFFER = 1 * 1024 * 1024;

   
    private static Connection connection;
    private static ConnectionFactory singleton = new ConnectionFactory();
    
   private ConnectionFactory(){
   }
   
   public static ConnectionFactory getInstance(){
       return singleton;
   }
    
    public static Connection getConnection() throws ConnectionFactoryException{ 
        if(connection != null){
            return connection;
        }
        else{
            
            try {             
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + DATABASE.getPath();
            connection = DriverManager.getConnection(url);
            return connection;
            
       }  catch (ClassNotFoundException e) {
            throw new ConnectionFactoryException("Driver não encontrado. Contate o suporte técnico.");
        } catch (SQLException e) {
            throw new ConnectionFactoryException("Não foi possível conectar ao Banco de Dados.");
        }  
        }
    }
   
            
     

    
    private static final File DATABASE = new File(
        System.getProperty("user.dir")
        + "/src/scb/data/database/DB.db");
    
     public static void checkDatabase() {
        if (!DATABASE.exists()) {
             try {
                 createNewDatabase();
             } catch (     ConnectionFactoryException | IOException | SQLException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     }
     
      public static void createNewDatabase() throws ConnectionFactoryException, IOException, SQLException {
        try {
            DATABASE.getParentFile().mkdirs(); //Cria os diretórios pai do arquivo (caso não existam)
            DATABASE.createNewFile();// Cria o arquivo do banco
            if (!DATABASE.exists()) { //Caso o arquivo ainda não exista, após os comandos acima, dispara exceção
                throw new IOException("Erro ao gravar o arquivo de banco de dados.");

            }
            
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE IF NOT EXISTS CADASTROS ("
                    + "ID INTEGER PRIMARY KEY, "
                    + "NOME TEXT, "
                    + "ENDERECO TEXT, "
                    + "N TEXT, "
                    + "COMPLEMENTO TEXT , "
                    + "BAIRRO TEXT ,"
                    + "CIDADE TEXT , "
                    + "ESTADO TEXT , "
                    + "CEP TEXT , "
                    + "TELEFONE TEXT , "
                    + "EMAIL TEXT , "
                    + "MATRICULA TEXT , "
                    + "CURSO TEXT , "
                    + "CATEGORIA TEXT "
                    + ")");
            s.execute("CREATE TABLE IF NOT EXISTS LIVROS ("
                    + "ID INTEGER PRIMARY KEY, "
                    + "TITULO TEXT, "
                    + "AUTOR TEXT, "
                    + "EDICAO TEXT, "
                    + "ANO TEXT , "
                    + "EDITORA TEXT ,"
                    + "INF TEXT , "
                    + "REGISTRO TEXT , "
                    + "DATA TEXT , "
                    + "BIBLIOTECA TEXT "
                    + ")");
            
            s.execute("CREATE TABLE IF NOT EXISTS EMPRESTIMOS ("
                    + "ID INTEGER PRIMARY KEY, "
                    + "MATRICULACADASTRO TEXT, "
                    + "NOMECADASTRO TEXT, "
                    + "CATEGORIACADASTRO TEXT, "
                    + "REGISTROLIVRO TEXT , "
                    + "TITULOLIVRO TEXT , "
                    + "AUTORLIVRO TEXT , "
                    + "DATAEMPRESTIMO TEXT, "
                    + "DATADEVOLUCAO TEXT, "
                    + "ENTREGA TEXT, "
                    + "USUARIORESPONSAVEL TEXT "
                    + ")");
            
            s.execute("CREATE TABLE IF NOT EXISTS USUARIOS ("
                    + "ID INTEGER PRIMARY KEY, "
                    + "NOME TEXT, "
                    + "EMAIL TEXT, "
                    + "TELEFONE TEXT, "
                    + "TURNO TEXT, "
                    + "USUARIO TEXT, "
                    + "SENHA TEXT "
                    + ")"); 
            
            s.executeUpdate("INSERT into USUARIOS (NOME, EMAIL, TELEFONE, TURNO, USUARIO, SENHA) VALUES ('Administrador', 'biblioteca@dce.ufpb.br', '0000-0000', 'Integral', 'admin', 'admin');");
            
            
            
        } catch (ConnectionFactoryException ex) {
            throw new ConnectionFactoryException("Erro na criação do banco de dados." + ex.getMessage());
        }

    }
       public static void removeDataBase() throws ConnectionFactoryException {
            DATABASE.delete();
       }
       
  
}