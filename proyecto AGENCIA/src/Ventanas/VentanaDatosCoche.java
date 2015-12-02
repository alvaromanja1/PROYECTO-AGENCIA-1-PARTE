package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import TipoDeDatos.Coche;
import TipoDeDatos.Vehiculo;

/**
 * Ventana que muestra las prestaciones del vehiculo seleccionado
 * @author alvaro
 *
 */
public class VentanaDatosCoche extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private JButton btnVolver, btnComprar;
	private JLabel lblFoto,lblPrecio,lblCaballos,lblColor,lblModelo,lblMarca;
	private String ruta;
	private Vehiculo c;

	/**
	 * Metodo que muestra la marca, modelo, color, caballos y precio del coche seleccionado (coche c)
	 * @param va
	 * @param c
	 */
	public VentanaDatosCoche(JFrame va,String r) {
		ruta=r;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblDatosDelCoche = new JLabel("DATOS DEL COCHE SELECCIONADO");
		panel.add(lblDatosDelCoche);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnComprar = new JButton("COMPRAR");
		panel_1.add(btnComprar);
		btnComprar.addActionListener(this);
		
		btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		
		c = VentanaPrincipal.bd.obtenerVehiculo(ruta);
		ImageIcon im = new ImageIcon(c.getRutaFoto());
		panel_2.setLayout(null);
		lblFoto = new JLabel(im);
		lblFoto.setBounds(54, 176, 468, 401);
		panel_2.add(lblFoto);

		
		
		JLabel lblMatricula = new JLabel("Marca");
		lblMatricula.setBounds(561, 198, 81, 20);
		panel_2.add(lblMatricula);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(561, 291, 81, 20);
		panel_2.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(561, 376, 81, 20);
		panel_2.add(lblColor);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(561, 469, 81, 14);
		panel_2.add(lblPrecio);
		
		lblMarca = new JLabel();
		lblMarca.setBounds(654, 198, 86, 20);
		lblMarca.setText(c.getMarca());
		panel_2.add(lblMarca);
		
		lblModelo = new JLabel();
		lblModelo.setBounds(654, 291, 86, 20);
		lblModelo.setText(c.getModelo());
		panel_2.add(lblModelo);
	
		
		lblColor = new JLabel();
		lblColor.setBounds(654, 376, 86, 20);
		lblColor.setText(c.getColor());
		panel_2.add(lblColor);
		
		
		
		lblPrecio = new JLabel();
		lblPrecio.setText("");
		lblPrecio.setBounds(654, 466, 86, 20);
		lblPrecio.setText(String.valueOf(c.getPrecio()));
		panel_2.add(lblPrecio);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	/**
	 * 	Método que dependiendo del boton seleccionado hará una acción u otra. SI:
	 * seleccionamos volver volverá a la ventana anterior
	 * seleccionamos comprar iremos a la ventana de compra del coche
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton)e.getSource();
		if(botonPulsado ==btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
			
	}
		else if (botonPulsado==btnComprar){
			this.setVisible(false);	
			new VentanaCliente(ventanaAnterior);
		}
	}
	
}