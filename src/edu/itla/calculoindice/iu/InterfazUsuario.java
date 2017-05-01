package edu.itla.calculoindice.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import edu.itla.calculoindice.bd.Conexion;
import edu.itla.calculoindice.modelo.ModeloTablaHistorico;
import edu.itla.calculoindice.modelo.ModeloTablaIndice;

public class InterfazUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JTable tblHistorico;
	private JTable tblIndices;
	ResultSet rs;
	String matricula;
	
	public InterfazUsuario(String usuario) {
		
		setTitle("Calculador de Indice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		mnArchivo.add(mntmCerrarSesion);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblHistorico = new JTable(new ModeloTablaHistorico(usuario));
		
		JScrollPane spHistorico = new JScrollPane(tblHistorico);
		spHistorico.setBounds(10, 11, 414, 218);
		contentPane.add(spHistorico);
		
		try {
			rs = Conexion.getInstancia().hacerConsulta("SELECT matricula FROM usuarios WHERE usuario = '"+usuario+"'");
			if (rs.next()) {
				matricula = rs.getString(1);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tblIndices = new JTable(new ModeloTablaIndice(matricula));
		
		JScrollPane spIndices = new JScrollPane(tblIndices);
		spIndices.setBounds(434, 11, 140, 218);
		contentPane.add(spIndices);
		
		
	}
	
	public void asignarAdministrador() {
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmMantenimientoDeMaterias = new JMenuItem("Mantenimiento de Asignaturas");
		mnMantenimiento.add(mntmMantenimientoDeMaterias);
		mntmMantenimientoDeMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JMenuItem mntmMantenimientoDeSemestre = new JMenuItem("Mantenimiento de Semestre");
		mnMantenimiento.add(mntmMantenimientoDeSemestre);
		mntmMantenimientoDeSemestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoSemestre().setVisible(true);
			}
		});
		
		JMenuItem mntmMantenimientoDeUsuarios = new JMenuItem("Mantenimiento de Usuarios");
		mnMantenimiento.add(mntmMantenimientoDeUsuarios);
		mntmMantenimientoDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoUsuarios().setVisible(true);
			}
		});
		
	}
}
