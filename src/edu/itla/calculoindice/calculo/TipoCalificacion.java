package edu.itla.calculoindice.calculo;

public class TipoCalificacion {
	
	private static TipoCalificacion instancia;
	
	public static TipoCalificacion getInstancia() {
		if (instancia == null) {
			instancia = new TipoCalificacion();
		} 
		return instancia;
	}
	
	private TipoCalificacion() {
		
	}
	
	public String getValorLiteral(int nota) {
		
		if (nota >= 70 && nota < 80 ) {
			return "C";
		} 
		if (nota >= 0 && nota < 70) {
			return "F";
		}
		if (nota >= 80 && nota < 90) {
			return "B";
		}
		if (nota >= 90 && nota <= 100) {
			return "A";
		}
		return "-1";
	}
}
