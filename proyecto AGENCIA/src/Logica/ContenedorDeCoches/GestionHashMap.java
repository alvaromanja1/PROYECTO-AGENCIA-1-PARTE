package Logica.ContenedorDeCoches;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import TipoDeDatos.*;

public class GestionHashMap {

	
	/**
	 * Metodo que sirve para obtener coche por matricula si:
	 * matricula del coche es igual a la variable String matricula
	 * @param hmCliente
	 * @param mat
	 * @return coche
	 */
	public static Coche obtenerCoche(HashMap<String,Coche> hmCliente, String mat){
		Collection <Coche> cCoches= hmCliente.values();
		Iterator<Coche> it =cCoches.iterator();
		Coche c=null;
		boolean enc=false;
		
		while (!enc && it.hasNext()){
			c=it.next();
			if (c.getMat().equals(mat))
				enc=true;
		}
		if (enc)
		return c;
		else 
			return null;
	}
	/**
	 * Metodo que vende coches (empleando el interface vendible) si: 
	 * color del coche es igual a color, el modelo del coche es igual a la variable modelo y la marca es la misma que la variable String
	 * @param mod
	 * @param color
	 * @param marca
	 * @param hmCoches
	 */
	
	public void venderCoche(String mod, String color, String marca , HashMap <String, Coche> hmCoches){
		Collection <Coche> cCoches= hmCoches.values();
		Iterator<Coche> it =cCoches.iterator();
		Coche c=null;
		boolean enc=false;
	
		while (!enc && it.hasNext()){
			c=it.next();
			if (c.getColor().equals(color) && c.getMarca().equals(marca) && c.getModelo().equals(mod))
			enc=true;
			c.vender();
		}
	}
}