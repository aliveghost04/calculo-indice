package edu.itla.calculoindice.iu;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ManejadorAsignaturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	public JLabel lblTitulo;

	public ManejadorAsignaturas() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel();
		lblTitulo.setBounds(144, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 60, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 104, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCreditos = new JLabel("Creditos:");
		lblCreditos.setBounds(10, 152, 46, 14);
		contentPane.add(lblCreditos);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(67, 57, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(67, 101, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		String[] creditos = {"Seleccione", "1", "2", "3", "4", "5", "6"};
		JComboBox<String> cbCreditos = new JComboBox<String>(new DefaultComboBoxModel<String>(creditos));
		cbCreditos.setBounds(66, 149, 87, 20);
		contentPane.add(cbCreditos);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(156, 211, 89, 23);
		contentPane.add(btnGuardar);
	}

}
