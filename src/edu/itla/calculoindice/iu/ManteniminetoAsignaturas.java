package edu.itla.calculoindice.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import edu.itla.calculoindice.modelo.ModeloTablaAsignaturas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManteniminetoAsignaturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAsignaturas;
	
	public ManteniminetoAsignaturas() {
		
		setTitle("Mantenimiento de Asignaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblAsignaturas = new JTable(ModeloTablaAsignaturas.getInstancia());
		
		JScrollPane scrollPane = new JScrollPane(tblAsignaturas);
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejadorAsignaturas ma = new ManejadorAsignaturas();
				ma.setTitle("Agregar Asignatura");
				ma.lblTitulo.setText("Agregar Asignatura");
				ma.setVisible(true);
			}
		});
		btnAgregar.setBounds(10, 280, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(170, 280, 89, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejadorAsignaturas ma = new ManejadorAsignaturas();
				ma.setTitle("Modificar Asignatura");
				ma.lblTitulo.setText("Modificar Asignatura");
				ma.setVisible(true);
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(335, 280, 89, 23);
		contentPane.add(btnEliminar);
	}

}
