package br.edu.ifba.agenda.tableModel;

import javax.swing.table.DefaultTableModel;

import br.edu.ifbfa.agenda.basicas.Categoria;

public class CategoriaTableModel extends DefaultTableModel {
	private String []columnNames = {"Id", "Nome"};
	private Class<?> []columnClass = {Integer.class, String.class};
	
	public void addCategoria(Categoria c) {
		Object linha[] = new Object[2];
		linha[0] = c.getId();
		linha[1] = c.getNome();
		System.out.println(c.getNome());
		addRow(linha);
	}
	
	public boolean isCellEditable(int a, int b){
		return false;
	} 
	
	public void removeAllElements() {
		while(getRowCount() > 0) {
			removeRow(getRowCount() -1);
		}
	}
	public String getColumnName(int i) {
		return columnNames[i];
	}
	
	public Class getColumnClass(int i) {
		return columnClass[i];
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	

	
}