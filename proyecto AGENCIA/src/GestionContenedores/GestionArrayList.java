package GestionContenedores;

import java.util.ArrayList;

import TipoDeDatos.*;
/**
 * @author USUARIO
 *Clase gestion arrayList (usuarios)
 */

public class GestionArrayList {	
/**
 * Método para obtener usuario ( si dni ingresado = dni entonces usuario encontrado y será el que obtendremos)
 * @param aUsuarios
 * @param dni
 * @return
 */
 public static Usuario obtenerUsuario(ArrayList<Usuario> aUsuarios,String dni)
	{
		boolean enc=false;
		int pos=0;
		Usuario u=null;
		
		while(!enc && pos<aUsuarios.size())
		{
			u = aUsuarios.get(pos);
			if(u.getDni().equals(dni))
				enc=true;
			else pos++;
		}
		
		if(enc)
			return u;
		else return null;
	}
	/**
	 * Método para buscar usuario (si nombre y contraseña igual a contraseña y nombre ingresado por el usuario entonces usuario encontrado)
	 * @param a
	 * @param nom
	 * @param con
	 * @return
	 */
	public static int buscarPosicionUsuarioEnLista(ArrayList<Usuario> a, String nom, String con)
	{
		boolean enc=false;
		int pos=0,resul=-2;
		while(!enc && pos<a.size())
		{
			Usuario u = a.get(pos);
			if(u.getNom().equalsIgnoreCase(nom) && u.getContrasenia().equals(con))
			{	
				enc=true;
				resul=pos;
			}
			else if(u.getNom().equalsIgnoreCase(nom) && !u.getContrasenia().equals(con))
			{	
				resul=-1;
				enc=true;
			}
			else
				pos++;
		}
		if(enc)
			return resul;
		else
			return -2;
	}
}
