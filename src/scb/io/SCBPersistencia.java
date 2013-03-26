package scb.io;

import java.util.List;
import scb.Cadastro;
import scb.Emprestimo;
import scb.Livro;
import scb.Usuario;

public interface SCBPersistencia {

	public void salvarCadastro(Cadastro c) throws SCBPersistenciaException;
	public List<Cadastro> getTodosCadastros() throws SCBPersistenciaException;
	public List<Cadastro> getCadastro(String info) throws SCBPersistenciaException;
	public void excluirCadastro(String matricula) throws SCBPersistenciaException;
	public void editarCadastro(Cadastro c) throws SCBPersistenciaException;
	public void salvarLivro(Livro l) throws SCBPersistenciaException;
	public List<Livro> getTodosLivros() throws SCBPersistenciaException;
	public List<Livro> getLivro(String info) throws SCBPersistenciaException;
	public void excluirLivro(String registro) throws SCBPersistenciaException;
	public void editarLivro(Livro l) throws SCBPersistenciaException;
        public void salvarEmprestimo(Emprestimo e) throws SCBPersistenciaException;
        public List<Emprestimo> getTodosEmprestimos() throws SCBPersistenciaException;
	public List<Emprestimo> getEmprestimo(String info) throws SCBPersistenciaException;
        public void excluirEmprestimo(String info) throws SCBPersistenciaException;
        public void editarEmprestimo(Emprestimo e) throws SCBPersistenciaException;
        public void salvarUsuario(Usuario u) throws SCBPersistenciaException;
        public List<Usuario> getTodosUsuarios() throws SCBPersistenciaException;
	public List<Usuario> getUsuario(String info) throws SCBPersistenciaException;
        public void excluirUsuario(String info) throws SCBPersistenciaException;
        public void editarUsuario(Usuario u) throws SCBPersistenciaException;        
}
