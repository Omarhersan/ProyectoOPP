package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PagosPendientes {
    private List<PPendiente> pendientes;
    //String dPendientes = "C:\\Users\\sarim\\Documents\\6to semestre\\Proyecto\\ProyectoOPP\\ProyectoPoo\\src\\backend\\Data\\PagosP.csv";
    String dPendientes = "C:\\Users\\omara\\Documents\\Proyecto_OPP\\ProyectoPoo\\src\\backend\\Data\\PagosP.csv";
    
    public PagosPendientes() {
    	
    }
    
    public List<PPendiente> lecPendientes() {
        pendientes = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(dPendientes))) {

            while ((line = br.readLine()) != null) {
                String[] pendiente = line.split(cvsSplitBy);
                pendientes.add(new PPendiente(pendiente[0], Double.parseDouble(pendiente[1])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pendientes;
    }

    public void actualizarMasDeuda(String nombre, double total) {
        if (validarNombre(nombre)){
            for (PPendiente pendiente : pendientes) {
                if (pendiente.getNombre().equals(nombre)) {
                    pendiente.setMasDeuda(total);
                    break;
                }
            }
        }
    }

    public void actualizarMenosDeuda(String nombre, double total) {
        if (validarNombre(nombre)){
            for (PPendiente pendiente : pendientes) {
                if (pendiente.getNombre().equals(nombre)) {
                    pendiente.setMenosDeuda(total);
                    break;
                }
            }
        }
    }

    public boolean validarNombre(String nombre) {
        for (PPendiente pendiente : pendientes) {
            if (pendiente.getNombre().equals(nombre)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Accion no relizada, nombre invalido", "ERROR", JOptionPane.WARNING_MESSAGE);
        return false;
        
    }
    
    
    public void sobrescribirCSV() {
        try (FileWriter writer = new FileWriter(dPendientes)) {
            for (PPendiente pendiente : pendientes) {
                writer.write(pendiente.getNombre() + "," + pendiente.getDeuda() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
