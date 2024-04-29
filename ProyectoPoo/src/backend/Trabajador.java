package backend;

public class Trabajador extends Persona{
	private double saldo;


	public Trabajador(String nombre, int ocupación) {
		// Debe abrir una base de datos
		super(nombre, ocupación);
		
	}
	
	// Debe ser void, pero para debugging será String
	// Se extrae la información de producto desde afuera
	public String Compra(int idProducto, int cantidad,double paga) {
		//El producto se extrae desde inventario
		
		
		double precioProducto = 10.0;
		double totalACobrar = cantidad*precioProducto;
		if (paga-totalACobrar >=0)
			// Modificar el csv de inventario la cantidad
			return super.nombre + " ha pagado totalmente el producto, regresar "
		+ (paga-totalACobrar)+" de cambio";
		
		else {
			// Aquí debería escribir en el csv
			// Modificar en el csv de inventario la cantidad
			this.saldo = (totalACobrar-paga);
			
			return super.nombre + " debe " + this.saldo;
		}
			
		
	}
	
	
	
	

}
