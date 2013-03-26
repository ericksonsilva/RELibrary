package scb.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import scb.Cadastro;
import scb.Emprestimo;
import scb.Livro;
import scb.Logger;
import scb.Usuario;

public class SCBPersistenciaSQL implements SCBPersistencia{

	Connection conexao;
        Logger logger;

	public SCBPersistenciaSQL() {
            logger = Logger.getInstance();
        try {
            conexao = ConnectionFactory.getConnection();
        } catch (ConnectionFactoryException ex) {
                logger.log(ex);
        }

	}

	public void salvarCadastro(Cadastro c) throws SCBPersistenciaException {
		String sql = "INSERT into CADASTROS ("
                        + "NOME, "
                        + "ENDERECO, "
                        + "N, "
                        + "COMPLEMENTO, "
                        + "BAIRRO, "
                        + "CIDADE, "
                        + "ESTADO, "
                        + "CEP, "
                        + "TELEFONE, "
                        + "EMAIL, "
                        + "MATRICULA, "
                        + "CURSO, "
                        + "CATEGORIA) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
             
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getEndereco());
			pstm.setString(3, c.getNumero());
			pstm.setString(4, c.getComplemento());
			pstm.setString(5, c.getBairro());
			pstm.setString(6, c.getCidade());
			pstm.setString(7, c.getEstado());
			pstm.setString(8, c.getCep());
			pstm.setString(9, c.getTelefone());
			pstm.setString(10, c.getEmail());
                        pstm.setString(11, c.getMatricula());
			pstm.setString(12, c.getCurso());
			pstm.setString(13, c.getCategoria());		
			pstm.executeUpdate();
			pstm.close();
                        
		} catch (SQLException e) {
                        logger.log(e);
			throw new SCBPersistenciaException(e.getMessage());
		}
	}

	public List<Cadastro> getTodosCadastros() throws SCBPersistenciaException {
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		String sql = "SELECT * from CADASTROS";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cadastro c = new Cadastro();
				c.setNome(rs.getString("NOME"));
				c.setEndereco(rs.getString("ENDERECO"));
				c.setNumero(rs.getString("N"));
				c.setComplemento(rs.getString("COMPLEMENTO"));
				c.setBairro(rs.getString("BAIRRO"));
				c.setCidade(rs.getString("CIDADE"));
				c.setEstado(rs.getString("ESTADO"));
				c.setCep(rs.getString("CEP"));
				c.setTelefone(rs.getString("TELEFONE"));
				c.setEmail(rs.getString("EMAIL"));
				c.setMatricula(rs.getString("MATRICULA"));
				c.setCurso(rs.getString("CURSO"));
				c.setCategoria(rs.getString("CATEGORIA"));
                                c.setId(rs.getString("ID"));
				cadastros.add(c);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());

		}
		return cadastros;

	}

	public void excluirCadastro(String info) throws SCBPersistenciaException {
		String sql = "DELETE from CADASTROS where ID=?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, info);    
			pstm.executeUpdate();
    			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}
	}

	public List<Cadastro> getCadastro(String info)	throws SCBPersistenciaException {
       List<Cadastro> cadastros = new ArrayList<Cadastro>();
        String sql = "SELECT * from CADASTROS where MATRICULA like '" + info + "' or NOME like '" + info +"'";
        try{
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Cadastro c = new Cadastro();
                c.setNome(rs.getString("NOME"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("N"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                c.setBairro(rs.getString("BAIRRO"));
                c.setCidade(rs.getString("CIDADE"));
                c.setEstado(rs.getString("ESTADO"));
                c.setCep(rs.getString("CEP"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                c.setMatricula(rs.getString("MATRICULA"));
                c.setCurso(rs.getString("CURSO"));
                c.setCategoria(rs.getString("CATEGORIA"));
                c.setId(rs.getString("ID"));
                cadastros.add(c);
            }
           rs.close();
           pstm.close();
        } catch (SQLException ex) {
            logger.log(ex);                    
            throw new SCBPersistenciaException(ex.getMessage());
        }
       return cadastros;  
   
    }
   
	public void editarCadastro(Cadastro c) throws SCBPersistenciaException {
		String sql = "UPDATE CADASTROS set "
                        + "NOME = ?, "
                        + "ENDERECO = ?, "
                        + "N = ?, "
                        + "COMPLEMENTO = ?, "
                        + "BAIRRO = ?, "
                        + "CIDADE = ?, "
                        + "ESTADO = ?, "
                        + "CEP = ?, "
                        + "TELEFONE = ?, "
                        + "EMAIL = ?, "
                        + "CURSO = ?, "
                        + "CATEGORIA = ?, "
                        + "MATRICULA = ?"
                        + "where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getEndereco());
			pstm.setString(3, c.getNumero());
			pstm.setString(4, c.getComplemento());
			pstm.setString(5, c.getBairro());
			pstm.setString(6, c.getCidade());
			pstm.setString(7, c.getEstado());
			pstm.setString(8, c.getCep());
			pstm.setString(9, c.getTelefone());
			pstm.setString(10, c.getEmail());
			pstm.setString(11, c.getCurso());
			pstm.setString(12, c.getCategoria());
			pstm.setString(13, c.getMatricula());
                        pstm.setInt(14, Integer.parseInt(c.getId()));
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}

	}

	public void salvarLivro(Livro l) throws SCBPersistenciaException {
		String sql = "INSERT into LIVROS ("
                        + "TITULO, "
                        + "AUTOR, "
                        + "EDICAO, "
                        + "ANO, "
                        + "EDITORA, "
                        + "INF, "
                        + "REGISTRO, "
                        + "DATA, "
                        + "BIBLIOTECA) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql); 
			pstm.setString(1, l.getTitulo());
			pstm.setString(2, l.getAutor());
			pstm.setString(3, l.getEdicao());
			pstm.setString(4, l.getAno());
			pstm.setString(5, l.getEditora());
			pstm.setString(6, l.getInf());	
                        pstm.setString(7, l.getRegistro());
			pstm.setString(8, l.getSimpleDate());
			pstm.setString(9, l.getBiblioteca());
			                        
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}
	}

	public List<Livro> getTodosLivros() throws SCBPersistenciaException {
		String sql = "SELECT * from LIVROS";
		List<Livro> livros = new ArrayList<Livro>();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Livro l = new Livro();
				l.setTitulo(rs.getString("TITULO"));
				l.setAutor(rs.getString("AUTOR"));
				l.setEdicao(rs.getString("EDICAO"));
				l.setAno(rs.getString("ANO"));
				l.setEditora(rs.getString("EDITORA"));
				l.setInf(rs.getString("INF"));
				l.setRegistro(rs.getString("REGISTRO"));
                                try {
                                    l.setSimpleDate(rs.getString("DATA"));
                                } catch (ParseException ex) {
                                    throw new SCBPersistenciaException(ex.getMessage());
                                }
				l.setBiblioteca(rs.getString("BIBLIOTECA"));
                                l.setId(rs.getString("ID"));
				livros.add(l);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
                }

		return livros;
	}

	public void excluirLivro(String info) throws SCBPersistenciaException {
		String sql = "DELETE from LIVROS where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, info);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}
	}

	public List<Livro> getLivro(String info) throws SCBPersistenciaException {
        String sql = "SELECT * from LIVROS where REGISTRO like '" + info + "' or TITULO like '" + info +"'";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Livro> livros = new ArrayList<Livro>();
			while (rs.next()) {
				Livro l = new Livro();
				l.setTitulo(rs.getString("TITULO"));
				l.setAutor(rs.getString("AUTOR"));
				l.setEdicao(rs.getString("EDICAO"));
				l.setAno(rs.getString("ANO"));
				l.setEditora(rs.getString("EDITORA"));
				l.setInf(rs.getString("INF"));
				l.setRegistro(rs.getString("REGISTRO"));
                                try {
                                    l.setSimpleDate(rs.getString("DATA"));
                                } catch (ParseException ex) {
                                    throw new SCBPersistenciaException(ex.getMessage());
                                }
				l.setBiblioteca(rs.getString("BIBLIOTECA"));
                                l.setId(rs.getString("ID"));
				livros.add(l);
			}
			rs.close();
			pstm.close();
			return livros;
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}

	}

	public void editarLivro(Livro l) throws SCBPersistenciaException {
		String sql = "UPDATE LIVROS set "
                        + "TITULO = ?, "
                        + "AUTOR = ?, "
                        + "EDICAO = ?, "
                        + "ANO = ?, "
                        + "EDITORA = ?, "
                        + "INF = ?, "
                        + "DATA = ?, "
                        + "BIBLIOTECA = ?, "
                        + "REGISTRO = ? "
                        + "where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, l.getTitulo());
			pstm.setString(2, l.getAutor());
			pstm.setString(3, l.getEdicao());
			pstm.setString(4, l.getAno());
			pstm.setString(5, l.getEditora());
			pstm.setString(6, l.getInf());			
			pstm.setString(7, l.getSimpleDate());
			pstm.setString(8, l.getBiblioteca());
			pstm.setString(9, l.getRegistro());
                        pstm.setInt(10, Integer.parseInt(l.getId()));
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}

	}
        
        public void salvarEmprestimo(Emprestimo e) throws SCBPersistenciaException {

                String sql = "INSERT into EMPRESTIMOS ("
                        + "MATRICULACADASTRO, "
                        + "NOMECADASTRO, "
                        + "CATEGORIACADASTRO, "
                        + "REGISTROLIVRO, "
                        + "TITULOLIVRO, "
                        + "AUTORLIVRO, "
                        + "DATAEMPRESTIMO, "
                        + "DATADEVOLUCAO, "
                        + "ENTREGA, "
                        + "USUARIORESPONSAVEL) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
                PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, e.getMatriculaCadastro());
                        pstm.setString(2, e.getNomeCadastro());
                        pstm.setString(3, e.getCategoriaCadastro());
			pstm.setString(4, e.getRegistroLivro());
                        pstm.setString(5, e.getTituloLivro());
                        pstm.setString(6, e.getAutorLivro());                       
			pstm.setString(7, e.getSimpleDateEmprestimo());
			pstm.setString(8, e.getSimpleDateDevolucao());
			pstm.setBoolean(9, e.getEntrega());
                        pstm.setString(10, e.getUsuarioResponsavel());                
                pstm.executeUpdate();
                pstm.close();
        } catch (SQLException ex) {
            logger.log(ex);                    
            throw new SCBPersistenciaException(ex.getMessage());

        }

	}
        
        public List<Emprestimo> getTodosEmprestimos() throws SCBPersistenciaException {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "SELECT * from EMPRESTIMOS";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Emprestimo e = new Emprestimo();
                                e.setId(rs.getString("ID"));
				e.setMatriculaCadastro(rs.getString("MATRICULACADASTRO"));
                                e.setNomeCadastro(rs.getString("NOMECADASTRO"));
                                e.setCategoriaCadastro(rs.getString("CATEGORIACADASTRO"));
                                e.setRegistroLivro(rs.getString("REGISTROLIVRO"));
                                e.setTituloLivro(rs.getString("TITULOLIVRO"));
                                e.setAutorLivro(rs.getString("AUTORLIVRO"));
                                try{
                                    e.setSimpleDataSaida(rs.getString("DATAEMPRESTIMO"));
                                    e.setSimpleDataRetorno(rs.getString("DATADEVOLUCAO"));
                                }catch(ParseException ex){
                                    throw new SCBPersistenciaException(ex.getMessage());
                                }
				e.setEntrega(rs.getBoolean("ENTREGA"));
                                e.setUsuarioResponsavel(rs.getString("USUARIORESPONSAVEL"));
				emprestimos.add(e);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());

		}
		return emprestimos;

	}

    public List<Emprestimo> getEmprestimo(String info) throws SCBPersistenciaException {
            List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        String sql = "SELECT * from EMPRESTIMOS where MATRICULACADASTRO like '" + info + "' OR ID like '" + info +"'" ;
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			/*pstm.setString(1, info);
                        pstm.setInt(2, info2);*/
                        ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Emprestimo e = new Emprestimo();
                                e.setId(rs.getString("ID"));
				e.setMatriculaCadastro(rs.getString("MATRICULACADASTRO"));
                                e.setNomeCadastro(rs.getString("NOMECADASTRO"));
                                e.setCategoriaCadastro(rs.getString("CATEGORIACADASTRO"));
                                e.setRegistroLivro(rs.getString("REGISTROLIVRO"));
                                e.setTituloLivro(rs.getString("TITULOLIVRO"));
                                e.setAutorLivro(rs.getString("AUTORLIVRO"));
                                try{
                                    e.setSimpleDataSaida(rs.getString("DATAEMPRESTIMO"));
                                    e.setSimpleDataRetorno(rs.getString("DATADEVOLUCAO"));
                                }catch(ParseException ex){
                                    throw new SCBPersistenciaException(ex.getMessage());
                                }
				e.setEntrega(rs.getBoolean("ENTREGA"));
                                e.setUsuarioResponsavel(rs.getString("USUARIORESPONSAVEL"));                               
				emprestimos.add(e);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());

		}
		return emprestimos;

	}

    public void excluirEmprestimo(String info) throws SCBPersistenciaException {
		String sql = "DELETE from EMPRESTIMOS where ID=?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, info);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}
	}

    public void editarEmprestimo(Emprestimo e) throws SCBPersistenciaException {
		String sql = "UPDATE EMPRESTIMOS set "
                        + "MATRICULACADASTRO = ?, "
                        + "NOMECADASTRO = ?, "
                        + "CATEGORIACADASTRO = ?, "
                        + "REGISTROLIVRO = ?, "
                        + "TITULOLIVRO = ?, "
                        + "AUTORLIVRO = ?, "
                        + "DATAEMPRESTIMO = ?, "
                        + "DATADEVOLUCAO = ?, "
                        + "ENTREGA = ?, "
                        + "USUARIORESPONSAVEL = ? "
                        + "where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, e.getMatriculaCadastro());
                        pstm.setString(2, e.getNomeCadastro());
                        pstm.setString(3, e.getCategoriaCadastro());
			pstm.setString(4, e.getRegistroLivro());
                        pstm.setString(5, e.getTituloLivro());
                        pstm.setString(6, e.getAutorLivro());                       
			pstm.setString(7, e.getSimpleDateEmprestimo());
			pstm.setString(8, e.getSimpleDateDevolucao());
			pstm.setBoolean(9, e.getEntrega());
                        pstm.setString(10, e.getUsuarioResponsavel());
                        pstm.setInt(11, Integer.parseInt(e.getId()));
                        pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}

	}
    
        public void salvarUsuario(Usuario u) throws SCBPersistenciaException {

                String sql = "INSERT into USUARIOS ("
                        + "NOME, "
                        + "EMAIL, "
                        + "TELEFONE, "
                        + "TURNO, "
                        + "USUARIO, "
                        + "SENHA) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
                PreparedStatement pstm = conexao.prepareStatement(sql);
                pstm.setString(1, u.getNome());
                pstm.setString(2, u.getEmail());
                pstm.setString(3, u.getTelefone());
                pstm.setString(4, u.getTurno());
                pstm.setString(5, u.getUsuario());
                pstm.setString(6, u.getSenha());                
                pstm.executeUpdate();
                pstm.close();
        } catch (SQLException ex) {
            logger.log(ex);                    
            throw new SCBPersistenciaException(ex.getMessage());

        }

	}
        public List<Usuario> getTodosUsuarios() throws SCBPersistenciaException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * from USUARIOS";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("NOME"));
                                u.setEmail(rs.getString("EMAIL"));
                                u.setTelefone(rs.getString("TELEFONE"));
                                u.setTurno(rs.getString("TURNO"));
                                u.setUsuario(rs.getString("USUARIO"));
                                u.setSenha(rs.getString("SENHA"));
                                u.setId(rs.getString("ID"));
   				usuarios.add(u);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());

		}
		return usuarios;

	}

    public List<Usuario> getUsuario(String info) throws SCBPersistenciaException {
            List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * from USUARIOS where NOME like '" + info + "' or USUARIO like '" + info +"'";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("NOME"));
                                u.setEmail(rs.getString("EMAIL"));
                                u.setTelefone(rs.getString("TELEFONE"));
                                u.setTurno(rs.getString("TURNO"));
                                u.setUsuario(rs.getString("USUARIO"));
                                u.setSenha(rs.getString("SENHA"));
                                u.setId(rs.getString("ID"));
   				usuarios.add(u);
			}
			rs.close();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());

		}
		return usuarios;

	}

    public void excluirUsuario(String info) throws SCBPersistenciaException {
		String sql = "DELETE from USUARIOS where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, info);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}
	}

    public void editarUsuario(Usuario u) throws SCBPersistenciaException {
		String sql = "UPDATE USUARIOS set "
                        + "NOME = ?, "
                        + "EMAIL = ?, "
                        + "TELEFONE = ?, "
                        + "TURNO = ?, "
                        + "USUARIO = ?, "
                        + "SENHA = ? "
                        + "where ID = ?";
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, u.getNome());
                        pstm.setString(2, u.getEmail());
                        pstm.setString(3, u.getTelefone());
                        pstm.setString(4, u.getTurno());
			pstm.setString(5, u.getUsuario());
                        pstm.setString(6, u.getSenha());
                        pstm.setInt(7, Integer.parseInt(u.getId()));
                        pstm.executeUpdate();
			pstm.close();
		} catch (SQLException ex) {
                        logger.log(ex);                    
			throw new SCBPersistenciaException(ex.getMessage());
		}

	}
               

}
