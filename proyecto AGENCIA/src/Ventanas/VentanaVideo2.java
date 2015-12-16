package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaVideo2 extends JFrame {

	private Player player;
	private Component video;
	private Component controles;
    
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public VentanaVideo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		  URL url=null;
	         try {
	             url = new URL("Madrid.mpg");
	         } catch (MalformedURLException ex) {
	             Logger.getLogger(VentanaVideo2.class.getName()).log(Level.SEVERE, null, ex);
	         }
	         try {
	             player = Manager.createRealizedPlayer(new MediaLocator(url));
	             video = player.getVisualComponent();
	             video.setSize(300,100);
	             video.setVisible(true);
	             if(video != null)
	                 //panel.add("Center",video);
	            	 contentPane.add("Center",video);
	             
	             controles = player.getControlPanelComponent();
	             controles.setSize(800,100);
	             controles.setVisible(true);
	             if(controles != null)
	                 //panel.add("South",controles);
	            	 contentPane.add("South",controles);
	             
	            // add(panel);
	             player.start();
	            // panel.updateUI();
	         } catch (Exception ex) {
	             Logger.getLogger(VentanaVideo2.class.getName()).log(Level.SEVERE, null, ex);
	         }

		setContentPane(contentPane);
		setVisible(true);
		
	}
	
 

}

