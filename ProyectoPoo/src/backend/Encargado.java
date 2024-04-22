package backend;

public class Encargado extends Persona {
	private String username;
	private String password;

	
	// Extraer nombre y ocupación de los csv
	public Encargado(String nombre, int ocupación) {
		super(nombre, ocupación);
		
	}
	public String LogIn(String username,String password) {
		if(this.username == username && this.password == password)
			return "Acceso permitido";
		else
			return "Acceso no permitido";
	}

}
