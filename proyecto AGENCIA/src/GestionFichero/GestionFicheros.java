package GestionFichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import TipoDeDatos.*;










public class GestionFicheros {

	/**
	 * Metodo que devuelve el array de clientes, clientes del fichero llamado (Clientes2015.dat) 
	 * @return arrayList de cientes
	 */
	public static ArrayList<Cliente> obtenerListaClientes()
	{
		ObjectInputStream ois=null;
		ArrayList<Cliente> a=new ArrayList<Cliente>();
		File f = new File("ClienteS2015.DAT");
		if(f.exists())
		{
			try {
				ois = new ObjectInputStream(new FileInputStream("ClienteS2015.DAT"));
				Cliente u = (Cliente) ois.readObject();
				while(u!=null)
				{
					a.add(u);
					u = (Cliente) ois.readObject();
				}
				ois.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return a;
	}

	/**
	 * Metodo para introducir en fichero denominado (Clientes2015.dat) los clientes del arrayList de clientes
	 */
	public static void volcarListaAFichero(ArrayList<Cliente> a)
	{
		ObjectOutputStream oos=null;

		try {
			oos=new ObjectOutputStream(new FileOutputStream("ClienteS2015.DAT"));
			for(int i=0;i<a.size();i++)
				oos.writeObject(a.get(i));
			oos.writeObject(null);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	

	/**Metodo que verifica si el cliente ya existe
	 * Un cliente está repetido si: 
	 * contraseña y nombre ya existen
	 * @param nom
	 * @param con
	 * @return Cliente
	 */
	public static Cliente existeCliente(String nom, String con)
	{
		boolean enc=false;
		Cliente aux=null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ClienteS.DAT"));
			aux = (Cliente)ois.readObject();
			while(!enc && aux!=null)
			{
				if(nom.equalsIgnoreCase(aux.getNom()) && con.equals(aux.getContrasenia()))
					enc=true;
				else
					aux=(Cliente)ois.readObject();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(enc)
			return aux;
		else
			return null;
	}


/**
 * Metodo que obtiene un hashMap de coches, los cuales serán extraidos del fichero (coches2015.DAT) 
 * @return hashMap de coches
 */
	public static HashMap<String,Coche> obtenerHasMapCoche()
	{
		HashMap<String,Coche> hmCoches = new HashMap<String,Coche>();
		File f = new File("Coches2015.DAT");
		if(f.exists())
		{
			FileInputStream fis;
			try {
				fis = new FileInputStream("Coches2015.DAT");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Coche c = (Coche) ois.readObject();
				while(c!=null)
				{
					hmCoches.put(c.getMat(), c);
					c = (Coche) ois.readObject();
				}
				ois.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return hmCoches;

	}
	/**
	 * Méto que dado un hashMap de coches, este será recorrido y así volcarlo a un fichero llamado (Coches2015.DAT)
	 * @param hmCoches
	 */
	public static void volcarListaAFichero(HashMap<String,Coche> hmCoches)
	{
		ObjectOutputStream oos=null;

		try {
			oos=new ObjectOutputStream(new FileOutputStream("Coches2015.DAT"));
			Collection<Coche> cCoches= hmCoches.values();
			Iterator <Coche> it= cCoches.iterator();
			while(it.hasNext()){
				Coche coche=it.next();
				oos.writeObject(coche);
			}

			oos.writeObject(null);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
/**
 * Metodo que obtiene un treeMap de motos, los cuales serán extraidos del fichero (MOTOS2015.DAT) 
 * @return treeMap de motos
 */
	public static TreeMap<String,Moto> obtenerTreeMapMotos()
	{
		TreeMap<String,Moto> tmMotos = new TreeMap<String,Moto>();
		File f = new File("Motos2015.DAT");
		if(f.exists())
		{
			FileInputStream fis;
			try {
				fis = new FileInputStream("Motos2015.DAT");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Moto m= (Moto) ois.readObject();
				while(m!=null)
				{
					tmMotos.put(m.getMatricula(), m);
					m = (Moto) ois.readObject();
				}
				ois.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return tmMotos;

	}

/**
 * Méto que dado un treeMap de motos, este será recorrido y así volcarlo a un fichero llamado (MOTOS2015.DAT)
 * @param tmMotos
 */
	public static void volcarListaAFichero(TreeMap<String,Moto> tmMotos)
	{
		ObjectOutputStream oos=null;

		try {
			oos=new ObjectOutputStream(new FileOutputStream("Motos2015.DAT"));
			Collection <Moto> c= tmMotos.values();
			Iterator <Moto>it=c.iterator();
			while(it.hasNext()){
				Moto m= it.next();
				oos.writeObject(m);		
			}

			oos.writeObject(null);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void obtenerRutas(ArrayList<String> aRutas) {
		// TODO Auto-generated method stub

	}


}
	