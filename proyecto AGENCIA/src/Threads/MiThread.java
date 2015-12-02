package Threads;

import javax.swing.JFrame;
import Ventanas.VentanaLLamada;
import Ventanas.VentanaThread;
/**
 * Clase mithread. Crea un thread procesando justo despues de realizar la llamada
 *
 */



public class MiThread extends Thread{
	JFrame va; 
	public MiThread(JFrame va){
		super();
		this.va=va;
	}
	
	public void run(){
		

		VentanaThread vt = new VentanaThread();
		for(int i=0;i<vt.aLabels.length;i++){
			vt.aLabels[i].setVisible(true);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		vt.dispose();
		//JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "PAGO FINALIZADO",JOptionPane.INFORMATION_MESSAGE);
		new VentanaLLamada(va);
		//new VentanaAdministrador(va);
		//Window[] ventanas = Window.getWindows();
	}

}
