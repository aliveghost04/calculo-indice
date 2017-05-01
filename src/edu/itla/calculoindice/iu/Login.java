package edu.itla.calculoindice.iu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.itla.calculoindice.bd.Conexion;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pfContraseña;
	private String usuario;
	private String contraseña;
	private String usuarioBD;
	private String contraseñaBD;
	private ResultSet rs;
	private int idCargo;
	private JLabel lblLoginFallido;

	public Login() {
		
		setTitle("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(26, 64, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(26, 101, 60, 14);
		contentPane.add(lblContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(109, 61, 129, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(109, 98, 129, 20);
		contentPane.add(pfContraseña);
		pfContraseña.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					new AccionBtnIniciarSesion().actionPerformed(null);
				}
			}
		});
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreadorUsuario().setVisible(true);
				dispose();
			}
		});
		btnCrearUsuario.setBounds(10, 201, 100, 23);
		contentPane.add(btnCrearUsuario);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBounds(220, 201, 100, 23);
		contentPane.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(new AccionBtnIniciarSesion());
		
		lblLoginFallido = new JLabel("*Usuario y/o Contrase\u00F1a incorrectos");
		lblLoginFallido.setForeground(Color.RED);
		lblLoginFallido.setBounds(55, 158, 183, 14);
		lblLoginFallido.setVisible(false);
		contentPane.add(lblLoginFallido);
	}
	
	private class AccionBtnIniciarSesion implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			usuario = txtUsuario.getText();
			contraseña = String.valueOf(pfContraseña.getPassword());
			
			try {
				rs = Conexion.getInstancia().hacerConsulta("SELECT usuario, contraseña, id_cargo FROM usuarios WHERE usuario = '"+usuario+"'");
				if (rs.next()) {
					usuarioBD = rs.getString(1);
					contraseñaBD = rs.getString(2);
					idCargo = rs.getInt(3);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if (usuario.equalsIgnoreCase(usuarioBD) && contraseña.equals(contraseñaBD)) {
				InterfazUsuario iu = new InterfazUsuario(usuario);
				switch (idCargo) {
				case (1):
					iu.asignarAdministrador();
					iu.setVisible(true);
				break;
				case (2):
					iu.setVisible(true);
				break;
				}
				dispose();
			} else {
				lblLoginFallido.setVisible(true);
			}
		}
		
	}
}
