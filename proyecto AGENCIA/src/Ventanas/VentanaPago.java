package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaPago extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField txtTarjeta;
		private JButton btnVolver;
		private JFrame ventanaAnterior;
		private JLabel lblNombre,lblApellido,lblCorreoElectrnico,lblFechaDeNacimiento,lblDireccinh,lblTelfono,lblNmeroDeTarjeta ;
		private JButton btnFinalizarCompra;
		private JCheckBox chckbxContrareembolso,chckbxTarjetaDeCrdito;

		
		public VentanaPago(JFrame va) {
			ventanaAnterior=va;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			lblNombre= new JLabel("Nombre");
			lblNombre.setBounds(10, 22, 180, 14);
			contentPane.add(lblNombre);
			
			lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(10, 47, 180, 14);
			contentPane.add(lblApellido);
			
			lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
			lblCorreoElectrnico.setBounds(10, 72, 180, 14);
			contentPane.add(lblCorreoElectrnico);
			
			lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
			lblFechaDeNacimiento.setToolTipText("Fecha de Nacimiento");
			lblFechaDeNacimiento.setBounds(10, 97, 180, 14);
			contentPane.add(lblFechaDeNacimiento);
			
			lblDireccinh = new JLabel("Direcci\u00F3n/Helbidea");
			lblDireccinh.setBounds(10, 122, 180, 14);
			contentPane.add(lblDireccinh);
			
			lblTelfono = new JLabel("Tel\u00E9fono");
			lblTelfono.setBounds(10, 147, 180, 14);
			contentPane.add(lblTelfono);
			
			chckbxContrareembolso = new JCheckBox("Contrareembolso");
			chckbxContrareembolso.setBounds(34, 168, 180, 23);
			contentPane.add(chckbxContrareembolso);
			
			chckbxTarjetaDeCrdito = new JCheckBox("Tarjeta de Cr\u00E9dito");
			chckbxTarjetaDeCrdito.setBounds(222, 168, 180, 23);
			contentPane.add(chckbxTarjetaDeCrdito);
			
			lblNmeroDeTarjeta = new JLabel("N\u00FAmero de tarjeta de cr\u00E9dito");
			lblNmeroDeTarjeta.setBounds(10, 198, 180, 14);
			contentPane.add(lblNmeroDeTarjeta);
			lblNmeroDeTarjeta.setVisible(false);
			
		
			
			
			textField = new JTextField();
			textField.setBounds(189, 19, 161, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(189, 44, 161, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(189, 69, 161, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(189, 94, 161, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(189, 119, 161, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(189, 144, 161, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
			
			txtTarjeta = new JTextField();
			txtTarjeta.setBounds(189, 195, 161, 20);
			contentPane.add(txtTarjeta);
			txtTarjeta.setColumns(10);
			txtTarjeta.setVisible(false);
			
			if (chckbxTarjetaDeCrdito.isSelected())
				lblNmeroDeTarjeta.setVisible(true);
			
			if (chckbxTarjetaDeCrdito.isSelected())
				txtTarjeta.setVisible(true);
			
			btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
			btnFinalizarCompra.setBounds(206, 223, 166, 23);
			contentPane.add(btnFinalizarCompra);
			btnFinalizarCompra.addActionListener(this);
			
			btnVolver = new JButton("VOLVER");
			btnVolver.setBounds(82, 223, 89, 23);
			contentPane.add(btnVolver);
			btnVolver.addActionListener(this);
			setVisible(true);
		
		}


		


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton botonPulsado = (JButton)e.getSource();
			if(botonPulsado ==btnVolver){
				this.dispose();
				ventanaAnterior.setVisible(true);
		}else if(botonPulsado == btnFinalizarCompra){
			this.dispose();
			JOptionPane.showMessageDialog(null, "Compra realizada con éxito", "Muchas gracias por su compra", JOptionPane.INFORMATION_MESSAGE);
		}

			
		}


		}
		
	