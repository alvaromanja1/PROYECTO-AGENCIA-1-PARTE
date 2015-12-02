package Logica.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import TipoDeDatos.*;

public class GestionHashMap {

	public static Cliente obtenerCliente(HashMap<String,Cliente> hmCliente, String dni)
	{
		Collection<Cliente> cClientes = hmCliente.values();
		Iterator<Cliente> it = cClientes.iterator();
		Cliente u=null;
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
