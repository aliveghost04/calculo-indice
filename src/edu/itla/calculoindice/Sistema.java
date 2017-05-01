package edu.itla.calculoindice;

import javax.swing.UIManager;

import edu.itla.calculoindice.iu.InterfazUsuario;
import edu.itla.calculoindice.iu.Login;

public class Sistema {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new InterfazUsuario("Erick").setVisible(true);
	}
}
