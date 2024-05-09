package frontend;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import frontend.utils.*;

public class MenuWindow extends Component{
	JPanel panelMenu = new JPanel();
	JLabel encabezadoMenu;
	JButton botonInventario = new Button("Inventario").getButton();
	JButton botonVenta = new Button("Venta").getButton();
	JButton botonPagosPendientes = new Button("Pagos Pendientes").getButton();
	JButton botonCorte = new Button("Corte").getButton();
	
	MenuInventarioWindow menuInventario;
	MenuVenta menuVenta;
	MenuPagosPendientes menuPagosPendientes;
	
	public MenuWindow(LocalFrame localFrame) {
	
	    encabezadoMenu = new JLabel("MENÚ");
	    encabezadoMenu.setFont(new Font("Poor Richard", Font.BOLD, 24));
	    encabezadoMenu.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    
	    // Boton Inventario
	    botonInventario.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if(e.getSource() == botonInventario) {

	    			menuInventario = new MenuInventarioWindow(localFrame);
	    			localFrame.runInventario(menuInventario);
	    		}
	    		else{
	                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
	                
	            }
	    	}
	    	
	    });
	    
	    //Boton Venta
	    botonVenta.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if(e.getSource() == botonVenta) {
	    			menuVenta = new MenuVenta(localFrame);
	    			localFrame.runVenta(menuVenta);
	    		}
				else{
	                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
	                
	            }
		botonPagosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botonPagosPendientes) {
					menuPagosPendientes = new MenuPagosPendientes(localFrame);
				}

	    	}
	    });
	    
	    
	    
	    // Adding to pane
	    panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
	    panelMenu.add(encabezadoMenu);
	    panelMenu.add(botonInventario);
	    panelMenu.add(botonVenta);
	    panelMenu.add(botonPagosPendientes);
	    panelMenu.add(botonCorte);
	
	    }
	public JPanel getPanelMenu() {
		return this.panelMenu;
	}
	public MenuInventarioWindow getMenuInventario() {
		return this.menuInventario;
	}
}



