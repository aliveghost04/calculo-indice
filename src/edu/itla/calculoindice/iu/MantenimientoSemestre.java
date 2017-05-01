package edu.itla.calculoindice.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.itla.calculoindice.modelo.ModeloTablaAsignaturas;
import edu.itla.calculoindice.modelo.ModeloTablaUsuarios;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MantenimientoSemestre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAsignaturas;
	private JTable tblUsuarios;
	private JButton btnAadir;

	public MantenimientoSemestre() {
		
		setTitle("Mantenimiento de Semestre");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblAsignaturas = new JTable(ModeloTablaAsignaturas.getInstancia());
		tblUsuarios = new JTable(ModeloTablaUsuarios.getInstancia());
		
		JScrollPane scrollPane = new JScrollPane(tblAsignaturas);
		scrollPane.setBounds(10, 11, 300, 239);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(tblUsuarios);
		scrollPane_1.setBounds(341, 11, 334, 239);
		contentPane.add(scrollPane_1);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoAsignatura = ModeloTablaAsignaturas.getInstancia().getCodigoAsignatura(tblAsignaturas.getSelectedRow());
				String matricula = ModeloTablaUsuarios.getInstancia().getMatricula(tblUsuarios.getSelectedRow());
				new ManejadorSemestre(codigoAsignatura, matricula).setVisible(true);;
			}
		});
		btnAadir.setBounds(10, 287, 89, 23);
		contentPane.add(btnAadir);
		
	}
}
