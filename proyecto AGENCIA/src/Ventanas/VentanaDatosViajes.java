package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Ventanas.VentanaFotosViaje;
import TipoDeDatos.Viajes;

import javax.swing.JTextField;

import 	Ventanas.VentanaPrincipal;

public class VentanaDatosViajes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtPersonas;
	private JTextField txtPrecio;
	private JButton btnComprar,btnVolver;
	private String foto;
	private Viajes v;
	private JLabel lblOrigen,lblDestino,lblPrecio,lblOrigen_1,lblDestino_1,lblPersonas,lblPrecio_1,lblNumeroP;
	private JLabel lblFoto;
    private LinkedList<Viajes> ViajesSeleccionados;
    private JButton btnVerCalendario;
	

	/**
	 * Create the frame.
	 */
	public VentanaDatosViajes(JFrame va,String f) {
		foto=f;
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblDatosDelCoche = new JLabel("DATOS DEL VIAJE SELECCIONADO");
		panel.add(lblDatosDelCoche);
		

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnComprar = new JButton("COMPRAR VIAJE");
		btnComprar.addActionListener(this);
		panel_1.add(btnComprar);
		
		 btnVolver = new JButton("VOLVER");
		 btnVolver.addActionListener(this);
		
		btnVerCalendario = new JButton("VER CALENDARIO");
		panel_1.add(btnVerCalendario);
		panel_1.add(btnVolver);
		btnVerCalendario.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		v = VentanaPrincipal.bd.obtenerViaje(foto);
		ImageIcon im = new ImageIcon(v.getFoto());
		panel_2.setLayout(null);
		lblFoto = new JLabel(im);
		lblFoto.setBounds(110, 122, 253, 349);
		panel_2.add(lblFoto);


		
		lblOrigen = new JLabel(v.getOrigen());
		lblOrigen.setBounds(600, 219, 76, 14);
		panel_2.add(lblOrigen);
		
		lblDestino = new JLabel(v.getDestino());
		lblDestino.setBounds(600, 259, 76, 14);
		panel_2.add(lblDestino);
		
		lblPrecio = new JLabel(String.valueOf(v.getPrecio()));
		lblPrecio.setBounds(600, 296, 53, 14);
		panel_2.add(lblPrecio);
		
		lblNumeroP=new JLabel (String.valueOf(v.getNumPlazas()));
		lblNumeroP.setBounds(600, 337, 46, 14);
		panel_2.add(lblNumeroP);
		this.setVisible(true);
		
		lblOrigen_1 = new JLabel("Origen");
		lblOrigen_1.setBounds(524, 219, 46, 14);
		panel_2.add(lblOrigen_1);
		
		lblDestino_1 = new JLabel("Destino");
		lblDestino_1.setBounds(524, 259, 46, 14);
		panel_2.add(lblDestino_1);
		
		lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(524, 296, 46, 14);
		panel_2.add(lblPrecio_1);
		
		lblPersonas = new JLabel("Personas");
		lblPersonas.setBounds(524, 337, 60, 14);
		panel_2.add(lblPersonas);
		
		this.setBounds(160, 100, 1000, 800);
		
	}
    
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton)e.getSource();
		if(botonPulsado ==btnVolver){
			this.dispose();
			
			((VentanaFotosViaje)ventanaAnterior).cargarFotos();
			ventanaAnterior.setVisible(true);
			
		}
		else if(botonPulsado==btnComprar){
			this.dispose();
			//Guardamos en una LinkedList los viajes seleccionados 
			VentanaInicioSesion.carrito.add(v);
			System.out.println("Se ha añadido al carrito el viaje"+v);
			JOptionPane.showMessageDialog(null, "Se ha añadido el viaje al carrito", "VIAJE AÑADIDO",JOptionPane.INFORMATION_MESSAGE);
			VentanaPrincipal.bd.eliminarViaje(v.getCod());
			new VentanaDeseaComprarCoche(this);
		
		}
		else if(botonPulsado==btnVerCalendario){
			this.dispose();
			new VentanaCalendario(this);
		}
	}
}
