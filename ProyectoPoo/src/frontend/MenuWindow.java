package frontend;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	
	
	public MenuWindow() {
	
	    encabezadoMenu = new JLabel("MENÚ");
	    encabezadoMenu.setFont(new Font("Poor Richard", Font.BOLD, 24));
	    encabezadoMenu.setHorizontalAlignment(SwingConstants.CENTER);
	
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
}



