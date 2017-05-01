package edu.itla.calculoindice.modelo;

public class Usuario {

	private String matricula;
	private String nombre;
	private String apellido;
	private String usuario;
	private String cargo;
	private String contrase�a;
	
	public Usuario(String matricula, String nombre, String apellido,
			String usuario, String contrase�a, String cargo) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.cargo = cargo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
