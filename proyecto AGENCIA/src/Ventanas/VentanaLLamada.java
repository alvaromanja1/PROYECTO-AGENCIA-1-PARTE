package Ventanas;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VentanaLLamada extends JFrame implements ActionListener {

	private JPanel contentPane,panelNorte,panelSur,panelCentro;
	private JLabel lblFoto,lblTitulo;
    private JFrame ventanaanterior;
    private JButton btnVolver,btnColgar,btnAyudaViaje,btnAyudaCoche;
	private Clip audio;
	/**
	 * Create the frame.
	 */
	public VentanaLLamada(JFrame va) {
		
		
		try {
			audio = AudioSystem.getClip();
			audio.open(AudioSystem.getAudioInputStream(new File("SONIDO/atencionalcliente.wav")));
			audio.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		ventanaanterior= va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblTitulo = new JLabel("ATENCI\u00D3N AL CLIENTE");
		panelNorte.add(lblTitulo);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("VOLVER");
		panelSur.add(btnVolver);
        btnVolver.addActionListener(this);		
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		lblFoto = new JLabel("");
		ImageIcon i= new ImageIcon("FOTO/atencion-al-cliente.jpg");
		lblFoto.setIcon(i);
		lblFoto.setBounds(95, 320, 278, 283);
		panelCentro.add(lblFoto);
		
		btnColgar = new JButton("Colgar");
		btnColgar.setBounds(384, 528, 235, 25);
		panelCentro.add(btnColgar);
		btnColgar.addActionListener(this);
		
		btnAyudaCoche = new JButton("\u00BFComo puedo comprar un coche ?");
		btnAyudaCoche.setBounds(384, 473, 235, 25);
		panelCentro.add(btnAyudaCoche);
		btnAyudaCoche.addActionListener(this);
		
		btnAyudaViaje = new JButton("\u00BFComo puedo comprar un viaje?");
		btnAyudaViaje.setBounds(384, 426, 235, 25);
		panelCentro.add(btnAyudaViaje);
		btnAyudaViaje.addActionListener(this);
		
		
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			audio.stop();
			ventanaanterior.setVisible(true);
		}else if(botonPulsado == btnColgar){
			
	        this.dispose();
	        audio.stop();
	        new VentanaPrincipal(this);
	    
		}else if(botonPulsado == btnAyudaViaje){
	    	this.dispose();
	    	audio.stop();
	    	new VentanaAyudaViaje(this);
	    }else if(botonPulsado == btnAyudaCoche){
	    	this.dispose();
	    	audio.stop();
	    	new VentanaAyudaCoche(this);
	    }
		
	}

}