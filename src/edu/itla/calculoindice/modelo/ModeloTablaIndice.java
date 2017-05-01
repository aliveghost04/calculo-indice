package edu.itla.calculoindice.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.itla.calculoindice.bd.Conexion;

public class ModeloTablaIndice extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	ResultSet rs;
	ArrayList<Indice> indices = new ArrayList<>();
	String[] columnasTabla = {"Semestral", "Acumulado"};
	
	
	public ModeloTablaIndice(String matricula) {
		
		try {
			rs = Conexion.getInstancia().hacerConsulta("SELECT matricula, indice_semestral, indice_acumulado "
					+ "FROM historico_calificaciones WHERE matricula = '"+matricula+"'");
			while (rs.next()) {
				indices.add(new Indice(rs.getString(1), rs.getFloat(2), rs.getFloat(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int getColumnCount() {
		return columnasTabla.length;
	}


	public int getRowCount() {
		return indices.size();
	}


	public Object getValueAt(int fila, int columna) {
		
		Indice indice = indices.get(fila);
		
		switch (columna) {
		case 0: 
			return indice.getIndiceSemestral();
		case 1: 
			return indice.getIndiceAcumulado();
		default:
			return null;
		}
	}
	
	public String getColumnName(int columna) {
		return columnasTabla[columna];
	}
	
	
}
