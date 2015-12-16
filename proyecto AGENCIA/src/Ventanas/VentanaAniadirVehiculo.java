package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import TipoDeDatos.Vehiculo;
import TipoDeDatos.Viajes;

public class VentanaAniadirVehiculo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtMatricula;
	private JTextField txtRuta;
    private JFrame ventanaAnterior;
    private JButton btnVolver,btnAniadirCoche;
    private String Marca;
    private LinkedList<Vehiculo> Marcas;
    
    
	
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
		
		btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);
		
		btnAniadirCoche = new JButton("A\u00D1ADIR COCHE");
		panel_1.add(btnAniadirCoche);
		btnAniadirCoche.addActionListener(this);
		
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

	 private void limpiarCampos(){
			
			txtMarca.setText("");
			txtModelo.setText("");
			txtColor.setText("");
			txtPrecio.setText("");
			txtMatricula.setText("");
			txtRuta.setText("");
			
		 }
	 
		private boolean comprabarCamposRellenos(){
			if(txtMarca.equals("") || txtModelo.equals("") || txtColor.equals("") || txtMatricula.equals("") || txtPrecio.equals("") || txtRuta.equals(""))
				return false;
			else
				return true;
		}
	
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton botonPulsado = (JButton) e.getSource();
			if(botonPulsado == btnVolver){
				this.dispose();
				ventanaAnterior.setVisible(true);
			}
			
			
			else if(botonPulsado == btnAniadirCoche){
				if(!comprabarCamposRellenos())
					JOptionPane.showMessageDialog(null, "ERROR! Falta algún campo por rellenar", "ERROR", JOptionPane.ERROR_MESSAGE);
				else{
					String color = txtColor.getText();
					Marca = txtMarca.getText();
					String modelo = txtModelo.getText();
					float precio=Float.parseFloat(txtPrecio.getText());
					String matricula= txtMatricula.getText();
					String foto=txtRuta.getText();
					
					
					
					boolean existe = VentanaPrincipal.bd.existeVehiculos(color, Marca, modelo, precio, matricula, foto);
					if(existe){
						JOptionPane.showMessageDialog(null, "ERROR! Vehiculo repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
						limpiarCampos();
					}
					else{
						VentanaPrincipal.bd.insertarVehiculo(color,Marca,modelo,precio,matricula,foto);
						JOptionPane.showMessageDialog(null, "Vehiculo añadido correctamente", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
				}
			}
			
			
		}
}

