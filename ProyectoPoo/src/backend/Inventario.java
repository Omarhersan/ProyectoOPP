package backend;

import java.io.*;
import java.util.*;


class Inventario {
    HashMap<Integer,Producto> items;

    public Inventario() {
        items = new HashMap<>();
    }

    public void parseCSV(String csvFile) {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] item = line.split(cvsSplitBy);
                // item[0] es el id. Podría ser int o String
                items.put(Integer.parseInt(item[0]), new Producto(item[1], Integer.parseInt(item[2]), Double.parseDouble(item[3])));
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
    	if(items.containsKey(idProducto)) {
    		Producto aModificar = items.get(idProducto);
    		aModificar.setCantidadEnInventario(cantidad);
    	}
    }

    public void nuevo(){
        
    }
    
}