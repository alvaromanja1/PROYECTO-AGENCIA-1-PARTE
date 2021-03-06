package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;

import TipoDeDatos.Cliente;
import TipoDeDatos.Vehiculo;

public class VentanaDeseaComprarCoche extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private JButton btnSi,btnNo,btnVolver;
	private Cliente c;
	


	/**
	 * Create the frame.
	 */
	public VentanaDeseaComprarCoche(JFrame va) {
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldeseaComprarUn = new JLabel("\u00BFDESEA ALQUILAR UN VEH\u00CDCULO?");
		lbldeseaComprarUn.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD | Font.ITALIC, 16));
		lbldeseaComprarUn.setForeground(Color.DARK_GRAY);
		lbldeseaComprarUn.setBackground(Color.BLUE);
		lbldeseaComprarUn.setBounds(312, 191, 247, 14);
		contentPane.add(lbldeseaComprarUn);
		
		btnSi = new JButton("SI");
		btnSi.addActionListener(this);
		btnSi.setBounds(136, 339, 89, 23);
		contentPane.add(btnSi);
		
		btnNo = new JButton("NO");
		btnNo.addActionListener(this);
		btnNo.setBounds(672, 339, 89, 23);
		contentPane.add(btnNo);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(385, 575, 89, 23);
		contentPane.add(btnVolver);
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
			
	}
		else if (botonPulsado==btnSi){
			this.setVisible(false);
		// que se vea la marca insertada por el administrador tambien
			LinkedList<String> marcas = VentanaPrincipal.bd.obtenerMarcas();
			
			String s="Selecciona la marca: (";
			int i;
			for(i=0;i<marcas.size()-1;i++){
				s=s+" " + marcas.get(i)+",";
			}
			s= s + marcas.get(i)+" )";
			String marca = JOptionPane.showInputDialog(s);
			LinkedList<String> modelos = VentanaPrincipal.bd.obtenerModelos(marca);
			s="Selecciona el modelo: (";
			for(i=0;i<modelos.size()-1;i++){
				s=s+" " + modelos.get(i)+ ",";
			}
			s= s + modelos.get(i)+" )";
			
			String modelo = JOptionPane.showInputDialog(s);
			new VentanaFotosCoches(this,marca,modelo);
		}
		else if(botonPulsado==btnNo){
			this.setVisible(false);	
			new VentanaCliente(this);
		}
	}
	
}
