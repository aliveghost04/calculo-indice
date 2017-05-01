package edu.itla.calculoindice.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.itla.calculoindice.bd.Conexion;

public class ModeloTablaUsuarios extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnasTabla = {"Matricula", "Nombre", "Apellido", "Usuario", "Estado"};
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ModeloTablaUsuarios instancia;
	private ResultSet rs;
	
	public static ModeloTablaUsuarios getInstancia() {
		
		if (instancia == null) {
			instancia = new ModeloTablaUsuarios();
		}
		return instancia;
	}
	
	public void eliminarUsuario(int fila) {
		usuarios.remove(fila);
		fireTableDataChanged();
	}
	
	private ModeloTablaUsuarios() {
		
		try {
			rs = Conexion.getInstancia().hacerConsulta("SELECT matricula, nombre, apellido, usuario, contraseña, nombre_cargo FROM usuarios JOIN cargos USING (id_cargo)");
			while (rs.next()) {
				usuarios.add(new Usuario(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getMatricula(int fila) {
		return usuarios.get(fila).getMatricula();
	}
	
	public String[] getValores(int fila) {
		String[] valores = new String[6];
		
		valores[0] = usuarios.get(fila).getMatricula();
		valores[1] = usuarios.get(fila).getNombre();
		valores[2] = usuarios.get(fila).getApellido();
		valores[3] = usuarios.get(fila).getUsuario();
		valores[4] = usuarios.get(fila).getContraseña();
		valores[5] = usuarios.get(fila).getCargo();
		
		return valores;
	}
	
	public int getColumnCount() {
		return columnasTabla.length;
	}

	public int getRowCount() {
		return usuarios.size();
	}

	public Object getValueAt(int fila, int columna) {
		
		Usuario usuario = usuarios.get(fila);
		
		switch (columna){
		case 0:
			return usuario.getMatricula();
		case 1:
			return usuario.getNombre();
		case 2: 
			return usuario.getApellido();
		case 3:
			return usuario.getUsuario();
		case 4:
			return usuario.getCargo();
		default: 
			return null;
		}
	}
	
	public String getColumnName(int columna) {
		return columnasTabla[columna];
	}
}
