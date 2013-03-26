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
import scb.ui.Main;

/**
 *
 * @author Erickson
 */
public class EmprestimoTableModel extends AbstractTableModel{
    
    private static final int ID = 0;
    private static final int MATRICULA = 1;
    private static final int REGISTRO = 2;
    private String[] colunas = new String[] { "ID", "Matrícula", "Registro" };
    
    private List<Emprestimo> linhas;
    
    public EmprestimoTableModel() {
		linhas = new ArrayList<Emprestimo>();
    }
    
    public EmprestimoTableModel(List<Emprestimo> listaDeEmprestimos) {
		linhas = new ArrayList<Emprestimo>(listaDeEmprestimos);
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
            case ID:
                    return String.class;                
            case MATRICULA:
                    return String.class;
            case REGISTRO:
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
            Emprestimo c = linhas.get(rowIndex);

            switch (columnIndex) {
            case ID:
                    return c.getId();                
            case MATRICULA:
                    return c.getMatriculaCadastro();
            case REGISTRO:
                    return c.getRegistroLivro();
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
    }    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Emprestimo e = linhas.get(rowIndex);

            switch (columnIndex) {
            case ID:
                    e.setId((String) aValue);
                    break;                
            case MATRICULA:
                    e.setMatriculaCadastro((String) aValue);
                    break;
            case REGISTRO:
                    e.setRegistroLivro((String) aValue);
                    break;
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }

            fireTableCellUpdated(rowIndex, columnIndex);
    }    
    
    public void setValueAt(Emprestimo aValue, int rowIndex) {  
        Emprestimo e = linhas.get(rowIndex); 
  
        e.setId(aValue.getId());  
        e.setMatriculaCadastro(aValue.getMatriculaCadastro());  
        e.setRegistroLivro(aValue.getRegistroLivro());
        e.setNomeCadastro(aValue.getNomeCadastro());
        e.setCategoriaCadastro(aValue.getCategoriaCadastro());
        e.setTituloLivro(aValue.getTituloLivro());
        e.setAutorLivro(aValue.getAutorLivro());
        e.setDataEmprestimo(aValue.getDataEmprestimo());
        e.setDataDevolucao(aValue.getDataDevolucao());
        e.setUsuarioResponsavel(aValue.getUsuarioResponsavel());          
        
        fireTableCellUpdated(rowIndex, 0);  
        fireTableCellUpdated(rowIndex, 1);  
  
    }  
    
    	public Emprestimo getEmprestimo(int indiceLinha) {
		return linhas.get(indiceLinha);
                
	}
	public void addEmprestimo(Emprestimo emprestimo) {
		linhas.add(emprestimo);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}    
        
	public void removeEmprestimo(int indiceLinha) {
		linhas.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}        
	public void addListaDeEmprestimos(List<Emprestimo> emprestimos) {
                limpar();
		int indice = getRowCount();
                Collections.sort( emprestimos , new Comparator(){
                    public int compare(Object o1, Object o2){
                        Emprestimo e1 = (Emprestimo) o1;
                        Emprestimo e2 = (Emprestimo) o2;
                        return e1.compareTo(e2);
                        }
                        }
                        );
                
                
		linhas.addAll(emprestimos);

		fireTableRowsInserted(indice, indice + emprestimos.size());
	} 
	public void limpar() {
		linhas.clear();

		fireTableDataChanged();
	}
        

}
