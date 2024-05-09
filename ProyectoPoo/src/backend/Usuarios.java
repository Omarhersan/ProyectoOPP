package backend;

import java.io.BufferedReader;
import javax.swing.JTextField;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Usuarios extends Persona {
	private String username;
	private String password;
	
	
	protected HashMap<String, Usuarios> users = new HashMap<>();

	
	public Usuarios() {
		parseCSV("C:\\Users\\sarim\\Documents\\6to semestre\\Proyecto\\ProyectoOPP\\ProyectoPoo\\src\\backend\\Data\\users.csv");
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
                users.put(user[1], new Usuarios(user[1], ocupacion, user[3]));
                
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
	public boolean LogIn(JTextField username,JTextField password) {
		if(this.getUsername().equals(username.getText())&& this.getPassword().equals(password.getText())) {
			return true;
		}
		else
			System.out.println();
			return false;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public HashMap<String, Usuarios> getUsers(){
		return this.users;
	}
}
		