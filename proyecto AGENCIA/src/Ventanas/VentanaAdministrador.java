package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Ventanas.VentanaPrincipal;

public class VentanaAdministrador extends JFrame implements ActionListener{


	private JPanel contentPane,panelNorte, panelSur, panelCentro;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFrame ventanaAnterior;
	private JLabel lblTitulo,lblNombre, lblCodigo;
	private JButton btnAniadir, btnVolver;
	private JTextField txtCodigoViaje;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtPrecio;
	private JTextField txtPlazas;
	private JTextField txtRuta;
	private JButton btnAadirViaje;
	private JButton btnAñadirCoche;
	

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblTitulo = new JLabel("VENTANA ADMINISTRADOR");
		lblTitulo.setForeground(new Color(128, 0, 128));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		panelNorte.add(lblTitulo);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		
		btnAñadirCoche = new JButton("A\u00D1ADIR COCHE");
		btnAñadirCoche.addActionListener(this);
		panelSur.add(btnAñadirCoche);
		panelSur.add(btnVolver);
		
		btnAadirViaje = new JButton("A\u00D1ADIR VIAJE");
		btnAadirViaje.addActionListener(this);
		panelSur.add(btnAadirViaje);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblCdigoDelViaje = new JLabel("C\u00F3digo del viaje");
		lblCdigoDelViaje.setBounds(285, 158, 109, 14);
		panelCentro.add(lblCdigoDelViaje);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(285, 213, 46, 14);
		panelCentro.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(285, 271, 46, 14);
		panelCentro.add(lblDestino);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(285, 333, 46, 14);
		panelCentro.add(lblPrecio);
		
		JLabel lblNmeroDePlazas = new JLabel("N\u00FAmero de plazas");
		lblNmeroDePlazas.setBounds(285, 393, 109, 14);
		panelCentro.add(lblNmeroDePlazas);
		
		JLabel lblRutaDeLa = new JLabel("Ruta de la foto");
		lblRutaDeLa.setBounds(285, 454, 109, 14);
		panelCentro.add(lblRutaDeLa);
		
		txtCodigoViaje = new JTextField();
		txtCodigoViaje.setBounds(431, 152, 150, 20);
		panelCentro.add(txtCodigoViaje);
		txtCodigoViaje.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setBounds(431, 207, 150, 20);
		panelCentro.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(431, 268, 150, 20);
		panelCentro.add(txtDestino);
		txtDestino.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(431, 330, 150, 20);
		panelCentro.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtPlazas = new JTextField();
		txtPlazas.setBounds(431, 390, 150, 20);
		panelCentro.add(txtPlazas);
		txtPlazas.setColumns(10);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(431, 451, 150, 20);
		panelCentro.add(txtRuta);
		txtRuta.setColumns(10);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
		
	
	}


	 private void limpiarCampos(){
		
		txtCodigoViaje.setText("");
		txtOrigen.setText("");
		txtDestino.setText("");
		txtPrecio.setText("");
		txtPlazas.setText("");
		txtRuta.setText("");
		
	 }
	 
	private boolean comprabarCamposRellenos(){
		if(txtCodigoViaje.equals("") || txtOrigen.equals("") || txtDestino.equals("") || txtPlazas.equals("") || txtPrecio.equals("") || txtRuta.equals(""))
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
		}else if(botonPulsado == btnAñadirCoche){
			this.dispose();
			new VentanaAniadirVehiculo(this);
	       
		}
		
		
		else if(botonPulsado == btnAadirViaje){
			if(!comprabarCamposRellenos())
				JOptionPane.showMessageDialog(null, "ERROR! Falta algún campo por rellenar", "ERROR", JOptionPane.ERROR_MESSAGE);
			else{
				int cod = Integer.parseInt(txtCodigoViaje.getText());
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				float precio=Float.parseFloat(txtPrecio.getText());
				int numplazas = Integer.parseInt(txtPlazas.getText());
				String foto = txtRuta.getText();
				
				boolean existe = VentanaPrincipal.bd.existeViaje(cod, origen, destino, precio, numplazas, foto);
				if(existe){
					JOptionPane.showMessageDialog(null, "ERROR! Viaje repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
				else{
					VentanaPrincipal.bd.insertarViaje(cod, origen, destino, precio, numplazas, foto);
					JOptionPane.showMessageDialog(null, "Viaje añadido correctamente", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
				}
			}
		}
		
		
	}
}

