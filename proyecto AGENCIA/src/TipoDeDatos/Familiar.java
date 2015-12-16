package TipoDeDatos;

import Utilidades.Utilidades;

/** Clase Familiar.
 * Hereda de coche
 * @author alvaro
 */ 

public class Familiar extends Coche{

	private int plazas;
	private char parachoques;
	
	
	public Familiar(){
		super();
	}
	/** Crea un nuevo vehículo
	 * @param P	Numero de plazas del vehiculo
	 * @param K	Parachoques (SI O NO)
	 */
	  
	public Familiar (String M, String m, String c, float d,  String mat,int a, int n,  int P, char K, String rf){
		super(M, m, c, d, mat, a, n,rf); 
		plazas=P;
		parachoques=K;
	
	}

	/** Devuelve el numero de plazas del coche
	 * @return	numero de plazas del coche
	 */
	public int getPlazas() {
		return plazas;
	}
	/** Cambia el numero de plazas del coche
	 * @param plazas	numero de plazas del coche (numero deberá ser positivo)
	 */
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	/** Devuelve si tiene parachoques o no
	 * @return	parachoques o no
	 */
	public char getParachoques() {
		return parachoques;
	}
	/** Añade o quita el parachoques
	 * @param parachoques	parachoques (Si o No)
	 */
	public void setParachoques(char parachoques) {
		this.parachoques = parachoques;
	}
	/** Metodo desde el cual se leerán los datos insertados por el usuario
	 */
	public void leer(){
		super.leer();
		System.out.println("Introduce el número de plazas para su coche familiar");
		plazas=Utilidades.leerCaracter();
		System.out.println("¿Quiere parachoques en su coche familiar? (S/N)");
		parachoques=Utilidades.leerCaracter();
	
	}
	/** Metodo desde el cual se mostrarán los datos insertados por el usuario
	 */
	public void mostrar (){
		super.mostrar();
		System.out.println("plazas: " +plazas+ ", parachoques: " +parachoques);
	}
	
	public String toString(){
		return super.toString() + "plazas" +plazas+ "parachoques" +parachoques; 
	}
	

	 /** Método de prueba
		 * @param args
		 */
	
}
