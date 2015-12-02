package Excepciones;

public class CocheException extends Exception {
	private String mensaje;
public CocheException (String m){
	super();
	mensaje=m;
	
}
public String toString (){
	return mensaje;
}
}
