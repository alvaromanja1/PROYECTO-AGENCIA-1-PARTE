package Logica.ListaDeClientes;

import java.util.ArrayList;

import TipoDeDatos.*;

public class GestionArrayList {
/**
 * Método para obtener cliente si el dni es igual a la variable de tipo String denominada dni
 * @param aClientes
 * @param dni
 * @return Cliente 
 */
	public static Cliente obtenerCliente(ArrayList<Cliente> aClientes,String dni)
	{
		boolean enc=false;
		int pos=0;
		Cliente u=null;
		
		while(!enc && pos<aClientes.size())
		{
			u = aClientes.get(pos);
			if(u.getDni().equals(dni))
				enc=true;
			else pos++;
		}
		
		if(enc)
			return u;
		else return null;
	}
	/**
	 * Método que busca la posicion del cliente, lo recorre hasta que el nombre y la contraseña sea igual a las variables nom y con
	 * @param a
	 * @param nom
	 * @param con
	 * @return
	 */
	public static int buscarPosicionClienteEnLista(ArrayList<Cliente> a, String nom, String con)
	{
		boolean enc=false;
		int pos=0,resul=-2;
		while(!enc && pos<a.size())
		{
			Cliente u = a.get(pos);
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
