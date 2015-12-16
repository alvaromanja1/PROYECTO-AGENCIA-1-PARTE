package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



import TipoDeDatos.*;

public class BD {
	private Connection connection;
	private Statement stmt;
	
	public BD()
	{
		conectar();
	}
	
	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Agencia1.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	public void desconectar()
	{
		try {
			cerrarSentencia();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crearSentencia()
	{
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existeCliente(String d){
		
		boolean existe=false;
		
		String s = "SELECT * FROM cliente WHERE dni='"+d+"'";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(s);
			
			if(rs.next())
				existe=true;
			rs.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existe;
	}
	
	public void insertarCliente(String d, String n){
		String s = "INSERT INTO cliente(dni,nom,contrasenia) VALUES ('"+d+"','"+n+"')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public boolean existeViaje(int cod,String origen, String destino, float precio,int numplazas, String foto){
		String s = "SELECT * FROM viaje WHERE cod="+cod+" AND origen='"+origen+"' AND destino='"+destino+"' AND precio="+precio+" AND numplazas="+numplazas+" AND foto='"+foto+"'" ;
		ResultSet rs;
		boolean resul=false;
		try {
			rs = stmt.executeQuery(s);
			if(rs.next())
				resul=true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resul;
	}
	
	public boolean existeVehiculos(String color,String marca,String modelo,float precio,String matricula,String foto){
		String s = "SELECT * FROM vehiculo WHERE color='"+color+"' AND marca='"+marca+"' AND modelo='"+modelo+"' AND precio="+precio+" AND matricula='"+matricula+"' AND foto='"+foto+"'" ;
		ResultSet rs;
		boolean resul=false;
		try {
			rs = stmt.executeQuery(s);
			if(rs.next())
				resul=true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resul;
	}

	public Cliente obtenerCliente(String d){
		Cliente c = null;
		
		String s = "SELECT * FROM Cliente WHERE dni='"+d+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				c = new Cliente(rs.getString("dni"), rs.getString("nom"),rs.getString("contrasenia"),/* rs.getInt("edad")*/0,rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public LinkedList<String> obtenerRutasFotos(){
		String s = "SELECT foto FROM viaje";
		LinkedList<String> lFotos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lFotos.add(rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lFotos;
	}
	
	public LinkedList<String> obtenerRutasFotosVehiculo(String marca, String modelo){
		String s = "SELECT foto FROM vehiculo WHERE marca='"+marca+"' AND modelo='"+modelo+"'";
		LinkedList<String> lFotos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lFotos.add(rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lFotos;
	}
	
	public LinkedList<Cliente> obtenerClientes(){
		String s= "SELECT * FROM cliente WHERE dni <> '***'";
		LinkedList<Cliente> lClientes = new LinkedList<Cliente>();
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				Cliente a  = new Cliente(rs.getString("dni"), rs.getString("nom"),rs.getString("contrasenia"), rs.getInt("edad"),rs.getString("foto"));
				lClientes.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lClientes;
	}
	
	public Cliente obtenerClientes(String foto){
		String s = "SELECT * FROM cliente WHERE foto='"+foto+"'";
		ResultSet rs;
		Cliente c = null;
		try {
			rs = stmt.executeQuery(s);
			c = new Cliente(rs.getString("dni"),rs.getString("nom"),rs.getString("contrasenia"),rs.getInt("edad"),rs.getString("foto"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	public boolean existeVehiculo(String matricula){
		boolean existe=false;
		String s = "SELECT * FROM vehiculo WHERE matricula='"+matricula+"'";
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next())
				existe=true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return existe;
	}
	
	public void insertarVehiculo(String color, String marca, String modelo,float precio, String matricula,String foto ){
		
		String s = "INSERT INTO vehiculo(matricula,modelo,marca,color,precio,foto) VALUES('"+matricula+"','"+modelo+"','"+marca+"','"+color+"',"+precio+",'"+foto+"')";
		
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarViaje(int cod, String origen, String destino, double precio, int numplazas, String foto){
		
		String s="INSERT INTO viaje (cod,origen,destino,precio,numplazas,foto) VALUES ("+cod+",'"+origen+"','"+destino+"',"+precio+","+numplazas+",'"+foto+"')";
		
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Vehiculo obtenerVehiculo(String foto){
		String s = "SELECT * FROM vehiculo WHERE foto='"+foto+"'";
		ResultSet rs;
		Vehiculo l = null;
		try {
			rs = stmt.executeQuery(s);
			l = new Vehiculo(rs.getString("marca"),rs.getString("modelo"),rs.getString("color"),rs.getFloat("precio"),rs.getString("matricula"),rs.getString("foto"));
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public LinkedList<Viajes> obtenerViajes(){
		LinkedList<Viajes> lViajes = new LinkedList<Viajes>();
		
		String s = "SELECT * FROM viaje";
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				int cod = rs.getInt("cod");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				double precio= rs.getDouble("precio");
				int numplazas= rs.getInt("numplazas");
				String foto = rs.getString("foto");
				lViajes.add(new Viajes(cod,foto,precio,origen,destino,numplazas));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lViajes;
	}
	
	public Viajes obtenerViaje(String foto){
		String s = "SELECT * FROM viaje WHERE foto='"+foto+"'";
		ResultSet rs;
		Viajes v = null;
		try {
			rs = stmt.executeQuery(s);
			v = new Viajes(rs.getInt("cod"),rs.getString("foto"),rs.getFloat("precio"),rs.getString("origen"),rs.getString("destino"),rs.getInt("numplazas"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}
	
	public void eliminarViaje(int cod){
		String s = "DELETE FROM viaje WHERE cod="+cod;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarCompra(LinkedList<Compra> carrito){
		
		for(int i=0;i<carrito.size();i++){
			Compra c = carrito.get(i);
			String s = "INSERT INTO compra(dni,codigo,unidades,precioTotal) VALUES('" + c.getDni() +"','" + c.getCodigo()+ "',"+ c.getUnidades()+","+ c.getPrecioTotal()+")";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public LinkedList<String> obtenerMarcas(){
		String s= "SELECT DISTINCT(marca) FROM vehiculo";
		LinkedList<String> marcas = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				String m = rs.getString("marca");
				marcas.add(m);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marcas;
	}
	public LinkedList<String> obtenerModelos(String marca){
		String s= "SELECT DISTINCT(modelo) FROM vehiculo WHERE marca='"+marca+"'";
		LinkedList<String> modelos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				String m = rs.getString("modelo");
				modelos.add(m);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelos;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	
	
	
	
	
	
	

