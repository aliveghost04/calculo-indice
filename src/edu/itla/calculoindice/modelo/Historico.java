package edu.itla.calculoindice.modelo;

public class Historico {

	private int calificacion;
	private String nombre;
	private String codigoMateria;
	private String literal;

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public Historico(String codigoMateria, String nombre, int calificacion, String literal) {
		this.calificacion = calificacion;
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		this.literal = literal;
	}

}
