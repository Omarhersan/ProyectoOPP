package backend;

public abstract class Persona {
	protected String nombre;
	private int id;
	protected int ocupación = Persona.CLIENTE;
	
	public static final int TRABAJADOR = 0;
	public static final int ENCARGADO = 1;
	public static final int CLIENTE = 2;
	public static final int ADMINISTRADOR = 3;
	public static final int NOT_DEFINED = 4;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int ocupación) {
		this.nombre = nombre;
		setOcupación(ocupación);
		
	}
	public void setOcupación(int ocupación) {
		this.ocupación = ocupación;
	}
}
