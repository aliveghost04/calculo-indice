package edu.itla.calculoindice.iu;

import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.itla.calculoindice.bd.Conexion;
import edu.itla.calculoindice.calculo.TipoCalificacion;
import edu.itla.calculoindice.modelo.ModeloTablaUsuarios;

public class ManejadorSemestre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public ManejadorSemestre(String codigoAsignatura, String matricula) {
		
		setTitle("Manejador Semestre");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 11, 56, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblCodigoMateria = new JLabel("Codigo Materia:");
		lblCodigoMateria.setBounds(218, 11, 86, 14);
		contentPane.add(lblCodigoMateria);
		
		table = new JTable(ModeloTablaUsuarios.getInstancia());
		
		final JScrollPane scrollPane = new JScrollPane(table);
		
		final JButton btnMatricula = new JButton(matricula);
		btnMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = -1;
				int resultado = JOptionPane.showConfirmDialog(ManejadorSemestre.this, scrollPane, "Seleccione", JOptionPane.YES_NO_OPTION);
				switch (resultado) {
				case (JOptionPane.YES_OPTION):
					fila = table.getSelectedRow();
					String matricula = ModeloTablaUsuarios.getInstancia().getMatricula(fila);
					btnMatricula.setText(matricula);
				break;
				}
			}
		});
		btnMatricula.setBounds(76, 7, 89, 23);
		contentPane.add(btnMatricula);
		
		final JButton btnMateria = new JButton(codigoAsignatura);
		btnMateria.setBounds(314, 7, 110, 23);
		contentPane.add(btnMateria);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 55, 46, 14);
		contentPane.add(lblNota);
		
		final JFormattedTextField formattedTextField = new JFormattedTextField();
		try {
			formattedTextField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedTextField.setBounds(75, 52, 40, 23);
		contentPane.add(formattedTextField);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String texto = formattedTextField.getText();
				int nota = Integer.parseInt(texto);
				String literal = TipoCalificacion.getInstancia().getValorLiteral(nota);
				if (literal != "-1") {
					try {
						Conexion.getInstancia().hacerCambio("INSERT INTO calificaciones values('"+btnMateria.getText()+"', "+nota+", '"+btnMatricula.getText()+"')");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(ManejadorSemestre.this, "Introduzca una nota valida 0 - 99",
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(76, 130, 89, 23);
		contentPane.add(btnGuardar);
		
	}
}
