package edu.itla.calculoindice.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import edu.itla.calculoindice.bd.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManejadorUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtUsuario;
	public JPasswordField pfContraseña;
	public JComboBox<String> cbCargo;
	public JLabel lblTitulo;
	private JButton btnGuardar;
	String idUsuario;
	
	public ManejadorUsuario(String usuario) {
		
		this.idUsuario = usuario;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel();
		lblTitulo.setBounds(144, 11, 92, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 46, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 92, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 133, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(10, 172, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 208, 46, 14);
		contentPane.add(lblEstado);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 43, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 89, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 130, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(80, 169, 86, 20);
		contentPane.add(pfContraseña);
		
		String[] cargo = {"Seleccione", "Administrador", "Estudiante"};
		cbCargo = new JComboBox<String>(new DefaultComboBoxModel<String>(cargo));
		cbCargo.setBounds(79, 205, 87, 20);
		contentPane.add(cbCargo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbCargo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(ManejadorUsuario.this, "Seleccione un cargo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if (lblTitulo.getText().equals("Modificador Usuario")) {
					Conexion.getInstancia().hacerCambio("UPDATE usuarios SET nombre = '"+txtNombre.getText()+"', apellido = '"+txtApellido.getText()+"', "
							+ " usuario = '"+ txtUsuario.getText()+"', contraseña = '"+ new String(pfContraseña.getPassword())+"', id_cargo = " 
							+ cbCargo.getSelectedIndex() + " WHERE usuario = '"+idUsuario+"'");
					JOptionPane.showMessageDialog(ManejadorUsuario.this, "Usuario Modificado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
				if (lblTitulo.getText().equals("Agregador Usuario")) {
					Conexion.getInstancia().hacerCambio("INSERT INTO usuarios VALUES(null, '"+txtNombre.getText()+"', '"+txtApellido.getText()+"', "
							+ " '"+ txtUsuario.getText()+"', '"+ new String(pfContraseña.getPassword())+"', " 
							+ cbCargo.getSelectedIndex() + ", null)");
					JOptionPane.showMessageDialog(ManejadorUsuario.this, "Usuario Agregado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(201, 227, 89, 23);
		contentPane.add(btnGuardar);
	}
}
