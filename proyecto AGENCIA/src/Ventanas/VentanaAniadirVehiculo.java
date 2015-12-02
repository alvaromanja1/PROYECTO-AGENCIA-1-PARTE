package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaAniadirVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtMatricula;
	private JTextField txtRuta;
    private JFrame ventanaAnterior;
	
	/**
	 * Create the frame.
	 */
	public VentanaAniadirVehiculo(JFrame va) {
		
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAniadirNuevoCoche = new JLabel("A\u00D1ADIR NUEVO COCHE");
		panel.add(lblAniadirNuevoCoche);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);
		
		JButton btnAniadirCoche = new JButton("A\u00D1ADIR COCHE");
		panel_1.add(btnAniadirCoche);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(67, 16, 56, 16);
		panel_2.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(67, 44, 56, 16);
		panel_2.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(67, 73, 56, 16);
		panel_2.add(lblColor);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(67, 102, 56, 16);
		panel_2.add(lblPrecio);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(67, 131, 56, 16);
		panel_2.add(lblMatricula);
		
		JLabel lblRutaFoto = new JLabel("Ruta Foto");
		lblRutaFoto.setBounds(67, 160, 56, 16);
		panel_2.add(lblRutaFoto);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(174, 13, 116, 22);
		panel_2.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(174, 41, 116, 22);
		panel_2.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(174, 70, 116, 22);
		panel_2.add(txtColor);
		txtColor.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(174, 99, 116, 22);
		panel_2.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(174, 128, 116, 22);
		panel_2.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(174, 157, 116, 22);
		panel_2.add(txtRuta);
		txtRuta.setColumns(10);
	    this.setVisible(true);
	}
}
