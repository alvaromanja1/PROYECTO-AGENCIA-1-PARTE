package TipoDeDatos;

import java.io.Serializable;

/**
 * Clase cliente
 * @author USUARIO
 *
 */
public class Cliente implements Serializable{

	private String dni;
	private String nom;
	private String contrasenia;
	private int edad;
	private String foto;
	
	/** Crea un nuevo cliente
	 * @param dni	dni del cliente
	 * @param nom	nombre del cliente
	 * @param contrasenia contraseña del cliente
	 */
	public Cliente(String dni, String nom, String contrasenia, int edad,String foto ) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.contrasenia = contrasenia;
		this.edad=edad;
		this.foto=foto;
		
	}
	/** Devuelve el dni del cliente
	 * @return	dni 
	 */
	public String getDni() {
		return dni;
	}
	/** Cambia el dni del cliente
	 * @param dni 
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/** Devuelve el nombre del cliente
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/** Cambia el nombre del cliente
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Devuelve la contraseña del cliente
	 * @return	contraseña
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	/** Cambia la contraseña del cliente
	 * @param contraseña
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
}
