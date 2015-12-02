package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import BD.BD;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class VentanaInicioSesion extends JFrame implements ActionListener {

	private JButton btnSalir,btnAceptar,btnRegistrarse;
	private JPanel contentPane;
	private JTextField txtDni,txtDni2,txtNombre,txtEdad;;
	private JLabel lblDni,lblNombre,lblDni2,lblEdad;
	private JPanel panelCentro, panelSur, panelNorte, panelEste, panelOeste;
	private JFrame ventanaAnterior;
	public static String dniCliente;
	public static LinkedList carrito ;
	

	private void ponerInvisible(){
		btnRegistrarse.setVisible(false);
		lblEdad.setVisible(false);
		lblDni2.setVisible(false);
		lblNombre.setVisible(false);
		txtDni2.setVisible(false);
		txtNombre.setVisible(false);
		txtEdad.setVisible(false);
	
	}
	
	private void ponerVisible(){
		btnRegistrarse.setVisible(true);
		lblEdad.setVisible(true);
		lblDni2.setVisible(true);
		lblNombre.setVisible(true);
		txtDni2.setVisible(true);
		txtNombre.setVisible(true);
		txtEdad.setVisible(true);
		
	}
	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion(JFrame va) {
		carrito = new LinkedList();
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 139), null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
		flowLayout.setAlignOnBaseline(true);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnSalir = new JButton("SALIR");
	    /*btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});*/
		btnSalir.addActionListener(this);
	
		panelSur.add(btnSalir);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		panelSur.add(btnAceptar);
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		lblDni = new JLabel("Introduce tu dni");
		lblDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDni.setBounds(288, 255, 129, 25);
		panelCentro.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(427, 259, 112, 20);
		panelCentro.add(txtDni);
		txtDni.setColumns(10);
		
		btnRegistrarse = new JButton("REGISTRARSE\r\n");
		btnRegistrarse.addActionListener(this);
		
		btnRegistrarse.setBounds(661, 362, 106, 27);
		panelCentro.add(btnRegistrarse);
		
		lblDni2 = new JLabel("DNI");
		lblDni2.setBounds(326, 324, 46, 14);
		panelCentro.add(lblDni2);
		
		txtDni2 = new JTextField();
		txtDni2.setBounds(427, 321, 112, 20);
		panelCentro.add(txtDni2);
		txtDni2.setColumns(10);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(326, 401, 46, 14);
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(427, 398, 112, 20);
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(326, 474, 46, 14);
		panelCentro.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(427, 471, 112, 20);
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);
		ponerInvisible();
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		
		if(botonPulsado == btnSalir){
			System.exit(0);
		}
		else if(botonPulsado==btnAceptar){
			String d = txtDni.getText();
			if(d.equals("***")){
					new VentanaAdministrador(this);
					txtDni.setText("");
			}
			else{
				boolean existe = VentanaPrincipal.bd.existeCliente(d);
				if(existe){
					dniCliente = txtDni.getText();
					txtDni.setText("");
					new VentanaFotosViaje(this,d);
					this.setVisible(false);
				}
				else{
					ponerVisible();
					
				}
			}
	      		
		}
		else if(botonPulsado == btnRegistrarse){
			if(txtDni2.getText().equals("") || txtNombre.getText().equals("") || txtEdad.getText().equals("")){
				JOptionPane.showMessageDialog(null, "ERROR! Falta por rellenar algún campo", "ERROR", JOptionPane.ERROR_MESSAGE);
	
			}
			else if (!txtDni.getText().equals(txtDni2.getText())){
				JOptionPane.showMessageDialog(null, "ERROR! El dni no es correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else{
				String d = txtDni2.getText();
				String n = txtNombre.getText();	
				int ed = Integer.parseInt(txtEdad.getText());
				VentanaPrincipal.bd.insertarCliente(d, n);
				JOptionPane.showMessageDialog(null, "Registro completado con exito", "REGISTRADO", JOptionPane.INFORMATION_MESSAGE);
				txtDni2.setText("");
				txtNombre.setText("");
				txtEdad.setText("");
				ponerInvisible();
			}
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
