package edu.itla.calculoindice.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import edu.itla.calculoindice.bd.Conexion;
import edu.itla.calculoindice.calculo.TipoCalificacion;

public class ModeloTablaHistorico extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] columnasTabla = {"Codigo", "Asignatura", "Calificación", "Literal"};
	private ArrayList<Historico> asignaturas = new ArrayList<Historico>();
	private ResultSet rs;
	private Object[] fila = new Object[columnasTabla.length];
	private TipoCalificacion literal = TipoCalificacion.getInstancia();
	
	public ModeloTablaHistorico(String usuario) {
		
		try {
			rs = Conexion.getInstancia().hacerConsulta("SELECT a.codigo_asignatura, a.nombre, c.calificacion FROM asignaturas a "
					+ "JOIN calificaciones c USING (codigo_asignatura) JOIN usuarios USING (matricula) WHERE usuario = '"+ usuario +"'");
			while (rs.next()) {
				asignaturas.add(new Historico(rs.getString(1), rs.getString(2), rs.getInt(3), literal.getValorLiteral(rs.getInt(3))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cargarTabla();
	}
	
	public void cargarTabla() {
		
		for (int x = 0; x < columnasTabla.length; x++) {
			addColumn(columnasTabla[x]);
		}
		
		for (int x = 0; x < asignaturas.size(); x++) {
			
			Historico asignatura = asignaturas.get(x);
			
			fila[0] = asignatura.getCodigoMateria();
			fila[1] = asignatura.getNombre();
			fila[2] = asignatura.getCalificacion();
			fila[3] = asignatura.getLiteral();
			addRow(fila);
		}
	}
}
