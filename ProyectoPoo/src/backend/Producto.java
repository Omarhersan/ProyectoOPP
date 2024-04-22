package backend;

public class Producto {
	private int idProducto;
	private String nombreProducto;
	private int cantidadEnInventario;
	private double precio;
	private double costo;
	
	public Producto() {
		
	}
	
	public Producto(String nombreProducto,int cantidadEnInventario, double precio, double costo) {
		this.nombreProducto = nombreProducto;
		this.cantidadEnInventario = cantidadEnInventario;
		this.precio = precio;
		this.costo = costo;
	}
	
	
	// Todos los sets deberían escribir en los csv
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidadEnInventario() {
		return cantidadEnInventario;
	}

	public void setCantidadEnInventario(int cantidadEnInventario) {
		this.cantidadEnInventario = cantidadEnInventario;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Nombre:"+nombreProducto+", precio:"+precio;
	}

}
