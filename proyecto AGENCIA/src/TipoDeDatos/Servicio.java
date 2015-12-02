package TipoDeDatos;

public class Servicio {
	protected  int cod;
	protected String foto;
	protected double precio;
	
	
	
   public Servicio(int cod, String foto, double precio) {
		super();
		this.cod = cod;
		this.foto = foto;
		this.precio = precio;
	}
public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Servicio [cod=" + cod + ", ruta=" + foto+ ", precio=" + precio
				+ "]";
	}
	
	
}
