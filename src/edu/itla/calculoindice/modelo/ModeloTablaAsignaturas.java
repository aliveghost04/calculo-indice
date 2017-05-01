package edu.itla.calculoindice.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.itla.calculoindice.bd.Conexion;

public class ModeloTablaAsignaturas extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnasTabla = {"Codigo Asignatura", "Asignatura", "Creditos"};
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	private static ModeloTablaAsignaturas instancia;
	private ResultSet rs;
	
	public static ModeloTablaAsignaturas getInstancia() {
		
		if (instancia == null) {
			instancia = new ModeloTablaAsignaturas();
		}
		return instancia;
	}
	
	private ModeloTablaAsignaturas() {
		
		try {
			rs = Conexion.getInstancia().hacerConsulta("SELECT codigo_asignatura, nombre, creditos FROM asignaturas");
			while (rs.next()) {
				asignaturas.add(new Asignatura(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarAsignatura(int fila) {
		asignaturas.remove(fila);
		fireTableDataChanged();
	}
	
	public String getCodigoAsignatura(int fila) {
		return asignaturas.get(fila).getCodigoAsignatura();
	}
	
	public String getColumnName(int columna) {
		return columnasTabla[columna];
	}
	
	public int getColumnCount() {
		return columnasTabla.length;
	}

	public int getRowCount() {
		return asignaturas.size();
	}

	public Object getValueAt(int fila, int columna) {
		
		Asignatura asignatura = asignaturas.get(fila);
		
		switch (columna) {
		case 0:
			return asignatura.getCodigoAsignatura();
		case 1:
			return asignatura.getNombreAsignatura();
		case 2:
			return asignatura.getCreditos();
		default:
			return null;
		}
	}
	
}
