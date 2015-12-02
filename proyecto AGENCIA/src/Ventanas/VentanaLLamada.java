package Ventanas;


import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JFrame ventanaAnterior;
    private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public VentanaLLamada(JFrame va) {
		
		ventanaAnterior= va;
		
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
		
		lblFoto = new JLabel("New label");
		ImageIcon i= new ImageIcon("FOTO/atencion-al-cliente.jpg");
		lblFoto.setIcon(i);
		lblFoto.setBounds(24, 27, 138, 148);
		panelCentro.add(lblFoto);
		
		JRadioButton rdbtnColgar = new JRadioButton("Colgar");
		rdbtnColgar.setBounds(213, 124, 127, 25);
		panelCentro.add(rdbtnColgar);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(213, 89, 127, 25);
		panelCentro.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(213, 50, 127, 25);
		panelCentro.add(rdbtnNewRadioButton_2);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	
	
	}


}
