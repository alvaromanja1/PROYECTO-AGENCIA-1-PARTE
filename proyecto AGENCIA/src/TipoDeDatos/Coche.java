package TipoDeDatos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import Interfaces.Vendible;
import Utilidades.Utilidades;




/** Clase coche.
 * De esta heredarán la clase deportivo y familiar
 * @author alvaro
 */ 


public class Coche extends Vehiculo implements Comparable ,Vendible {

	protected int año;
	protected int numPuertas;
	public Coche(){
		super();	
	}

	/** Crea un nuevo vehículo
	 * @param a	año del vehiculo
	 * @param n	numero de puertas del vehiculo
	 */
	
	public Coche(String M, String m, String c, float d,  String mat, int a, int n,String rf){
		super(M,m,c,d,mat,rf);
		año=a;
		numPuertas=n;
	}
	/** Devuelve el año del coche
	 * @return	año del coche
	 */
	public int getAño() {
		return año;
	}
	/** Cambia el año del coche
	 * @param año  año del coche (siempre positivo)
	 */
	public void setAño(int año) {
		this.año = año;
	}
	/** Devuelve el numero de puertas del coche
	 * @return	numero de puertas del coche
	 */
	public int getNumPuertas() {
		return numPuertas;
	}
	/** Cambia el numero de puertas del cocche
	 * @param numpuertas numero de puertas del coche (numero positivo, o 2 o 4)
	 */
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}


	/** Metodo desde el cual se leerán los datos insertados por el usuario
	 */
	public void leer(){
		super.leer();
		System.out.println("Introduzca el año del coche: ");
		año=Utilidades.leerEntero();
		System.out.println("Introduzca el numero de puertas del coche (3 ó 5)");
		numPuertas=Utilidades.leerEntero();

	}
	/** Metodo desde el cual se mostrarán los datos insertados por el usuario
	 */
	public void mostrar(){
		super.mostrar();
		System.out.println("Año: "+año+ "numero de puertas: " +numPuertas);
	}
	public String toString(){
		return super.toString() + "año" +año+ "numero de puertas " +numPuertas;
	}

	/** Método compareTo, este método compara dos marcas y así devolver 1, -1 o 0.
	 * Devolverá 0 si: ambas marcas son iguales
	 * Devolverá 1 si: marca.compareTo(((Coche)obj).marca)>0
	 * Devolverá -1 si: marca.compareTo(((Coche)obj).marca)<0
	 * @param args
	 */
	@Override
	public int compareTo(Object obj) {
		//COMPARAR POR MARCA 
		// TODO Auto-generated method stub
		int resul=0;
		if (marca.compareTo(((Coche)obj).marca)<0)
			resul=-1;
		else if (marca.compareTo(((Coche)obj).marca)>0)
			resul=1;
		else 
			resul=0;
		return resul;
	}



	@Override
	public void vender() {
		// TODO Auto-generated method stub

	}


}
