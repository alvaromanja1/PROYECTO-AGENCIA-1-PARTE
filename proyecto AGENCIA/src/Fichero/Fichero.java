package Fichero;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;

import TipoDeDatos.*;

public class Fichero {

	public static void crearInforme(LinkedList<Cliente> lClientes){
		PrintWriter pw = null;
		Date d = new Date(System.currentTimeMillis());
		String fecha = String.valueOf(d.getDay()) + "-" + String.valueOf(d.getMonth())+ "-" + String.valueOf(d.getYear());
		String nombreFichero = "Informe_del_"+fecha+ ".txt";
		try {
			pw = new PrintWriter(nombreFichero);
			for(int i=0;i<lClientes.size();i++){
				Cliente c = lClientes.get(i);
				pw.println("DNI: "+c.getDni()+ " NOMBRE: "+c.getNom()+ " EDAD: "+c.getEdad());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
