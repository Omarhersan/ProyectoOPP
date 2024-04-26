package backend;

public class Producto {
	private int idProducto;
	private String nombreProducto;
	private int cantidadEnInventario;
	private double precio;
	
	public Producto() {
		
	}
	
	public Producto(String nombreProducto,int cantidadEnInventario, double precio) {
		this.nombreProducto = nombreProducto;
		this.cantidadEnInventario = cantidadEnInventario;
		this.precio = precio;
		
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


	@Override
	public String toString() {
		return "Nombre:"+nombreProducto+", precio:"+precio;
	}

}
