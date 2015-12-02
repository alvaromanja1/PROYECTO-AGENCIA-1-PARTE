package Logica.ArrayList;

import java.util.ArrayList;

import TipoDeDatos.*;

/**
 * Clase GestionArrayList en donde estan aquellos metodos que trabajan con arrays
 */
public class GestionArrayList {

	/**
	 *Metodo de tipo Cliente que recibe por parametro el ArrayList de Clientes y el String de dni
	 *Devuelve el Cliente si se ha encontrado y devuelve null si no se ha encontrado
	 * 
	 * @param aClientes ArrayList de Clientes 
	 * @param dni El dni del Cliente
	 * @return Cliente
	 */
	public static Cliente obtenerCliente(ArrayList<Cliente> aClientes,String dni)
	{
		//Inicamos estos parametros de esta manera para buscar el Cliente, como todavia no hemos empezado a buscarlo no lo habremos encontrado
		//Por eso iniciamos asi estos atributos 
		
		boolean enc=false;//Atributo enc que indica si hemos encotrado o no el Cliente
		                  //Se inica a false porque todavia no hemos empezado a buscar el Cliente
		
		int pos=0;//Atributo pos nos indica la posicion del ArrayList por el que vamos
                  //Se inicia a 0 porque todavia no hemos recorrido el ArrayList al no haber empezado a buscar el Cliente
		
		Cliente u=null;//Atributo u que nos indica cuál es el Cliente 
		               //El Cliente lo inicializamos a null ya que no hemos empezado a buscar nada todavía
		
		
		//Para empezar a buscar el Cliente utilizamos un while.
		//Mientras no se haya encontrado el Cliente y la posicion en el ArrayList sea menor al tamaño del ArrayList de Clientes hay que continuar buscando
		
		while(!enc && pos<aClientes.size())
		{
			u = aClientes.get(pos);//Metemos en el Cliente u, al principio inicializado a null,el Cliente que se encuentra en una posicion del ArrayList
			                       //La posicion al principio se había inicializado a 0 y es desde donde se empieza a buscar el Cliente
                                   //Guardamos en u el Cliente que hay en la posicion del ArrayList<Clientes>			
			                       //Para la primera ejecucion se cogera el Cliente que esta en la posicion 0 del ArrayList
 			
			if(u.getDni().equals(dni))//Con este if lo que hacemos es comprobar si el dni que hemos metido por parámetro es igual al dni del Cliente u
				                      //Recordemos que en Cliente u habiamos cogido el Cliente que se encontraba en el ArrayList en la posicion 0, si es la primera vez que se ejecuta 
				                      
				enc=true;             //Por lo tanto, si el dni que habiamos metido por parametro es igual al dni que hemos obtenido desde el ArrayList de Clientes guardandolo en la variable Cliente u
			                          //Decimos que hemos encontrado el Cliente ya que ambos tienen el mismo dni.
			                          //Por ello ponemos la variable enc a true ya que lo hemos encontrado
			
			else pos++;               //Si no lo hemos encontrado le sumamos uno a la variable pos, para que vaya avanzando y comprobando de uno en uno.
		}
		
		if(enc)                       //Si hemos encontrado el Cliente
			return u;                 //Devolvemos el Cliente
		else return null;             //Sino devolvemos null, ya que no habríamos encontrado ningún Cliente
	}
	
	/**
	 * Método de tipo entero que recibe por parametro el ArrayList de Clientes, el String nombre(Nombre del Cliente) y el String contraseña(contraseña del Cliente)
	 * Devuelve un entero resul(-2-> si no se ha encontrado el Cliente, -1 ->si coincide el nombre de Cliente pero la contraseña no ,
	 * Si coincide el nombre y la contraseña de Cliente , devuelve la posicion del ArrayList en la cual se ha encontrado el Cliente)
	 * 
	 * @param a ArrayList de Cliente
	 * @param nom Nombre del Cliente
	 * @param con Contraseña del Cliente
	 * @return resul
	 */
	public static int buscarPosicionClienteEnLista(ArrayList<Cliente> a, String nom, String con)
	{
		//Inicamos estos parametros de esta manera para buscar el Cliente, como todavia no hemos empezado a buscarlo no lo habremos encontrado
		//Por eso iniciamos asi estos atributos 
		
		boolean enc=false;//Atributo enc que indica si hemos encotrado o no el Cliente
                          //Se inica a false porque todavia no hemos empezado a buscar el Cliente, por lo tanto no lo habremos encontrado
		
		int pos=0,resul=-2;//Atributo pos nos indica la posicion del ArrayList por el que vamos
                           //Se inicia a 0 porque todavia no hemos recorrido el ArrayList al no haber empezado a buscar el Cliente
		
		                   //Atributo resul(variable que devuelve el metodo y dependiendo del numero que nos devuelva nos indica una cosa u otra
		                   //Se inicializa a -2. Al ser resul -2, sabemos que no se ha encontrado el Cliente, normal ya que no hemos empezado a buscarlo
		
		//Para empezar a buscar el Cliente utilizamos un while
		//Mientras no se haya encontrado el Cliente y la posicion en el ArrayList sea menor al tamaño del ArrayList de Clientes hay que seguir buscando el Cliente que queremos encontrar
		while(!enc && pos<a.size())
		{
			Cliente u = a.get(pos);//Metemos en el Cliente u, al principio inicializado a null,el Cliente que se encuentra en una posicion del ArrayList<Clientes>
                                   //La posicion al principio se había inicializado a 0 y es desde donde se empieza a buscar el Cliente
			                       //Guardamos en u el Cliente que hay en la posicion del ArrayList<Clientes>			
                                   //Para la primera ejecucion se cogera el Cliente que esta en la posicion 0 del ArrayList

		
			if(u.getNom().equalsIgnoreCase(nom) && u.getContrasenia().equals(con))//Con este if lo que hacemos es comprobar si el nombre y la contraseña del Cliente que hemos metido por parámetro es igual al dni y la contraseña que hemos guardado en la variable Cliente u
			{	                                                                  //El método Ignorecase() compara la cadena de texto con un objeto ignorando mayúsculas y minúsculas. Devolverá true si las cadenas comparadas son iguales. En caso contrario devolverá false. 
				
				enc=true;                                                         //En el caso de que el dni y la contraseña coincidan la variable enc se pondra a true, lo cual indica que ya hemos encontrado el Cliente 
				resul=pos;                                                        //Y guardamos en resul la ultima posicion que hemos mirado en el ArrayList, esa sera la posicion en la que el nombre y la contraseña coincidan con los valores metidos por parametro
			}
			else if(u.getNom().equalsIgnoreCase(nom) && !u.getContrasenia().equals(con)) //Si no se ha encontrado el Cliente,pero coincide el nombre de Cliente, es decir que el nombre metido por parametro es igual que el que se ha guardado en la variable Cliente u 
			{	                                                                         //Y la contraseña no coincide
				resul=-1;                                                                //Entonces ponemos resul a -1(número que nos indica que coincide el nombre pero no la contraseña)
				enc=true;                                                                //Y ponemos enc a true, dando a entender que el Cliente se ha encontrado pero no coincide la contraseña
			}
			else                                                                         // Si no coincide ni el nombre ni la contraseña sumamos 1 a la variable pos ,  para que vaya avanzando y comprobando de uno en uno.
				pos++;
		}
		if(enc)                                                                   //Si se ha encontrado el Cliente, entonces devolvemos resul
	                    		                                                  //El resul será o -1(coincide el nombre pero no la contraseña) o la posicion del ArrayList(coincide nombre y contraseña)
			return resul;                                                         
		else
			return -2;                                                            //Si no se ha encontrado el Cliente devolvemos el número -2,que era así como habíamos inicializado la vaaariable resul.
		                                                                          //Indicando de tal manera que no coinciden ni nombre ni contraseña
	}
}
