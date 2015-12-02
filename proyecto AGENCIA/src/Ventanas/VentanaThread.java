package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;

import Threads.MiThread;



/**
 * Clase thread
 *
 */
public class VentanaThread extends JFrame {

	private JPanel contentPane;
	public JPanel panelCentro;
	public JLabel aLabels[];
	private Clip audio;
	/**
	 * Create the frame.
	 */
	public VentanaThread() {
		
		try {
			audio = AudioSystem.getClip();
			audio.open(AudioSystem.getAudioInputStream(new File("SONIDO/llamadatelefono.wav")));
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.WHITE);
		contentPane.add(panelSur, BorderLayout.NORTH);
		
		JLabel lblAnalizando = new JLabel("LLAMANDO..."); //introducir texto en un jLabel
		lblAnalizando.setFont(new Font("Copperplate Gothic Light", Font.BOLD | Font.ITALIC, 11));
		panelSur.add(lblAnalizando);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblEspereUnosSegundos = new JLabel("Espere unos segundos por favor ");            
		lblEspereUnosSegundos.setBackground(Color.WHITE);
		lblEspereUnosSegundos.setBounds(12, 184, 424, 23);
		panelCentro.add(lblEspereUnosSegundos);
		
		aLabels = new JLabel[20];
		int x=10;
		for(int i=0;i<aLabels.length;i++){ // recorrer arrays de labels (en total son 20)
			ImageIcon im  = new ImageIcon("FOTO/llamada-telefonica.jpg");
			aLabels[i]=new JLabel(im); 
			aLabels[i].setVisible(false);
			aLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			aLabels[i].setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15)); 
			aLabels[i].setBounds(x, 100, 20, 20); //coordenada de introduccion del label
			x=x+20;
			panelCentro.add(aLabels[i]);
			
		}
		
		this.setVisible(true);
	}
}
