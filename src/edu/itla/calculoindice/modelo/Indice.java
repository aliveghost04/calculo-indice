package edu.itla.calculoindice.modelo;

public class Indice {
	private String matricula;
	private float indiceSemestral;
	private float indiceAcumulado;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public float getIndiceSemestral() {
		return indiceSemestral;
	}

	public void setIndiceSemestral(float indiceSemestral) {
		this.indiceSemestral = indiceSemestral;
	}

	public float getIndiceAcumulado() {
		return indiceAcumulado;
	}

	public void setIndiceAcumulado(float indiceAcumulado) {
		this.indiceAcumulado = indiceAcumulado;
	}

	public Indice(String matricula, float indiceSemestral, float indiceAcumulado) {
		this.matricula = matricula;
		this.indiceSemestral = indiceSemestral;
		this.indiceAcumulado = indiceAcumulado;
	}

}
