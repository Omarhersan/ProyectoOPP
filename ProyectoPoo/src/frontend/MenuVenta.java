package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import frontend.utils.*;
import backend.*;
import java.util.*;

public class MenuVenta extends Component{
	private JPanel panelVenta;
	private HashMap<Integer, Producto> inventario = new Inventario().getItems();
	private JPanel panelBotonVenta;
	String Nombre;
	
	
	
	public MenuVenta(LocalFrame localFrame) {
		// Inicialización de paneles
		panelVenta = new JPanel();
		panelBotonVenta = new JPanel();
		JPanel ingresoIdProducto = new JPanel();
		JPanel ingresoCantidadProducto = new JPanel();
		JPanel PanelBotonVenta = new JPanel();
		
		JLabel encabezado = new JLabel("Venta");
		
		
		// Ingreso de ID y cantidad
		JLabel etiquetaID = new JLabel("Ingresa el ID del producto");
		JLabel etiquetaCantidad = new JLabel("Ingresa la cantidad en venta");
		
		JTextField campoTextoIdVenta = new JTextField(20);
		campoTextoIdVenta.setFont(new Font("Arial", Font.PLAIN, 14));  
		JTextField campoTextoCantidadVenta = new JTextField(20);
		campoTextoCantidadVenta.setFont(new Font("Arial", Font.PLAIN, 14));
		
		// Boton venta
		JButton botonVenta = new Button("Venta").getButton();
		botonVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botonVenta) {
					int idProducto = Integer.parseInt(campoTextoIdVenta.getText());
					Producto producto = inventario.get(idProducto);
					int cantidadAComprar = Integer.parseInt(campoTextoCantidadVenta.getText());
					// user input check
					if(campoTextoIdVenta.getText() == null) {
						JOptionPane.showMessageDialog(null, "Producto no encontrado", 
								"Incorrecto", JOptionPane.WARNING_MESSAGE);
		                campoTextoIdVenta.setText("");
		                campoTextoCantidadVenta.setText("");	
					}
					// checa si hay suficiente en inventario
					else if(producto.getCantidadEnInventario()<cantidadAComprar){
						JOptionPane.showMessageDialog(null, "No hay suficiente en inventario", 
								"Incorrecto", JOptionPane.WARNING_MESSAGE);
					}
					else {
						double total = producto.getPrecio()*cantidadAComprar;
						JOptionPane.showMessageDialog(null, "El total a pagar es: " + total,
								"Venta realizada", JOptionPane.INFORMATION_MESSAGE);
						producto.setCantidadEnInventario(producto.getCantidadEnInventario() - cantidadAComprar);
					}					
				}
			}
			
		});
 
		// Boton Pendiente
		JButton botonPendiente = new Button("Pendiente").getButton();
		botonPendiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				if(e.getSource() == botonPendiente) {
					int idProducto = Integer.parseInt(campoTextoIdVenta.getText());
					Producto producto = inventario.get(idProducto);
					int cantidadAComprar = Integer.parseInt(campoTextoCantidadVenta.getText());
					// user input check
					if(campoTextoIdVenta.getText() == null) {
						JOptionPane.showMessageDialog(null, "Producto no encontrado", 
								"Incorrecto", JOptionPane.WARNING_MESSAGE);
		                campoTextoIdVenta.setText("");
		                campoTextoCantidadVenta.setText("");	
					}
					// checa si hay suficiente en inventario
					else if(producto.getCantidadEnInventario()<cantidadAComprar){
						JOptionPane.showMessageDialog(null, "No hay suficiente en inventario", 
								"Incorrecto", JOptionPane.WARNING_MESSAGE);
					}
					else {
						double total = producto.getPrecio()*cantidadAComprar;
						JOptionPane.showMessageDialog(null, "El total a pagar es: " + total,
								"Venta", JOptionPane.INFORMATION_MESSAGE);
						
						Nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre a anotar:");
						PagosPendientes pagoPendiente = new PagosPendientes();
						List<PPendiente> pendientes = pagoPendiente.lecPendientes();
						if(pagoPendiente.validarNombre(Nombre)) {
							producto.setCantidadEnInventario(producto.getCantidadEnInventario() - cantidadAComprar);
							pagoPendiente.actualizarMasDeuda(Nombre, total);
							pagoPendiente.sobrescribirCSV();
							JOptionPane.showMessageDialog(null, "Se anotó a nombre de: " + Nombre, "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
						} 
						
						
						
						
						
						
					}					
				}
			}
			
		});
		
		panelVenta.add(encabezado, BorderLayout.NORTH);
		panelVenta.add(etiquetaID);
		panelVenta.add(campoTextoIdVenta);
		panelVenta.add(etiquetaCantidad);
		panelVenta.add(campoTextoCantidadVenta);
		
		panelBotonVenta.add(botonVenta, BorderLayout.SOUTH);
		panelBotonVenta.add(botonPendiente, BorderLayout.SOUTH);		
		
		
		
	}
	
	public JPanel getPanelVenta() {
		return this.panelVenta;
	}
	public JPanel getPanelBotonVenta() {
		return this.panelBotonVenta;
	}
	
}
