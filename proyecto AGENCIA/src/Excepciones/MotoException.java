package Excepciones;

public class MotoException extends Exception {
	private String mensaje;
public MotoException (String m){
	super();
	mensaje=m;
	
}
public String toString (){
	return mensaje;
}
}


