package GestionContenedores;

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



import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import TipoDeDatos.*;



public class GestionFicheros {
	/**
	 * Fichero con los usuarios del arraylist
	 * @return
	 */

	
	public static ArrayList<Usuario> obtenerListaUsuarios()
	{
		ObjectInputStream ois=null;
		ArrayList<Usuario> a=new ArrayList<Usuario>();
		File f = new File("USUARIOS2015.DAT");
		if(f.exists())
		{
			try {
				ois = new ObjectInputStream(new FileInputStream("USUARIOS2015.DAT"));
				Usuario u = (Usuario) ois.readObject();
				while(u!=null)
				{
					a.add(u);
					u = (Usuario) ois.readObject();
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
	 * Obtener hash map de usuarios (dni, usuario ó cliente)
	 * @return
	 */
	public static HashMap<String,Usuario> obtenerHashMapUsuarios()
	{

		HashMap<String,Usuario> hmUsuarios = new HashMap<String,Usuario>();
	
		File f = new File("USUARIOS2015.DAT");
		if(f.exists())
		{
			FileInputStream fis;
			try {
				fis = new FileInputStream("USUARIOS2015.DAT");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Usuario u = (Usuario) ois.readObject();
				while(u!=null)
				{
					hmUsuarios.put(u.getDni(), u);
					u = (Usuario) ois.readObject();
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
		
		return hmUsuarios;
		
	}
	/**
	 * Recorrer el array y mover del arrayList a fichero
	 * @param a
	 */
	public static void volcarListaAFichero(ArrayList<Usuario> a)
	{
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream("USUARIOS2015.DAT"));
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
	/**
	 * Recorre el hash map y mover de él a un fichero llamado usuarios2015.dat
	 * @param hmUsuarios
	 */
	
	public static void volcarHashMapAFichero(HashMap<String,Usuario> hmUsuarios)
	{
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream("USUARIOS2015.DAT"));
			Collection<Usuario> cUsuarios = hmUsuarios.values();
			Iterator<Usuario> it = cUsuarios.iterator();
			
			while(it.hasNext())
			{
				Usuario u = it.next();
				oos.writeObject(u);
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
	 * insertar usuario a fichero
	 * @param u
	 */
	public static void insertarUsuario(Usuario u)
	{
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("USUARIOS.DAT"));
			oos.writeObject(u);
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
	 * Método que comprueba si el usuario (nombre y contraseña) está repetido o es nuevo
	 * Usuario repetido si:
	 * contraseña y nombre ya existen
	 * @param nom
	 * @param con
	 * @return
	 */
	public static Usuario existeUsuario(String nom, String con)
	{
		boolean enc=false;
		Usuario aux=null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("USUARIOS.DAT"));
			aux = (Usuario)ois.readObject();
			while(!enc && aux!=null)
			{
				if(nom.equalsIgnoreCase(aux.getNom()) && con.equals(aux.getContrasenia()))
					enc=true;
				else
					aux=(Usuario)ois.readObject();
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
	
	
	
}
