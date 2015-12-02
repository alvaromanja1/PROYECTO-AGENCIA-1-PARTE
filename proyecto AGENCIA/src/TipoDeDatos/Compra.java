package TipoDeDatos;

public class Compra {

	private String dni;
	private String codigo;
	private int unidades;
	private float precioTotal;
	public Compra(String dni, String codigo, int unidades, float precioTotal) {
		super();
		this.dni = dni;
		this.codigo = codigo;
		this.unidades = unidades;
		this.precioTotal = precioTotal;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}