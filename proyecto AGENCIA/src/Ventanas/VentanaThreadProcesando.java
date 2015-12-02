package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class VentanaThreadProcesando extends JFrame{


	public static final Object[] aLabels = null;
	public static Object panel_1;
	private JTextField txtLlamando;

	public VentanaThreadProcesando(){
		getContentPane().setLayout(null);
		
		txtLlamando = new JTextField();
		txtLlamando.setFont(new Font("DejaVu Serif", Font.BOLD | Font.ITALIC, 11));
		txtLlamando.setText("LLAMANDO...");
		txtLlamando.setBounds(129, 115, 126, 20);
		getContentPane().add(txtLlamando);
		txtLlamando.setColumns(10);
		
	}
}



