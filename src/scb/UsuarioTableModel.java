/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Erickson
 */
public class UsuarioTableModel extends AbstractTableModel{
    
    private static final int USUARIO = 0;
    private static final int NOME = 1;
    private String[] colunas = new String[] { "Usuário", "Nome" };
    
    private List<Usuario> linhas;
    
    public UsuarioTableModel() {
		linhas = new ArrayList<Usuario>();
    }
    
    public UsuarioTableModel(List<Usuario> listaDeUsuarios) {
		linhas = new ArrayList<Usuario>(listaDeUsuarios);
    }
     
    @Override    
    public int getRowCount() {
		return linhas.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
            return colunas[columnIndex];
    };
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case USUARIO:
                    return String.class;
            case NOME:
                    return String.class;
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
    }    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario u = linhas.get(rowIndex);

            switch (columnIndex) {
            case USUARIO:
                    return u.getUsuario();
            case NOME:
                    return u.getNome();
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
    }    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Usuario u = linhas.get(rowIndex);

            switch (columnIndex) {
            case USUARIO:
                    u.setUsuario((String) aValue);
                    break;
            case NOME:
                    u.setNome((String) aValue);
                    break;
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }

            fireTableCellUpdated(rowIndex, columnIndex);
    }    
    
    public void setValueAt(Usuario aValue, int rowIndex) {  
        Usuario u = linhas.get(rowIndex); 
  
        u.setUsuario(aValue.getUsuario());  
        u.setNome(aValue.getNome());  
        u.setEmail(aValue.getEmail());
        u.setTelefone(aValue.getTelefone());
        u.setTurno(aValue.getTurno());
        u.setSenha(aValue.getSenha());        

        fireTableCellUpdated(rowIndex, 0);  
        fireTableCellUpdated(rowIndex, 1);  
  
    }  
    
    	public Usuario getUsuario(int indiceLinha) {
		return linhas.get(indiceLinha);
                
	}
	public void addUsuario(Usuario usuario) {
		linhas.add(usuario);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}    
        
	public void removeUsuario(int indiceLinha) {
		linhas.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}        
	public void addListaDeUsuarios(List<Usuario> usuarios) {
                limpar();
		int indice = getRowCount();
                Collections.sort( usuarios , new Comparator(){
                    public int compare(Object o1, Object o2){
                        Usuario u1 = (Usuario) o1;
                        Usuario u2 = (Usuario) o2;
                        return u1.compareTo(u2);
                        }
                        }
                        );
                
		linhas.addAll(usuarios);

		fireTableRowsInserted(indice, indice + usuarios.size());
	} 
	public void limpar() {
		linhas.clear();

		fireTableDataChanged();
	}
        

}
