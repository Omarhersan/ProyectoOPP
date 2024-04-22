package backend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
 
public class Docs {
	
	public static void main(String[] args) {
		docProducts();
	}
 
    private static ArrayList<String> docProducts() {
        String filePath = "C:/Users/omara/eclipse-workspace/ProyectoPoo/src/backend/Data/Productos.csv";
        ArrayList<String> lines = new ArrayList<>();
 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); // Agrega cada línea a ArrayList
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
        return lines;
    }
}