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
public class CadastroTableModel extends AbstractTableModel{
    
    
    private static final int MATRICULA = 0;
    private static final int NOME = 1;
    private String[] colunas = new String[] { "Matrícula", "Nome" };
    
    private List<Cadastro> linhas;
    
    public CadastroTableModel() {
		linhas = new ArrayList<Cadastro>();
    }
    
    public CadastroTableModel(List<Cadastro> listaDeCadastros) {
		linhas = new ArrayList<Cadastro>(listaDeCadastros);
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
            case MATRICULA:
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
            Cadastro c = linhas.get(rowIndex);

            switch (columnIndex) {
            case MATRICULA:
                    return c.getMatricula();
            case NOME:
                    return c.getNome();
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
    }    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Cadastro c = linhas.get(rowIndex);

            switch (columnIndex) {
            case MATRICULA:
                    c.setMatricula((String) aValue);
                    break;
            case NOME:
                    c.setNome((String) aValue);
                    break;
            default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }

            fireTableCellUpdated(rowIndex, columnIndex);
    }    
    
    public void setValueAt(Cadastro aValue, int rowIndex) {  
        Cadastro c = linhas.get(rowIndex); 
        c.setMatricula(aValue.getMatricula());  
        c.setNome(aValue.getNome());  
        c.setEndereco(aValue.getEndereco());
        c.setNumero(aValue.getNumero());
        c.setComplemento(aValue.getComplemento());
        c.setBairro(aValue.getBairro());
        c.setCidade(aValue.getCidade());
        c.setEstado(aValue.getEstado());
        c.setCep(aValue.getCep());
        c.setTelefone(aValue.getTelefone());
        c.setEmail(aValue.getEmail());
        c.setCurso(aValue.getCurso());
        c.setCategoria(aValue.getCategoria());
  
        fireTableCellUpdated(rowIndex, 0);  
        fireTableCellUpdated(rowIndex, 1);  
  
    }  
    
    	public Cadastro getCadastro(int indiceLinha) {
		return linhas.get(indiceLinha);
                
	}
	public void addCadastro(Cadastro cadastro) {
		linhas.add(cadastro);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}    
        
	public void removeCadastro(int indiceLinha) {
		linhas.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}        
	public void addListaDeCadastros(List<Cadastro> cadastros) {
                limpar();
		int indice = getRowCount();
                Collections.sort( cadastros , new Comparator(){
                    public int compare(Object o1, Object o2){
                        Cadastro c1 = (Cadastro) o1;
                        Cadastro c2 = (Cadastro) o2;
                        return c1.compareTo(c2);
                        }
                        }
                        );

		linhas.addAll(cadastros);

		fireTableRowsInserted(indice, indice + cadastros.size());
	} 
	public void limpar() {
		linhas.clear();

		fireTableDataChanged();
	}
        

}
