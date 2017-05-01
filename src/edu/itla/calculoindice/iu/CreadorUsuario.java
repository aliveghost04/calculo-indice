package edu.itla.calculoindice.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreadorUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMatricula;
	private JTextField txtUsuario;
	private JPasswordField pfContraseña;

	public CreadorUsuario() {
		
		setTitle("Crear de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 52, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 98, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 144, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(10, 187, 56, 14);
		contentPane.add(lblContraseña);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 119, 56, 14);
		contentPane.add(lblMatricula);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(75, 49, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(75, 95, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(75, 116, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(75, 141, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(76, 184, 86, 20);
		contentPane.add(pfContraseña);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(124, 227, 121, 23);
		contentPane.add(btnCrearUsuario);
		btnCrearUsuario.addActionListener(new AccionBtnCrearUsuario());
		
		JLabel lblCrearUsuario = new JLabel("Crear Usuario");
		lblCrearUsuario.setBounds(146, 11, 66, 14);
		contentPane.add(lblCrearUsuario);
	}
	
	private class AccionBtnCrearUsuario implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}

}
