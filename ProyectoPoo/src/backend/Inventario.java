package backend;

import java.io.*;
import java.util.*;


public class Inventario {
    private HashMap<Integer, Producto> items;

    
    public Inventario() {
        items = new HashMap<Integer, Producto>();
        //parseCSV("C:\\Users\\sarim\\Documents\\6to semestre\\Proyecto\\ProyectoOPP\\ProyectoPoo\\src\\backend\\Data\\Productos.csv");
        parseCSV("C:\\Users\\omara\\Documents\\Proyecto_OPP\\ProyectoPoo\\src\\backend\\Data\\Productos.csv");

    }

    public void parseCSV(String csvFile) {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
            while ((line = br.readLine()) != null) {
                String[] item = line.split(cvsSplitBy);
                // item[0] es el id. Podría ser int o String
                if(item[0].endsWith("1"))
                	item[0] = item[0].substring(1);
                items.put(Integer.parseInt(item[0]), new Producto(item[1],
                		Integer.parseInt(item[2]),Double.parseDouble(item[3])));
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addItem(int idProducto, String nombre, int cantidad, double precio) {
    	if (!items.containsKey(idProducto))
    		items.put(idProducto, new Producto(nombre, cantidad, precio));
    }

    public void removeItem(int idProducto) {
    	if (items.containsKey(idProducto))
    		items.remove(idProducto);
    }

    public void updateItem(int idProducto, int cantidad) {
    	// No debe haber cantidades negativas
    	// Cada cuanto sobreescribir la db??
    	if(items.containsKey(idProducto)) {
    		Producto aModificar = items.get(idProducto);
    		aModificar.setCantidadEnInventario(cantidad);
    	}
    }
  

    public Producto getItem(int idProducto){
    	return items.get(idProducto);
    }
    public HashMap<Integer, Producto> getItems(){
    	return this.items;
    }
    
}




