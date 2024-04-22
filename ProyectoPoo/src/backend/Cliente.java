package backend;

public class Cliente extends Persona{
	static String nombre = "NA";
	static int ocupación = Persona.CLIENTE;

	public Cliente() {
		super(nombre, ocupación);
		
	}
	public String compra(int idProducto,int cantidad, double pago) {
		// Extraído de la db
		double precioProducto = 10.0;
		double totalACobrar = cantidad*precioProducto;
		
		
		if(pago-totalACobrar >= 0)
			// Retirar cantidad de inventario
			return "Regresar "+(pago-totalACobrar)+ " de cambio";
		else
			return "No se ha pagado completo";
	}

}
