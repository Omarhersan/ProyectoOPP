package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PagosPendientes {
    private List<PPendiente> pendientes;
    String dPendientes = "C:\\Users\\sarim\\Documents\\6to semestre\\Proyecto\\ProyectoOPP\\ProyectoPoo\\src\\backend\\Data\\PagosP.csv";

    public List<PPendiente> lecPendientes() {
        pendientes = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(dPendientes))) {

            while ((line = br.readLine()) != null) {
                String[] pendiente = line.split(cvsSplitBy);
                pendientes.add(new PPendiente(pendiente[0], Integer.parseInt(pendiente[1])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pendientes;
    }

    public void actualizarDeuda(String nombre, double total) {
        for (PPendiente pendiente : pendientes) {
            if (pendiente.getNombre().equals(nombre)) {
                pendiente.setMasDeuda(total);
                break;
            }
        }
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
