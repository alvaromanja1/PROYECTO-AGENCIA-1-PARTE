package TipoDeDatos;

import java.util.Date;

public class Viajes extends Servicio {

	private int numPlazas;
	private String origen;
	private String destino;
	
	public int getNumPlazas() {
		return numPlazas;
	}
	
	
	
	public Viajes(int cod, String foto, double precio,String origen, String destino, int numPlazas) {
		super(cod, foto, precio);
		this.numPlazas = numPlazas;
		this.origen = origen;
		this.destino=destino;
	}



	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}



	@Override
	public String toString() {
		return "Origen=" + origen + ", destino=" + destino + ", Precio=" + getPrecio();
	}
	
	
	
	
}