package backend;

import java.io.BufferedReader;
import javax.swing.JTextField;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Usuarios extends Persona {
	String username;
	String password;
	
	
	protected HashMap<Integer, Persona> users = new HashMap<>();

	
	public Usuarios() {
		parseCSV("C:\\Users\\omara\\Documents\\Proyecto_OPP\\ProyectoPoo\\src\\backend\\Data\\users.csv");
	}
	
	// Extraer nombre y ocupación de los csv
	public Usuarios(String nombre, int ocupación, String password) {
		super(nombre, ocupación);
		this.username = nombre;
		this.password = password;
		
	}
	public void parseCSV(String filePath) {
		String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	
            while ((line = br.readLine()) != null) {
                String[] user = line.split(cvsSplitBy);
                // item[0] es el id. Podría ser int o String
                if(user[0].endsWith("1"))
                	user[0] = user[0].substring(1);
               int ocupacion;
                if(user[2] == "0")
                	ocupacion = Persona.TRABAJADOR;
                else if(user[2] == "1")
                	ocupacion = Persona.ENCARGADO;
                else if(user[2] == "2")
                	ocupacion = Persona.CLIENTE;
                else if(user[2] == "3")
                	ocupacion = Persona.ADMINISTRADOR;
                else
                	ocupacion = Persona.NOT_DEFINED;
                users.put(Integer.parseInt(user[0]), new Usuarios(user[1], ocupacion, user[3]));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
	public boolean LogIn(JTextField username,JTextField password) {
		if(this.username == username.getText() && this.password == password.getText()) {
			System.out.println("Fue correcto");
			return true;
		}
		else
			System.out.println(this.username);
			return false;
	}
	
}
		