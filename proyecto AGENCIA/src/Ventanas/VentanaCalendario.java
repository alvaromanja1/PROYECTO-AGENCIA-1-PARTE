package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

public class VentanaCalendario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JCalendar calendario;
	private JButton btnIda,btnVolver,btnRegreso;
	private JFrame ventanaAnterior;
	
	
	public VentanaCalendario(JFrame va) {
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCalendario = new JLabel("CALENDARIO");
		panel.add(lblCalendario);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		calendario = new JCalendar();
		calendario.setBounds(151, 216, 307, 251);
		panel_2.add(calendario);
		
		btnIda = new JButton("SALIDA");
		btnIda.setBounds(582, 250, 155, 25);
		panel_2.add(btnIda);
		btnIda.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dia=calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes=calendario.getCalendar().get(Calendar.MONTH);
				int anio=calendario.getCalendar().get(Calendar.YEAR);
				System.out.println("Fecha de ida: "+dia+ "/"+mes+ "/"+anio);
				
				
				
			}
			
		});
		
		btnRegreso = new JButton("REGRESO");
		btnRegreso.setBounds(582, 365, 155, 25);
		panel_2.add(btnRegreso);
		btnRegreso.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dia=calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes=calendario.getCalendar().get(Calendar.MONTH);
				int anio=calendario.getCalendar().get(Calendar.YEAR);
				System.out.println("Fecha de vuelta: "+dia+ "/"+mes+"/"+anio);
			}
			
		});
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado=(JButton)e.getSource();
		if(botonPulsado==btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	}
}
