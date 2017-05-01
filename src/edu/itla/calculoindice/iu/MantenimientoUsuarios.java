package edu.itla.calculoindice.iu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.itla.calculoindice.bd.Conexion;
import edu.itla.calculoindice.modelo.ModeloTablaUsuarios;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MantenimientoUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsuarios;

	public MantenimientoUsuarios() {
		
		setTitle("Mantenimiento de Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblUsuarios = new JTable(ModeloTablaUsuarios.getInstancia());
		
		JScrollPane scrollPane = new JScrollPane(tblUsuarios);
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ManejadorUsuario mu = new ManejadorUsuario("0");
				mu.setTitle("Agregador Usuario");
				mu.lblTitulo.setText("Agregador Usuario");
				mu.setVisible(true);
			}
			
		});
		btnAgregar.setBounds(10, 261, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] valores = ModeloTablaUsuarios.getInstancia().getValores(tblUsuarios.getSelectedRow());
				ManejadorUsuario mu = new ManejadorUsuario(valores[3]);
				mu.setTitle("Modificador Usuario");
				mu.lblTitulo.setText("Modificador Usuario");
				mu.txtNombre.setText(valores[1]);
				mu.txtApellido.setText(valores[2]);
				mu.txtUsuario.setText(valores[3]);
				mu.pfContraseña.setText(valores[4]);
				mu.cbCargo.setSelectedItem(valores[5]);
				mu.setVisible(true);
			}
		});
		btnModificar.setBounds(173, 261, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(MantenimientoUsuarios.this, 
						"¿Desea eliminar el usuario seleccionado?",	"Infomación", JOptionPane.YES_NO_OPTION);
				switch (resultado) {
				case (JOptionPane.YES_OPTION):
					int fila = tblUsuarios.getSelectedRow();
					ModeloTablaUsuarios.getInstancia().eliminarUsuario(fila);
					
					try {
						int matricula = Integer.parseInt(ModeloTablaUsuarios.getInstancia().getMatricula(fila));
						Conexion.getInstancia().hacerCambio("DELETE FROM usuarios WHERE matricula = " + matricula);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				break;
				}
			}
		});
		btnEliminar.setBounds(335, 261, 89, 23);
		contentPane.add(btnEliminar);
		
	}
}
