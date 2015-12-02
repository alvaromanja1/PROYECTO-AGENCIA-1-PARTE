package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Ventanas.VentanaPrincipal;
import Ventanas.VentanaFotosCoches;
import TipoDeDatos.Cliente;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class VentanaCliente extends JFrame implements ActionListener {


	private JPanel contentPane,panelNorte, panelSur, panelCentro;
	private JFrame ventanaAnterior;
	private JButton btnComprarCoche,btnComprarViaje,btnPagar,btnVerCarrito,btnVolver;
	private JLabel lblBienvenido;
	private JLabel lblFotoCliente;
	private Cliente c;
	private String foto;
	public static JTextField lblNombre;
	


	/**
	 * Create the frame.
	 */
	public VentanaCliente(JFrame va) {
		ventanaAnterior=va;
		c = VentanaPrincipal.bd.obtenerCliente(VentanaInicioSesion.dniCliente);
		if(c!=null)
			System.out.println("Ruta: "+c.getFoto());
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		panelSur.add(btnVolver);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		btnComprarCoche = new JButton("COMPRAR OTRO COCHE");
		btnComprarCoche.setBounds(370, 444, 173, 23);
		panelCentro.add(btnComprarCoche);
		btnComprarCoche.addActionListener(this);
		
		btnComprarViaje = new JButton("COMPRAR OTRO VIAJE");
		btnComprarViaje.setBounds(370, 392, 173, 23);
		panelCentro.add(btnComprarViaje);
		btnComprarViaje.addActionListener(this);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(370, 342, 173, 23);
		panelCentro.add(btnPagar);
		btnPagar.addActionListener(this);
	
	

		
		
		ImageIcon im = new ImageIcon(c.getFoto());
		lblFotoCliente = new JLabel(im);
		lblFotoCliente.setBounds(95, 242, 229, 317);
		panelCentro.add(lblFotoCliente);
		
		btnVerCarrito = new JButton("VER CARRITO");
		btnVerCarrito.setBounds(370, 288, 173, 25);
		panelCentro.add(btnVerCarrito);
		
		lblNombre = new JTextField();
		lblNombre.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 15));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setText("Cliente: " +c.getNom());
		lblNombre.setBounds(119, 187, 173, 22);
		panelCentro.add(lblNombre);
		lblNombre.setColumns(10);
		
		btnVerCarrito.addActionListener(this);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton)e.getSource();
		if(botonPulsado ==btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
			
	}else if(botonPulsado == btnVerCarrito){
		this.dispose();
		new VentanaCarritoViajes(this);
	
	}else if(botonPulsado == btnPagar){
		this.dispose();
		new VentanaPago(this);
	
	}else if(botonPulsado == btnComprarCoche){
		this.dispose();
		//new VentanaFotosCoches(this,marca,modelo);
	}else if(botonPulsado == btnComprarViaje){
		this.dispose();
		//new VentanaFotosViaje(ventanaAnterior, foto);
	
	}
		
	}
	
}
