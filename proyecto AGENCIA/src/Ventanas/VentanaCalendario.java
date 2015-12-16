package Ventanas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

public class VentanaCalendario extends JFrame implements ActionListener{

	private JPanel contentPane,PanelCentro;
	private JCalendar calendario;
	private JButton btnIda,btnVolver,btnRegreso;
	private JFrame ventanaAnterior;
	private int dia,dia1,mes,mes1,anio,anio1;
	private Calendar cal;
	private ArrayList events;
	
	
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
		
		PanelCentro = new JPanel();
		contentPane.add(PanelCentro, BorderLayout.CENTER);
		PanelCentro.setLayout(null);
		
		calendario = new JCalendar();
		calendario.setBounds(151, 216, 307, 251);
		PanelCentro.add(calendario);
		
		
		
		btnIda = new JButton("SALIDA");
		btnIda.setBounds(582, 250, 155, 25);
		PanelCentro.add(btnIda);
		btnIda.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dia=calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes=calendario.getCalendar().get(Calendar.MONTH);
				anio=calendario.getCalendar().get(Calendar.YEAR);
				System.out.println("Fecha de ida: "+dia+ "/"+mes+ "/"+anio);
				
			}
			
		});
		
		
		
		btnRegreso = new JButton("REGRESO");
		btnRegreso.setBounds(582, 365, 155, 25);
		PanelCentro.add(btnRegreso);
		btnRegreso.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				
				dia1=calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes1=calendario.getCalendar().get(Calendar.MONTH);
				anio1=calendario.getCalendar().get(Calendar.YEAR);
				System.out.println("Fecha de vuelta: "+dia1+ "/"+mes1+"/"+anio1);
				
				
			/*	Queremos obtener en qué día de la semana empieza el mes de la fecha de salida
			 * Por ejemplo: Diciembre del 2015 empieza en Martes
			 * 
			 * GregorianCalendar gc = new GregorianCalendar(anio, mes, dia);
				int d = gc.get(Calendar.DAY_OF_WEEK); 
				System.out.println("Dia:"+d);*/
				
				PanelCentro= calendario.getDayChooser().getDayPanel();
				Component component[] = PanelCentro.getComponents();
				
                //Sumamos mas 7 porque empiea a contar desde el elemento lunes
//				  for (int i = dia+7; i <dia1+8; i++) {
//					  System.out.println(component[i].getClass().getSuperclass());
//					  System.out.println(((JButton)component[i]).getText());
//				         component[i].setBackground(Color.red);
//				    }
				for (Component c : component) {
					try {
						int diaDePanel = Integer.parseInt( ((JButton)c).getText() ); 
						if (diaDePanel>=dia && diaDePanel<=dia1) {
							c.setBackground( Color.red );
						}
					} catch (Exception e2) {}
				}
                 			
			
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
