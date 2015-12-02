package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import GestionFichero.GestionFicheros;
import TipoDeDatos.Coche;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Ventana para seleccionar la marca y modelo de coche
 * @author alvaro
 *
 */
public class VentanaSeleccionCoche extends JFrame implements ActionListener{

	private JPanel contentPane;
	private HashMap<String,Coche> hmCoches;
	private JFrame ventanaAnterior;
	private JButton btnVerCochesDisponibles, btnVolver, btnComprar;
	private JComboBox comboMarcas, comboModelo;
	/**
	 * Create the frame.
	 */
	public VentanaSeleccionCoche(JFrame va) {
		ventanaAnterior = va;
		hmCoches = GestionFicheros.obtenerHasMapCoche();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 24);
		contentPane.add(panel);

		JLabel lblSeleccionaElCoche = new JLabel("SELECCIONA EL COCHE QUE DESEAS COMPRAR");
		panel.add(lblSeleccionaElCoche);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 223, 424, 33);
		contentPane.add(panel_1);

		
		btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);
	
	
		
		
		
		btnVerCochesDisponibles = new JButton("VER COCHES DISPONIBLES");
		btnVerCochesDisponibles.addActionListener(this);
		panel_1.add(btnVerCochesDisponibles);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 0, 0);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSeleccionaLaMarca = new JLabel("Selecciona la marca");
		lblSeleccionaLaMarca.setBounds(10, 55, 168, 24);
		contentPane.add(lblSeleccionaLaMarca);
		
		comboMarcas = new JComboBox();
		comboMarcas.setBounds(227, 55, 197, 24);
		contentPane.add(comboMarcas);
		
		JLabel lblSeleccionaElModelo = new JLabel("Selecciona el modelo");
		lblSeleccionaElModelo.setBounds(10, 128, 168, 24);
		contentPane.add(lblSeleccionaElModelo);
		
		comboModelo = new JComboBox();
		comboModelo.setBounds(227, 128, 186, 24);
		contentPane.add(comboModelo);
		Collection<Coche> cCoches=hmCoches.values();
		Iterator<Coche> itCoches = cCoches.iterator(); // recorrer el hash Map de coches
		String [] aMarcas = new String[cCoches.size()];
		String [] aModelos = new String[cCoches.size()];
		int i=0,k=0;
		while(itCoches.hasNext()){
			Coche c = itCoches.next();
			boolean enc=false;
			int pos=0;
			while(!enc && pos<i){
				if(aMarcas[pos].equalsIgnoreCase(c.getMarca()))
					enc=true;
				else
					pos++;
			}
			if(!enc){
				aMarcas[i]=c.getMarca(); //aniade la marca
				i++;
			}
			enc=false;
			pos=0;
			while(!enc && pos<k){
				if(aModelos[pos].equalsIgnoreCase(c.getModelo()))
					enc=true;
				else
					pos++;
			}
			if(!enc){
				System.out.println(c.getModelo());
				aModelos[k]=c.getModelo(); //aniade el modelo
				k++;
			}
		}
		for(int j=0;j<i;j++)
			comboMarcas.addItem(aMarcas[j]); // aniadir al combo la marca

		
		for(int j=0;j<k;j++)
			comboModelo.addItem(aModelos[j]); // aniadir al como los modelos de los coches disponibles
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}
	/**
	 * Método que dependiendo del boton seleccionado hará una u otra cosa.
	 * si boton volver seleccionado se volverá atras
	 * si boton ver coches disponibles, iremos a la siguiente ventana
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton)e.getSource();
		if(botonPulsado == btnVerCochesDisponibles){
			this.setVisible(false);
			new VentanaFotosCoches(this, (String)comboMarcas.getSelectedItem(), (String)comboModelo.getSelectedItem());
		}
		
		else if (botonPulsado== btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
			
		}
	
		
	}
}

