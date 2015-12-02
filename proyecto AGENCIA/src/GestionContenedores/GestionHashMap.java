package GestionContenedores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import TipoDeDatos.*;
public class GestionHashMap {
/**
 * Metodo que dado un hashMap de usuarios se recorrerá y se obtendrá el usuario si: 
 * dni=dni insertado por el usuario
 * @param hmUsuario
 * @param dni
 * @return
 */
	public static Usuario obtenerUsuario(HashMap<String,Usuario> hmUsuario, String dni)
	{
		Collection<Usuario> cUsuarios = hmUsuario.values();
		Iterator<Usuario> it = cUsuarios.iterator();
		Usuario u=null;
		boolean enc=false;
		
		while(!enc && it.hasNext())
		{
			u=it.next();
			if(u.getDni().equals(dni))
				enc=true;
		}
		
		if(enc)
			return u;
		else
			return null;
	}
}
