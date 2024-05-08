package frontend;

import backend.Inventario;
import backend.Producto;
import java.util.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import frontend.utils.Button;

public class MenuInventarioWindow extends Component {
	private JPanel panelInventario;
	private HashMap<Integer, Producto> items = new Inventario().getItems(); 
	private JPanel panelPrueba;
	private JLabel labelPrueba;
	
	private JPanel columns;
	
	
	public MenuInventarioWindow(LocalFrame localFrame) {
		int numI = items.size();
		
		panelPrueba = new JPanel();
		labelPrueba = new JLabel("Prueba");
		
		panelPrueba.add(labelPrueba);
		
        panelInventario = new JPanel(new GridLayout(numI, 3));
        
        columns = new JPanel(new GridLayout(1,3));
        columns.setBackground(Color.GRAY);
        columns.add(new JLabel("Producto"));
        columns.add(new JLabel("Cantidad en Inventario"));
        columns.add(new JLabel("Precio"));
        
        panelInventario.add(columns);
        
        for (int i = 1; i < numI; i++) {
            JPanel itemP = new JPanel(new GridLayout(1, 3));
            Producto producto = items.get(i); // Obtener el producto en la posición i

            String nP = producto.getNombreProducto();;
            JLabel productN = new JLabel(nP);
            productN.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productN);

            String pC = String.valueOf(producto.getCantidadEnInventario());;
            JLabel productC = new JLabel(pC);
            productC.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productC);

            String pP = String.valueOf(producto.getCantidadEnInventario());;
            JLabel productP = new JLabel(pP);
            productP.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productP);
    
            panelInventario.add(itemP);
        }
	}
	
	// Hace falta un boton para modificar inventario y un botón atrás
	    
	    
	    
	public JPanel getPanelInventario() {
		return this.panelInventario;
	}
	public JPanel getPanelPrueba() {
		return this.panelPrueba;
	}
}
