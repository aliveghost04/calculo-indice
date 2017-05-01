package edu.itla.calculoindice.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private Connection conexion;
	private Statement enunciado;
	private ResultSet resultado;
	private static Conexion instancia;
	
	public static Conexion getInstancia() {
		
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}
	
	private Conexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/calculador_indice?user=root&password=");
			enunciado = conexion.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet hacerConsulta(String consulta) {
		
		try {
			resultado = enunciado.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void hacerCambio(String consulta) {
		try {
			enunciado.execute(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
