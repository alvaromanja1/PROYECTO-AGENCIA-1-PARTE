package Excepciones;

/**
 * 
 * Este método lanza una excepción por cada usuario que esté repetido
 * @author alvaro
 *
 */
public class ClienteRepetidoException extends Exception{
	private String mensaje;
public ClienteRepetidoException (String m){
	super();
	mensaje=m;
	
}
public String toString (){
	return mensaje;
}
}


