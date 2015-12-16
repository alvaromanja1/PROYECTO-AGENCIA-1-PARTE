package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



import TipoDeDatos.Coche;
import TipoDeDatos.Viajes;

public class VentanaFotosViaje extends JFrame implements ActionListener, MouseListener {


		private JPanel contentPane,panelFotos;
		private JScrollPane scrollFotos;
		private String destino;
		private JFrame ventanaAnterior;
		private JButton btnVolver;
		private JLabel lblViajesDisponibles;
		public static LinkedList<String> aRutasViajes;
		
		/**
		 * Método que carga las fotos. Recorre el array de rutas y lo inserta en una jLabel. Este a su vez se introducira en un 
		 * image icon
		 */
		public void cargarFotos(){
		panelFotos.removeAll();
		aRutasViajes=VentanaPrincipal.bd.obtenerRutasFotos();
		for(int j=0;j<aRutasViajes.size();j++)
		{
			String foto = (String)aRutasViajes.get(j);
			System.out.println(foto);
			JLabel l = new JLabel();
			ImageIcon i= new ImageIcon(foto);
			i.setDescription(foto);
			l.setIcon(i);
			panelFotos.add(l);
		}
		panelFotos.repaint();
		}

		
		public VentanaFotosViaje(JFrame va, String destino) {
			ventanaAnterior=va;
			this.destino=destino;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			lblViajesDisponibles = new JLabel("VIAJES DISPONIBLES");
			panel.add(lblViajesDisponibles);
			
		
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.SOUTH);
			
			btnVolver = new JButton("VOLVER");
			panel_1.add(btnVolver);
			btnVolver.addActionListener(this);
			
			
			panelFotos = new JPanel();
			panelFotos.setLayout(new GridLayout(2, 5, 0, 0));
			scrollFotos = new JScrollPane(panelFotos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollFotos.addMouseListener(this);
			panelFotos.addMouseListener(this);
			cargarFotos();
			contentPane.add(scrollFotos, BorderLayout.CENTER);
			setVisible(true);
			this.setBounds(160, 100, 1000, 800);
		}
		/**
		 * Método que al clickar en volver, retrocede una ventana atras
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton botonPulsado = (JButton)e.getSource();
			if(botonPulsado ==btnVolver){
				this.dispose();
				ventanaAnterior.setVisible(true);
				
			}
			
		
		}

		/**
		 * Método que obtiene la ruta de la foto en la que tenemos el puntero del ratón para de esta manera saber que vehiculo es
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			
			Point p = panelFotos.getMousePosition();
			JLabel fotos = (JLabel)panelFotos.getComponentAt(p);
			ImageIcon im = (ImageIcon)fotos.getIcon();
			String foto = im.getDescription();		
			this.dispose();
			new VentanaDatosViajes(this,foto);
			System.out.println("HAS SELECCIONADO "+foto);
/*
 * 			
//			
		
			
			Viajes v = logica.obtenerViajes(ruta);
		
 */
			
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	

	}


