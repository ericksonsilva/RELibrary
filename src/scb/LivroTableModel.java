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
public class LivroTableModel extends AbstractTableModel{
    
    
    private static final int REGISTRO = 0;
    private static final int TITULO = 1;
    private String[] colunas = new String[] { "Registro", "Título" };
    
    private List<Livro> linhas;
    
    public LivroTableModel() {
		linhas = new ArrayList<Livro>();
    }
    
    public LivroTableModel(List<Livro> listaDeLivros) {
		linhas = new ArrayList<Livro>(listaDeLivros);
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
            case REGISTRO:
                    return String.class;
            case TITULO:
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
            Livro l = linhas.get(rowIndex);

            switch (columnIndex) {
            case REGISTRO:
                    return l.getRegistro();
            case TITULO:
                    return l.getTitulo();
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
    }    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Livro l = linhas.get(rowIndex);

            switch (columnIndex) {
            case REGISTRO:
                    l.setRegistro((String) aValue);
                    break;
            case TITULO:
                    l.setTitulo((String) aValue);
                    break;
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }

            fireTableCellUpdated(rowIndex, columnIndex);
    }    
    
    public void setValueAt(Livro aValue, int rowIndex) {  
        Livro l = linhas.get(rowIndex); 
  
        l.setRegistro(aValue.getRegistro());  
        l.setTitulo(aValue.getTitulo());  
        l.setAutor(aValue.getAutor());
        l.setEdicao(aValue.getEdicao());
        l.setAno(aValue.getAno());
        l.setEditora(aValue.getEditora());
        l.setInf(aValue.getInf());
        l.setData(aValue.getData());
        l.setBiblioteca(aValue.getBiblioteca());        
  
        fireTableCellUpdated(rowIndex, 0);  
        fireTableCellUpdated(rowIndex, 1);  
  
    }  
    
    	public Livro getLivro(int indiceLinha) {
		return linhas.get(indiceLinha);
                
	}
	public void addLivro(Livro livro) {
		linhas.add(livro);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}    
        
	public void removeLivro(int indiceLinha) {
		linhas.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}        
	public void addListaDeLivros(List<Livro> livros) {
                limpar();
		int indice = getRowCount();
                Collections.sort( livros , new Comparator(){
                    public int compare(Object o1, Object o2){
                        Livro l1 = (Livro) o1;
                        Livro l2 = (Livro) o2;
                        return l1.compareTo(l2);
                        }
                        }
                        );
                
		linhas.addAll(livros);

		fireTableRowsInserted(indice, indice + livros.size());
	} 
	public void limpar() {
		linhas.clear();

		fireTableDataChanged();
	}
        

}
