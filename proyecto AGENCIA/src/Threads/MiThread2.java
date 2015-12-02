package Threads;

import Ventanas.*;

public class MiThread2 extends Thread {
	
	public MiThread2(){
		super();
	}
	
	public void run(){
		
		while(true){
			VentanaCliente.lblNombre.setVisible(false);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VentanaCliente.lblNombre.setVisible(true);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}


